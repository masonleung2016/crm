package com.ufostudio.crm.modules.sys.service;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.modules.sys.entity.po.SysRolePO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;

/**
 * @Author: LCF
 * @Date: 2020/7/6 0:33
 * @Package: com.ufostudio.crm.modules.sys.service
 */

public interface SysRoleService {
    /**
     * 添加角色
     *
     * @param loginUser 当前登录用户
     * @param sysRolePO 角色信息
     */
    void addRole(SysUserPO loginUser, SysRolePO sysRolePO);

    /**
     * 删除角色
     *
     * @param roleId
     */
    void deleteRole(long roleId);

    /**
     * 修改角色
     *
     * @param loginUser 当前登录用户
     * @param sysRolePO
     */
    R updateRole(SysUserPO loginUser, SysRolePO sysRolePO);

    /**
     * 获取单个角色信息
     *
     * @param roleId
     * @return
     */
    Result<SysRolePO> getRole(long roleId);

}
