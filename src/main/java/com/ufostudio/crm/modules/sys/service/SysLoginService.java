package com.ufostudio.crm.modules.sys.service;

import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserTokenPO;

/**
 * 后台登录相关
 *
 * @Author: LCF
 * @Date: 2020/7/6 0:24
 * @Package: com.ufostudio.crm.modules.sys.service
 */

public interface SysLoginService {
    /**
     * 登录验证
     * @param sysUserPO 用户名和密码
     * @return
     */
    Result<SysUserTokenPO> login(SysUserPO sysUserPO);
}
