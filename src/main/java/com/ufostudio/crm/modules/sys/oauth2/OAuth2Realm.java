package com.ufostudio.crm.modules.sys.oauth2;

import com.ufostudio.crm.modules.sys.dao.SysUserPOMapper;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserTokenPO;
import com.ufostudio.crm.modules.sys.service.SysMenuService;
import com.ufostudio.crm.modules.sys.service.SysUserTokenService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:21
 * @Package: com.ufostudio.crm.modules.sys.oauth2
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private SysUserPOMapper sysUserPOMapper;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserPO user = (SysUserPO) principals.getPrimaryPrincipal();
        Long userId = user.getUserId();
        //用户权限列表
        Set<String> permsSet = sysMenuService.getUserPermissions(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        //根据accessToken，查询用户信息
        SysUserTokenPO sysUserTokenPO = sysUserTokenService.getTokenByToken(accessToken);
        //token失效
        if (sysUserTokenPO == null || sysUserTokenPO.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        SysUserPO sysUserPO = sysUserPOMapper.selectByPrimaryKey(sysUserTokenPO.getUserId());
        //账号锁定
        if (sysUserPO.getIsUsed() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUserPO, accessToken, getName());
        return info;
    }
}
