package com.ufostudio.crm.modules.sys.dao;

import com.ufostudio.crm.modules.sys.entity.po.SysRoleDeptPO;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:13
 * @Package: com.ufostudio.crm.modules.sys.dao
 */

@Repository
public interface SysRoleDeptPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDeptPO record);

    int insertSelective(SysRoleDeptPO record);

    SysRoleDeptPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleDeptPO record);

    int updateByPrimaryKey(SysRoleDeptPO record);

    void deleteByRoleId(Long roleId);

    void saveBatch(Map<String, Object> map);
}
