package com.ufostudio.crm.modules.sys.dao;

import com.ufostudio.crm.modules.sys.entity.po.SysRolePO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:14
 * @Package: com.ufostudio.crm.modules.sys.dao
 */

@Repository
public interface SysRolePOMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(SysRolePO record);

    int insertSelective(SysRolePO record);

    SysRolePO selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(SysRolePO record);

    int updateByPrimaryKey(SysRolePO record);

    List<SysRolePO> listSysRoleByUserDept(SysUserPO sysUserPO);

    List<SysRolePO> listAllRole();
}
