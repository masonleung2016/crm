package com.ufostudio.crm.common.utils;

import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Shiro工具类
 *
 * @Author: LCF
 * @Date: 2020/7/5 18:05
 * @Package: com.ufostudio.crm.common.utils
 */

public class ShiroUtils {

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static SysUserPO getCurrentUser() {
        return (SysUserPO) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
    }
    
}
