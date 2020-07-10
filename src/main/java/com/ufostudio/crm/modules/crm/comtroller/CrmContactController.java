package com.ufostudio.crm.modules.crm.comtroller;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.common.utils.ShiroUtils;
import com.ufostudio.crm.modules.crm.entity.po.CrmContactPO;
import com.ufostudio.crm.modules.crm.service.CrmContactService;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LCF
 * @Date: 2020/7/5 18:34
 * @Package: com.ufostudio.crm.modules.crm.comtroller
 */

@Controller
@RequestMapping ("/crm/contact")
@ResponseBody
@Api (value = "联系人相关操作")
public class CrmContactController {

    @Autowired
    private CrmContactService crmContactService;

    @RequestMapping (value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation (value = "新增联系人", notes = "新增联系人\n权限：crm:contact:save")
    @RequiresPermissions ("crm:contact:save")
    public R add(@RequestBody CrmContactPO crmContactPO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        crmContactService.addContact(loginUser, crmContactPO);
        return R.ok();
    }

    @RequestMapping (value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation (value = "修改联系人", notes = "修改联系人\n权限：crm:contact:update")
    @RequiresPermissions ("crm:contact:update")
    public R update(@RequestBody CrmContactPO crmContactPO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        crmContactService.updateContact(loginUser, crmContactPO);
        return R.ok();
    }

    @RequestMapping (value = "/list/{type}", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation (nickname = "list/{type}", value = "【分页】获取联系人列表，type传1为获取当前用户负责的联系人，2为当前用户能操作的联系人",
            notes = "【分页】获取用户联系人，type传1为获取当前用户负责的联系人，2为当前用户能操作的联系人\n权限：crm:contact:list")
    @RequiresPermissions ("crm:contact:list")
    public Result<PageInfo<CrmContactPO>> contactALlList(@PathVariable ("type") int type, @RequestBody CrmContactPO crmContactPO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        return crmContactService.getUserContactList(loginUser, crmContactPO, type);
    }

    @RequestMapping (value = "/{contactId}", method = RequestMethod.GET)
    @ApiOperation (nickname = "info", value = "获取单个联系人详细信息", notes = "获取单个联系人详细信息\n权限：crm:contact:info")
    @RequiresPermissions ("crm:contact:info")
    public Result<CrmContactPO> getContactByContactId(@PathVariable ("contactId") long contactId) {
        return crmContactService.getContactByContactId(contactId);
    }

    @RequestMapping (value = "/delete", method = RequestMethod.POST, produces = "application/json")
    @RequiresPermissions ("crm:contact:delete")
    @ApiOperation (nickname = "delete", value = "删除联系人 Ps：参数为数组",
            notes = "删除联系人 Ps：参数为数组\n权限：crm:contact:delete")
    public R delete(@RequestBody Long[] ids) {
        return crmContactService.deleteContactBatch(ids);
    }
}
