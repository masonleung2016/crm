package com.ufostudio.crm.modules.sys.annotation;

import com.ufostudio.crm.modules.sys.dao.SysUserPOMapper;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserTokenPO;
import com.ufostudio.crm.modules.sys.oauth2.OAuth2Filter;
import com.ufostudio.crm.modules.sys.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 有@SysLoginUser注解的方法参数，注入当前登录用户
 *
 * @Author: LCF
 * @Date: 2020/7/5 22:08
 * @Package: com.ufostudio.crm.modules.sys.annotation
 */

@Component
public class SysLoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private SysUserPOMapper sysUserPOMapper;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(SysUserPO.class) && parameter.hasParameterAnnotation(SysLoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest request, WebDataBinderFactory binderFactory) throws Exception {
        //获取用户id
        Object object = request.getAttribute(OAuth2Filter.SYS_LOGIN_USER_KEY, RequestAttributes.SCOPE_REQUEST);
        System.out.println(object);
        if (object == null) {
            return null;
        }
        SysUserTokenPO sysUserTokenPO = sysUserTokenService.getTokenByToken((String) object);
        return sysUserPOMapper.selectByPrimaryKey(sysUserTokenPO.getUserId());
    }
}
