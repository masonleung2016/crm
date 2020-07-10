package com.ufostudio.crm.modules.sys.controller;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.common.utils.ShiroUtils;
import com.ufostudio.crm.modules.sys.entity.po.SysDeptPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:09
 * @Package: com.ufostudio.crm.modules.sys.controller
 */

@Controller
@RequestMapping ("/sys/dept")
@ResponseBody
@Api (value = "后台部门相关")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @RequestMapping (value = "/list", method = RequestMethod.GET)
    @ApiOperation (nickname = "user/list", value = "部门列表", notes = "部门列表", authorizations = {
            @Authorization (value = "petoauth",
                    scopes = {@AuthorizationScope (scope = "sys:dept:list", description = "allows adding of pets")})
    })
    
    @RequiresPermissions ("sys:dept:list")
    public R deptALlList() {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        List<SysDeptPO> deptList = sysDeptService.listSysDept(loginUser);
        return R.ok().put("deptList", deptList);
    }

    @RequestMapping (value = "/company/list", method = RequestMethod.GET)
    @ApiOperation (nickname = "company/list", value = "公司列表", notes = "公司列表\n权限：sys:dept:info")
    @RequiresPermissions ("sys:dept:list")
    public R listSysCompany() {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        List<SysDeptPO> deptList = sysDeptService.listSysCompany(loginUser);
        return R.ok().put("deptList", deptList);
    }

    @RequestMapping (value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation (value = "新增部门", notes = "新增部门\n权限：sys:dept:save")
    @RequiresPermissions ("sys:dept:save")
    public R addDept(@RequestBody SysDeptPO sysDeptPO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        sysDeptService.addDept(loginUser, sysDeptPO);
        return R.ok();
    }

    @RequestMapping (value = "/{deptId}", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation (value = "删除部门", notes = "删除部门\n权限：sys:dept:delete")
    @RequiresPermissions ("sys:dept:delete")
    public R deleteDept(@PathVariable ("deptId") long deptId) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        return sysDeptService.deleteDept(loginUser, deptId);
    }

    @RequestMapping (value = "/{deptId}", method = RequestMethod.GET)
    @ApiOperation (nickname = "info", value = "获取单个部门信息", notes = "获取单个部门信息\n权限：sys:dept:info")
    @RequiresPermissions ("sys:dept:info")
    public Result<SysDeptPO> getDeptByDeptId(@PathVariable ("deptId") long deptId) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        return sysDeptService.getDeptByDeptId(loginUser, deptId);
    }

    @RequestMapping (value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation (value = "修改部门", notes = "修改部门\n权限：sys:dept:update")
    @RequiresPermissions ("sys:dept:update")
    public R update(@RequestBody SysDeptPO sysDeptPO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        sysDeptService.updateDept(loginUser, sysDeptPO);
        return R.ok();
    }
}
