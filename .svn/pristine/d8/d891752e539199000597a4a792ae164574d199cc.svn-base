package com.qzh.personalCenter.aop;

import com.huidong.qzh.util.common.annotation.LoginRequired;
import com.huidong.qzh.util.common.util.CookieUtils;
import com.huidong.qzh.util.common.util.QzhResult;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 * 拦截器：记录用户操作日志，检查用户是否登录……
 *
 * @author weylan
 */
@Aspect
@Component
public class ControllerInterceptor {

    @Autowired
    RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);

    /**
     * 定义拦截规则：拦截com.huidong.qzh.standard包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(* com.qzh..*(..))" +
            " && ( @annotation(org.springframework.web.bind.annotation.RequestMapping )" +
            " || @annotation(org.springframework.web.bind.annotation.GetMapping) " +
            " || @annotation(org.springframework.web.bind.annotation.PostMapping ))")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("controllerMethodPointcut()") //指定拦截器规则；也可以直接把“execution(* com.xjj.........)”写进这里
    public Object Interceptor(ProceedingJoinPoint pjp) {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        Object result = null;

        if (isLoginRequired(method)) {
            QzhResult loginResult = isLogin(request);
            if (loginResult.getStatus() != 200) {
                result = loginResult;
            }
        }
        if (result == null) {
            try {
                result = pjp.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                result = QzhResult.error(throwable.getMessage());
            }
        }
        return result;
    }

    /**
     * 判断一个方法是否需要登录
     *
     * @param method 方法
     * @return
     */
    private boolean isLoginRequired(Method method) {
        boolean result = false;
        if (method.isAnnotationPresent(LoginRequired.class)) {
            result = method.getAnnotation(LoginRequired.class).loginRequired();
        }
        return result;
    }

    //判断是否已经登录
    private QzhResult isLogin(HttpServletRequest request) {
        String token = request.getHeader("QZH_TOKEN");
        if (StringUtils.isBlank(token)) {
            token = CookieUtils.getCookieValue(request, "QZH_TOKEN");
            if (StringUtils.isBlank(token)) {
                return QzhResult.build(400, "会话过期，请重新登陆", "");
            }
        }
        ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity("http://QZH-SSO/token/{1}", QzhResult.class, token);
        return responseEntity.getBody();
    }
}

