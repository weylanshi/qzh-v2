package com.huidong.qzh.sso.service.impl;

import com.huidong.qzh.sso.entity.EipAccounts;
import com.huidong.qzh.sso.entity.EipMember;
import com.huidong.qzh.sso.mapper.EipAccountsMapper;
import com.huidong.qzh.sso.mapper.EipMemberMapper;
import com.huidong.qzh.sso.service.EipAccountService;
import com.huidong.qzh.util.common.util.CheckStrength;
import com.huidong.qzh.util.common.util.CookieUtils;
import com.huidong.qzh.util.common.util.MD5Util;
import com.huidong.qzh.util.common.util.QzhResult;
import org.apache.axis.AxisFault;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import sdkhttp.SDKServiceBindingStub;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class EipAccountServiceImpl implements EipAccountService {

    @Autowired
    private EipAccountsMapper accountsMapper;
    @Autowired
    private EipMemberMapper memberMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;

    @SuppressWarnings("unchecked")
    @Override
    public QzhResult userLogin(String username, String password, String authCode,
                               HttpServletRequest request, HttpServletResponse response) {
        String sessionId = request.getSession().getId();
//        System.out.println("LOGINsessionId:"+sessionId);
        String sessionAuthCode = stringRedisTemplate.opsForValue().get("verifyCode:" + sessionId);
        if (!StringUtils.equalsIgnoreCase(sessionAuthCode, authCode)) {
            return QzhResult.build(403, "验证码错误");
        }
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        //判断用户是否已经登陆
//        if (redisTemplate.hasKey(REDIS_USER_SESSION_KEY + ":" + token)) {
//            return QzhResult.ok(token);
//        }
        Example example = new Example(EipAccounts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo("name", username);
        criteria.orEqualTo("phone", username);
        List<EipAccounts> accountList = accountsMapper.selectByExample(example);
        if (null == accountList || accountList.size() == 0) {
            return QzhResult.build(403, "用户名或密码错误");
        }
        EipAccounts accounts = accountList.get(0);
        if (!MD5Util.verify(password, accounts.getPassWord())) {
            return QzhResult.build(403, "用户名或密码错误");
        }
        //生成token
        //把用户信息写入redis
        accounts.setPassWord(null);
        redisTemplate.opsForValue().set(REDIS_USER_SESSION_KEY + ":" + token, accounts, 30, TimeUnit.MINUTES);


        // 添加写cookie的逻辑，cookie的有效期是关闭浏览器失效
        CookieUtils.setCookie(request, response, "QZH_TOKEN", token);
        return QzhResult.ok(token);
    }


    @Override
    public QzhResult getUserByToken(String token) {
        EipAccounts user = this.getUserObjectByToken(token);
        if (null == user) {
            return QzhResult.build(400, "会话过期，请重新登陆");
        }
        return QzhResult.ok(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public EipAccounts getUserObjectByToken(String token) {
        //从redis中获取用户信息
        EipAccounts user = (EipAccounts) redisTemplate.opsForValue().get(REDIS_USER_SESSION_KEY + ":" + token);
        //更新过期时间
        redisTemplate.expire(REDIS_USER_SESSION_KEY + ":" + token, 30, TimeUnit.MINUTES);
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public QzhResult logout(String token) {
        //从redis中获取用户信息
        try {
            EipAccounts user = (EipAccounts) redisTemplate.opsForValue().get(REDIS_USER_SESSION_KEY + ":" + token);
            if (null == user) {
                return QzhResult.build(400, "会话过期，请重新登陆");
            }
            redisTemplate.delete(REDIS_USER_SESSION_KEY + ":" + token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return QzhResult.ok();
    }

    /**
     * 验证手机是否已经使用
     *
     * @param phone
     * @return
     */
    @Override
    public Boolean verifyPhone(String phone) {
        boolean matches = phone.matches("^[1][3,4,5,7,8][0-9]{9}$");
        if (!matches) return Boolean.FALSE;
        Example example = new Example(EipAccounts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("phone", phone);
        List<EipAccounts> accountList = accountsMapper.selectByExample(example);
        if (accountList.size() > 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public QzhResult register(String phone, String authCode, String password, String companyName, String nickName, HttpServletRequest request) {
        try {
            if (phone == null) return QzhResult.build(403, "手机号不能为空!");
            if (!this.verifyPhone(phone)) return QzhResult.build(403, "该账号号已注册,或不可用!");
            String oldCode = stringRedisTemplate.opsForValue().get("mobileCode:" + request.getSession().getId());
            if (oldCode == null) return QzhResult.build(403, "验证码错误!");
            if (!StringUtils.equals(authCode, oldCode)) return QzhResult.build(403, "验证码错误!");
            if (password == null) return QzhResult.build(403, "密码不能为空!");
            //验证密码强度
            if (CheckStrength.checkPasswordStrength(password) < 3) return QzhResult.build(403, "密码过于简单!");
            EipMember member = new EipMember();
            member.setName(companyName);
            member.setFlag(1);
            member.setMobile(phone);
            member.setNickName(nickName);
            memberMapper.insert(member);
            EipAccounts newAccount = new EipAccounts();
            newAccount.setPhone(phone);
            newAccount.setPassWord(MD5Util.generate(password));
            newAccount.setName(nickName);
            newAccount.setNikeName(nickName);
            newAccount.setMemberId(member.getId());
            newAccount.setStatus(1);
            accountsMapper.insert(newAccount);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(403, "失败注册!", e.getMessage());
        }
        return QzhResult.ok("注册成功!");
    }

    @Override
    public Boolean delUser(String phone) {
        try {
            EipAccounts sel = new EipAccounts();
            sel.setPhone(phone);
            EipAccounts accounts = accountsMapper.selectOne(sel);
            memberMapper.deleteByPrimaryKey(accounts.getMemberId());
            accountsMapper.delete(accounts);
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public QzhResult verifyMobileCode(String phone, String authCode, HttpServletRequest request) throws Exception {
        String sessionId = request.getSession().getId();
        String sessionAuthCode = stringRedisTemplate.opsForValue().get("mobileCode:" + sessionId + "_" + phone);
        if (!StringUtils.equals(sessionAuthCode, authCode)) {
            return QzhResult.build(403, "验证码错误!");
        }
        stringRedisTemplate.opsForValue().set("editPwdTime:" + sessionId + "_" + phone, phone + " is editing...", 3, TimeUnit.MINUTES);
        return QzhResult.ok("验证通过,请在3分钟内完成修改密码操作!", "");
    }

    @Override
    public QzhResult editUserPass(String phone, String pwd, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        String sessionAuthCode = stringRedisTemplate.opsForValue().get("editPwdTime:" + sessionId + "_" + phone);
        if (StringUtils.isBlank(sessionAuthCode)) {
            return QzhResult.build(403, "操作时间过长,请重新获取验证码!");
        }
        //验证密码强度
        if (CheckStrength.checkPasswordStrength(pwd) < 3) return QzhResult.build(403, "密码未由数字密码组成或过于简单!");
        String md5pwd = MD5Util.generate(pwd);
        try {
            EipAccounts accounts = new EipAccounts();
            accounts.setPhone(phone);
            EipAccounts oldAccount = accountsMapper.selectOne(accounts);
            oldAccount.setPassWord(md5pwd);
            accountsMapper.updateByPrimaryKey(oldAccount);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error("密码修改失败!");
        }
        return QzhResult.ok("修改成功,请重新登录!");
    }


}
