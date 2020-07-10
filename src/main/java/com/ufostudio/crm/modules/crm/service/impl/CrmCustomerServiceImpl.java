package com.ufostudio.crm.modules.crm.service.impl;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.common.service.BaseService;
import com.ufostudio.crm.modules.crm.dao.CrmCustomerMapper;
import com.ufostudio.crm.modules.crm.entity.po.CrmCustomer;
import com.ufostudio.crm.modules.crm.service.CrmCustomerService;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: LCF
 * @Date: 2020/7/5 18:46
 * @Package: com.ufostudio.crm.modules.crm.service.impl
 */

@Service
public class CrmCustomerServiceImpl extends BaseService implements CrmCustomerService {

    @Autowired
    private CrmCustomerMapper crmCustomerMapper;

    @Override
    public R addCustomer(SysUserPO loginUser, CrmCustomer crmCustomer) {
        crmCustomer.setChargeId(loginUser.getUserId());
        crmCustomer.setCreateBy(loginUser.getUserId());
        crmCustomerMapper.insertSelective(crmCustomer);
        return R.ok();
    }

    @Override
    public R updateCustomer(SysUserPO loginUser, CrmCustomer crmCustomer) {
        crmCustomer.setUpdateBy(loginUser.getUserId());
        crmCustomerMapper.updateByPrimaryKeySelective(crmCustomer);
        return R.ok();
    }

    @Override
    public Result<CrmCustomer> getCustomerByCustomerId(long customerId) {
        CrmCustomer crmCustomer = crmCustomerMapper.selectByPrimaryKey(customerId);
        return new Result<>(crmCustomer);
    }

    @Override
    public Result<PageInfo<CrmCustomer>> getUserCustomerList(SysUserPO loginUser, CrmCustomer crmCustomer, int type) {

        //本人负责的客户
        if (type == 1) {
            PageHelper.startPage(crmCustomer.getPage().getPageNum(), crmCustomer.getPage().getPageSize());
            Page<CrmCustomer> sysUserPOList = crmCustomerMapper.listMyChargedCustomerList(loginUser.getUserId());
            return new Result<>(new PageInfo<>(sysUserPOList));
        }

        //数据权限上能操作的客户
        if (type == 2) {
            crmCustomer.getSqlMap().put("dsf", dataScopeFilter(loginUser, "d", ""));
            PageHelper.startPage(crmCustomer.getPage().getPageNum(), crmCustomer.getPage().getPageSize());
            Page<CrmCustomer> sysUserPOList = crmCustomerMapper.listUserPermCustomerList(crmCustomer);
            return new Result<>(new PageInfo<>(sysUserPOList));
        }
        return new Result<>();
    }

    @Override
    @Transactional (rollbackFor = Exception.class)
    public R deleteCustomerBatch(Long[] ids) {
        //这里应该加一层判断，如果不是自己负责的客户是不能删除的。
        crmCustomerMapper.deleteBatch(ids);
        return R.ok();
    }
}
