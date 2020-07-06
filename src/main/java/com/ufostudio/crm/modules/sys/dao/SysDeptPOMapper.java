package com.ufostudio.crm.modules.sys.dao;

import com.ufostudio.crm.modules.sys.entity.po.SysDeptPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:12
 * @Package: com.ufostudio.crm.modules.sys.dao
 */

@Repository
public interface SysDeptPOMapper {
    int deleteByPrimaryKey(Long deptId);

    int insert(SysDeptPO record);

    int insertSelective(SysDeptPO record);

    SysDeptPO selectByPrimaryKey(Long deptId);

    int updateByPrimaryKeySelective(SysDeptPO record);

    int updateByPrimaryKey(SysDeptPO record);

    List<SysDeptPO> listSysDept(SysDeptPO sysDeptPO);

    List<SysDeptPO> listSysCompany(SysDeptPO sysDeptPO);

    List<SysDeptPO> listChildDept(SysDeptPO sysDeptPO);
}
