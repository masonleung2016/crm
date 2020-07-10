package com.ufostudio.crm.modules.sys.dao;

import com.ufostudio.crm.modules.sys.entity.po.SysRoleMenuPO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:14
 * @Package: com.ufostudio.crm.modules.sys.dao
 */

@Repository
public interface SysRoleMenuPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenuPO record);

    int insertSelective(SysRoleMenuPO record);

    SysRoleMenuPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenuPO record);

    int updateByPrimaryKey(SysRoleMenuPO record);

    void saveBatch(Map<String, Object> map);

    void deleteByRoleId(Long roleId);

    List<Long> queryMenuIdList(long roleId);
    
}
