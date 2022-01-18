package com.mohan.interceptor;

import com.mohan.annotation.NoToken;
import com.mohan.constant.LoginConstants;
import com.mohan.context.BaseContext;
import com.mohan.exception.BaseException;
import com.mohan.utils.jedis.JedisUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.mohan.constant.LoginConstants.AUTH_KEY;


@Slf4j
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        NoToken annotation;
        if (!(handler instanceof HandlerMethod)) {
            return true;
        } else {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(NoToken.class);
        }
        if (request.getMethod().equals("OPTIONS")){
            return true;
        }

        if(annotation != null){
            return true;
        }


        String AuthKey = request.getHeader(LoginConstants.AUTH_KEY);

        if (StringUtils.isNotBlank(request.getParameter(LoginConstants.AUTH_KEY))){
            AuthKey = request.getParameter(LoginConstants.AUTH_KEY);

        }
        if(StringUtils.isEmpty(AuthKey)){
            throw new BaseException("请携带token");
        }
        if (!AuthKey.equals(jedisUtil.get(AUTH_KEY))) {
            throw new BaseException("请携带正确token");
        }
        if (StringUtils.isNotBlank(AuthKey)){
            BaseContext.setAuthKey(AuthKey);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) throws Exception {
    }
}
