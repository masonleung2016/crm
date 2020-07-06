package com.ufostudio.crm.modules.sys.oauth2;

import com.ufostudio.crm.common.entity.R;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * oauth2过滤器
 *
 * @Author: LCF
 * @Date: 2020/7/5 22:20
 * @Package: com.ufostudio.crm.modules.sys.oauth2
 */

public class OAuth2Filter extends AuthenticatingFilter {

    public static final String SYS_LOGIN_USER_KEY = "SYS_LOGIN_USER_KEY";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token，如果token不存在，直接返回401
        String token = getRequestToken((HttpServletRequest) request);
        if (StringUtils.isBlank(token)) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String json = new Gson().toJson(R.error(-1, "invalid token"));
            httpResponse.getWriter().print(json);
            httpResponse.setHeader("Content-Type", "application/json;charset=utf-8");
            return false;
        }
        return executeLogin(request, response);
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest) servletRequest);
        servletRequest.setAttribute(SYS_LOGIN_USER_KEY, token);
        return new OAuth2Token(token);
    }


    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        //处理登录失败的异常
        try {
            String json;
            if (e instanceof IncorrectCredentialsException) {
                R r = R.error(-1001, "token失效，请重新登录");
                json = new Gson().toJson(r);
            } else {
                Throwable throwable = e.getCause() == null ? e : e.getCause();
                R r = R.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), throwable.getMessage());
                json = new Gson().toJson(r);
            }
            httpResponse.addHeader("Access-Control-Allow-Origin", "*");
            httpResponse.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE,HEAD");
            httpResponse.addHeader("Access-Control-Allow-Headers", "token,content-type");
            httpResponse.getWriter().print(json);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    /**
     * 获取请求的token
     */
    private String getRequestToken(HttpServletRequest httpRequest) {
        //从header中获取token
        String token = httpRequest.getHeader("token");

        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getParameter("token");
        }
        return token;
    }
}
