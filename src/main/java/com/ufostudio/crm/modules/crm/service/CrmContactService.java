package com.ufostudio.crm.modules.crm.service;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.modules.crm.entity.po.CrmContactPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.github.pagehelper.PageInfo;

/**
 * @Author: LCF
 * @Date: 2020/7/5 18:47
 * @Package: com.ufostudio.crm.modules.crm.service.impl
 */

public interface CrmContactService {
    /**
     * 新增联系人
     *
     * @param loginUser
     * @param crmContactPO
     * @return
     */
    R addContact(SysUserPO loginUser, CrmContactPO crmContactPO);

    /**
     * 修改联系人
     *
     * @param loginUser
     * @param crmContactPO
     * @return
     */
    R updateContact(SysUserPO loginUser, CrmContactPO crmContactPO);

    /**
     * 根据联系人id获取单个联系人详情
     *
     * @param contactId
     * @return
     */
    Result<CrmContactPO> getContactByContactId(long contactId);

    /**
     * 获取用户联系人列表
     *
     * @param loginUser 当前登录用户
     * @param type      筛选类型，1为用户负责的联系人，2为用户数据权限上包含的联系人
     * @return
     */
    Result<PageInfo<CrmContactPO>> getUserContactList(SysUserPO loginUser, CrmContactPO crmContactPO, int type);

    /**
     * 批量删除联系人
     *
     * @return
     */
    R deleteContactBatch(Long[] ids);
}
