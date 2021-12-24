package com.mohan.interceptor;

import com.mohan.constant.LoginConstants;
import com.mohan.context.BaseContext;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        String AuthKey =null;
        if (StringUtils.isNotBlank(request.getHeader(LoginConstants.AUTH_KEY))){
             AuthKey = request.getHeader(LoginConstants.AUTH_KEY);
        }
        if (StringUtils.isNotBlank(request.getParameter(LoginConstants.AUTH_KEY))){
             AuthKey = request.getParameter(LoginConstants.AUTH_KEY);

        }
        if (StringUtils.isNotBlank(AuthKey)){
            BaseContext.setAuthKey(AuthKey);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
