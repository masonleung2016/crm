package com.ufostudio.crm.modules.crm.dao;

import com.ufostudio.crm.modules.crm.entity.po.CrmContactPO;
import com.ufostudio.crm.modules.crm.entity.po.CrmContactPOExample;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 18:37
 * @Package: com.ufostudio.crm.modules.crm.dao
 */

@Repository
public interface CrmContactPOMapper {
    long countByExample(CrmContactPOExample example);

    int deleteByExample(CrmContactPOExample example);

    int deleteByPrimaryKey(Long contactId);

    int insert(CrmContactPO record);

    int insertSelective(CrmContactPO record);

    List<CrmContactPO> selectByExample(CrmContactPOExample example);

    CrmContactPO selectByPrimaryKey(Long contactId);

    int updateByExampleSelective(@Param ("record") CrmContactPO record, @Param ("example") CrmContactPOExample example);

    int updateByExample(@Param ("record") CrmContactPO record, @Param ("example") CrmContactPOExample example);

    int updateByPrimaryKeySelective(CrmContactPO record);

    int updateByPrimaryKey(CrmContactPO record);

    Page<CrmContactPO> listMyChargedContactList(Long userId);

    Page<CrmContactPO> listUserPermContactList(CrmContactPO crmContactPO);

    void deleteBatch(Long[] ids);
    
}
