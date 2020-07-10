package com.ufostudio.crm.modules.sys.dao;

import com.ufostudio.crm.modules.sys.entity.po.SysUserTokenPO;
import org.springframework.stereotype.Repository;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:16
 * @Package: com.ufostudio.crm.modules.sys.dao
 */

@Repository
public interface SysUserTokenPOMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUserTokenPO record);

    int insertSelective(SysUserTokenPO record);

    SysUserTokenPO selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUserTokenPO record);

    int updateByPrimaryKey(SysUserTokenPO record);

    SysUserTokenPO getTokenByToken(String token);
    
}
