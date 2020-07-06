package com.ufostudio.crm.modules.sys.dao;

import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:15
 * @Package: com.ufostudio.crm.modules.sys.dao
 */

@Repository
public interface SysUserPOMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUserPO record);

    int insertSelective(SysUserPO record);

    SysUserPO selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUserPO record);

    int updateByPrimaryKey(SysUserPO record);

    SysUserPO getUserByUserName(String username);

    SysUserPO queryByMobile(String username);

    Page<SysUserPO> listSysUser(SysUserPO sysUserPO);

    int deleteBatch(Long[] userId);

    int updateLoginIPAndTime(SysUserPO sysUserPO);
}
