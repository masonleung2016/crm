package com.ufostudio.crm.modules.sys.controller;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.common.utils.ShiroUtils;
import com.ufostudio.crm.modules.sys.entity.po.SysRolePO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.service.SysRoleDeptService;
import com.ufostudio.crm.modules.sys.service.SysRoleService;
import com.ufostudio.crm.modules.sys.service.SysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 角色相关
 *
 * @Author: LCF
 * @Date: 2020/7/5 22:11
 * @Package: com.ufostudio.crm.modules.sys.controller
 */

@Controller
@RequestMapping ("/sys/role")
@ResponseBody
@Api (value = "后台角色相关")
public class SysRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    @RequestMapping (value = "/list", method = RequestMethod.POST, produces = "application/json")
    @RequiresPermissions ("sys:role:list")
    @ApiOperation (nickname = "list", value = "获取角色列表", notes = "获取角色列表\n权限：sys:role:list")
    public R list(@RequestBody SysUserPO sysUserPO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        return sysRoleDeptService.listSysRoleByUserDept(loginUser, sysUserPO);
    }

    @RequestMapping (value = "/add", method = RequestMethod.POST, produces = "application/json")
    @RequiresPermissions ("sys:role:save")
    @ApiOperation (nickname = "list", value = "新增角色", notes = "新增角色\n权限：sys:role:save")
    public R save(@RequestBody SysRolePO sysRolePO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        sysRoleService.addRole(loginUser, sysRolePO);
        return R.ok();
    }

    @RequestMapping (value = "/{roleId}", method = RequestMethod.DELETE)
    @RequiresPermissions ("sys:role:delete")
    @ApiOperation (nickname = "delete", value = "删除角色", notes = "删除角色\n权限：sys:role:delete")
    public R delete(@PathVariable ("roleId") long roleId) {
        sysRoleService.deleteRole(roleId);
        return R.ok();
    }

    @RequestMapping (value = "/update", method = RequestMethod.POST, produces = "application/json")
    @RequiresPermissions ("sys:role:update")
    @ApiOperation (nickname = "update", value = "修改角色", notes = "修改角色\n权限：sys:role:update")
    public R update(@RequestBody SysRolePO sysRolePO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        return sysRoleService.updateRole(loginUser, sysRolePO);
    }

    @RequestMapping (value = "/info/{roleId}", method = RequestMethod.GET)
    @RequiresPermissions ("sys:role:info")
    @ApiOperation (nickname = "info", value = "获取单个角色信息", notes = "获取单个角色信息\n权限：sys:role:list\nsys:role:info")
    public Result<SysRolePO> info(@PathVariable (value = "roleId") long roleId) {
        return sysRoleService.getRole(roleId);
    }

}
