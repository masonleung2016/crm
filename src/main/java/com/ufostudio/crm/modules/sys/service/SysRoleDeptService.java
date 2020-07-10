package com.ufostudio.crm.modules.sys.service;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;

import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/6 0:26
 * @Package: com.ufostudio.crm.modules.sys.service
 */

public interface SysRoleDeptService {
    /**
     * 新增或修改角色和机构关系
     * @param roleId
     * @param deptIdList
     */
    void saveOrUpdate(Long roleId, List<Long> deptIdList);

    /**
     * 根据机构id查询所有角色
     * @param sysUserPO
     * @return
     */
    R listSysRoleByUserDept(SysUserPO loginUser, SysUserPO sysUserPO);
}
