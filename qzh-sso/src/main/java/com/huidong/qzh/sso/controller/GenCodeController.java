package com.huidong.qzh.sso.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.huidong.qzh.sso.service.EipAccountService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdkhttp.SDKServiceBindingStub;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
public class GenCodeController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private EipAccountService accountService;

    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();

    /**
     * 生成图片验证码
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping("/genAuthCode")
    public void genAuthCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        byte[] captchaChallengeAsJpeg = null;
        try {
            captchaChallengeAsJpeg = authCode2Byte(httpServletRequest);
        } catch (IOException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/png");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @RequestMapping("/webGenAuthCode")
    public String genAuthCode(HttpServletRequest httpServletRequest) throws Exception {
        byte[] captchaChallengeAsJpeg = authCode2Byte(httpServletRequest);
        return encoder.encodeBuffer(captchaChallengeAsJpeg).trim();

    }

    private byte[] authCode2Byte(HttpServletRequest httpServletRequest) throws IOException {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        //生产验证码字符串并保存到session中
        String createText = defaultKaptcha.createText();
        String sessionId = httpServletRequest.getSession().getId();
        stringRedisTemplate.opsForValue().set("verifyCode:" + sessionId, createText, 3, TimeUnit.MINUTES);
        //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
        BufferedImage challenge = defaultKaptcha.createImage(createText);
        ImageIO.write(challenge, "png", jpegOutputStream);
        //定义response输出类型为image/png类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        return captchaChallengeAsJpeg;
    }

    /**
     * 获取手机验证码
     *
     * @param phone 手机号
     */
    @RequestMapping("/genMobileCode/{phone}")
    public QzhResult genMobileCode(@PathVariable String phone, HttpServletRequest request) throws Exception {
        Boolean isUsable = accountService.verifyPhone(phone);
        if (!isUsable) return QzhResult.error("该手机号不可用!");
        String sessionId = request.getSession().getId();
        String oldCode = stringRedisTemplate.opsForValue().get("mobileCode:" + sessionId);
        if (oldCode != null) {
            Long expireTime = stringRedisTemplate.getExpire("mobileCode:" + sessionId, TimeUnit.SECONDS);
            return QzhResult.error(expireTime + "s重新获取");
        }
        SDKServiceBindingStub sdkServiceBindingStub = new SDKServiceBindingStub();
        String yanzhengma = sdkServiceBindingStub.yanzhengma(phone);
        if (StringUtils.equals("失败", yanzhengma)) {
            return QzhResult.error("验证码发送失败");
        }
        stringRedisTemplate.opsForValue().set("mobileCode:" + sessionId, yanzhengma, 1, TimeUnit.MINUTES);
        return QzhResult.ok();

    }

    /**
     * 忘记密码验证码
     *
     * @param phone 手机号
     */
    @RequestMapping("/genForgotCode/{phone}")
    public QzhResult genForgotCode(@PathVariable String phone, HttpServletRequest request) throws Exception {
        String sessionId = request.getSession().getId();
        String oldCode = stringRedisTemplate.opsForValue().get("mobileCode:" + sessionId);
        if (oldCode != null) {
            Long expireTime = stringRedisTemplate.getExpire("mobileCode:" + sessionId, TimeUnit.SECONDS);
            return QzhResult.error(expireTime + "s重新获取");
        }
        String content = "您的验证码为:";
        SDKServiceBindingStub sdkServiceBindingStub = new SDKServiceBindingStub();
        String yanzhengma = sdkServiceBindingStub.sjdxtx(content, phone);
        if (StringUtils.equals("失败", yanzhengma)) {
            return QzhResult.error("验证码发送失败");
        }
        stringRedisTemplate.opsForValue().set("mobileCode:" + sessionId + "_" + phone, yanzhengma, 1, TimeUnit.MINUTES);
        return QzhResult.ok();

    }


}
