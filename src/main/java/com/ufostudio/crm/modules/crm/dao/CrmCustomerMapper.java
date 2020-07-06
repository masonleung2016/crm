package com.ufostudio.crm.modules.crm.dao;

import com.ufostudio.crm.modules.crm.entity.po.CrmCustomer;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

/**
 * @Author: LCF
 * @Date: 2020/7/5 18:39
 * @Package: com.ufostudio.crm.modules.crm.dao
 */

@Repository
public interface CrmCustomerMapper {

    int deleteByPrimaryKey(Long customerId);

    int insert(CrmCustomer record);

    int insertSelective(CrmCustomer record);

    CrmCustomer selectByPrimaryKey(Long customerId);

    int updateByPrimaryKeySelective(CrmCustomer record);

    int updateByPrimaryKey(CrmCustomer record);

    //批量删除客户
    int deleteBatch(Long[] ids);

    //用户负责的客户列表
    Page<CrmCustomer> listMyChargedCustomerList(Long chargeId);

    //用户数据权限上的客户列表
    Page<CrmCustomer> listUserPermCustomerList(CrmCustomer crmCustomer);

}
