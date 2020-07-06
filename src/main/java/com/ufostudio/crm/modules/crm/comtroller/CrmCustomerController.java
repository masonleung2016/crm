package com.ufostudio.crm.modules.crm.comtroller;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.common.utils.ShiroUtils;
import com.ufostudio.crm.modules.crm.entity.po.CrmCustomer;
import com.ufostudio.crm.modules.crm.service.CrmCustomerService;
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
 * @Date: 2020/7/5 18:36
 * @Package: com.ufostudio.crm.modules.crm.comtroller
 */

@Controller
@RequestMapping ("/crm/customer")
@ResponseBody
@Api (value = "客户相关操作")
public class CrmCustomerController {

    @Autowired
    private CrmCustomerService crmCustomerService;

    @RequestMapping (value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation (value = "新增客户", notes = "新增客户\n权限：crm:customer:save")
    @RequiresPermissions ("crm:customer:save")
    public R add(@RequestBody CrmCustomer crmCustomer) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        crmCustomerService.addCustomer(loginUser, crmCustomer);
        return R.ok();
    }

    @RequestMapping (value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation (value = "修改客户", notes = "修改客户\n权限：crm:customer:update")
    @RequiresPermissions ("crm:customer:update")
    public R update(@RequestBody CrmCustomer crmCustomer) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        crmCustomerService.updateCustomer(loginUser, crmCustomer);
        return R.ok();
    }

    @RequestMapping (value = "/list/{type}", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation (nickname = "list/{type}", value = "【分页】获取客户列表，type传1为获取当前用户负责的客户，2为当前用户能操作的客户",
            notes = "【分页】获取用户客户，type传1为获取当前用户负责的客户，2为当前用户能操作的客户\n权限：crm:customer:list")
    @RequiresPermissions ("crm:customer:list")
    public Result<PageInfo<CrmCustomer>> customerALlList(@PathVariable ("type") int type, @RequestBody CrmCustomer crmCustomer) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        return crmCustomerService.getUserCustomerList(loginUser, crmCustomer, type);
    }

    @RequestMapping (value = "/{customerId}", method = RequestMethod.GET)
    @ApiOperation (nickname = "info", value = "获取单个客户详细信息", notes = "获取单个客户详细信息\n权限：crm:customer:info")
    @RequiresPermissions ("crm:customer:info")
    public Result<CrmCustomer> getCustomerByCustomerId(@PathVariable ("customerId") long customerId) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        return crmCustomerService.getCustomerByCustomerId(customerId);
    }

    @RequestMapping (value = "/delete", method = RequestMethod.POST, produces = "application/json")
    @RequiresPermissions ("crm:customer:delete")
    @ApiOperation (nickname = "delete", value = "删除客户 Ps：参数为数组",
            notes = "删除客户 Ps：参数为数组\n权限：crm:customer:delete")
    public R delete(@RequestBody Long[] ids) {
        return crmCustomerService.deleteCustomerBatch(ids);
    }

}
