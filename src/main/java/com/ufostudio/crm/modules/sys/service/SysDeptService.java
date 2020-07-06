package com.ufostudio.crm.modules.sys.service;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.modules.sys.entity.po.SysDeptPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;

import java.util.List;

/**
 * 部门
 *
 * @Author: LCF
 * @Date: 2020/7/5 22:34
 * @Package: com.ufostudio.crm.modules.sys.service.impl
 */

public interface SysDeptService {
    /**
     * 获取系统部门
     *
     * @param loginUser
     * @return
     */
    List<SysDeptPO> listSysDept(SysUserPO loginUser);

    /**
     * 获取系统公司
     *
     * @param loginUser
     * @return
     */
    List<SysDeptPO> listSysCompany(SysUserPO loginUser);

    /**
     * 增加系统部门
     *
     * @param loginUser
     * @param sysDeptPO
     * @return
     */
    R addDept(SysUserPO loginUser, SysDeptPO sysDeptPO);

    /**
     * 删除系统部门
     *
     * @param loginUser
     * @param deptId
     * @return
     */
    R deleteDept(SysUserPO loginUser, long deptId);

    /**
     * 根据id获取单个部门信息
     *
     * @param loginUser
     * @param deptId
     * @return
     */
    Result<SysDeptPO> getDeptByDeptId(SysUserPO loginUser, long deptId);

    /**
     * 修改系统部门
     *
     * @param loginUser
     * @param sysDeptPO
     * @return
     */
    R updateDept(SysUserPO loginUser, SysDeptPO sysDeptPO);

}
