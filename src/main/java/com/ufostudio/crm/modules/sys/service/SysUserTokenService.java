package com.ufostudio.crm.modules.sys.service;

import com.ufostudio.crm.modules.sys.entity.po.SysUserTokenPO;

/**
 * @Author: LCF
 * @Date: 2020/7/6 0:36
 * @Package: com.ufostudio.crm.modules.sys.service
 */

public interface SysUserTokenService {
    /**
     * 生成用户token
     * @param userId
     * @return
     */
    SysUserTokenPO createToken(long userId);

    /**
     * 根据用户id获取用户token
     * @param userId
     * @return
     */
    SysUserTokenPO getTokenByUserId(long userId);

    /**
     * 根据token值获取用户token
     * @param token
     * @return
     */
    SysUserTokenPO getTokenByToken(String token);

}
