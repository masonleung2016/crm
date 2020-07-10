package com.ufostudio.crm.modules.sys.controller;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.common.utils.ShiroUtils;
import com.ufostudio.crm.common.validator.ValidatorUtils;
import com.ufostudio.crm.common.validator.group.AddGroup;
import com.ufostudio.crm.common.validator.group.UpdateGroup;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.service.SysUserService;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关
 *
 * @Author: LCF
 * @Date: 2020/7/5 22:11
 * @Package: com.ufostudio.crm.modules.sys.controller
 */

@Controller
@RequestMapping ("/sys/user")
@ResponseBody
@Api (value = "后台用户相关")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 保存用户
     */
    @RequestMapping (value = "/save", method = RequestMethod.POST, produces = "application/json")
    @RequiresPermissions ("sys:user:save")
    @ApiOperation (nickname = "save", value = "新增用户", notes = "新增用户\n权限：sys:user:save")
    public R save(@RequestBody SysUserPO sysUserPO) {
        ValidatorUtils.validateEntity(sysUserPO, AddGroup.class);
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        return sysUserService.createUser(loginUser, sysUserPO);
    }

    @RequestMapping (value = "/list", method = RequestMethod.POST, produces = "application/json")
    @RequiresPermissions ("sys:user:list")
    @ApiOperation (nickname = "list", value = "【分页】获取用户列表",
            notes = "【分页】获取用户列表\n权限：sys:user:list")
    public Result<PageInfo<SysUserPO>> list(@RequestBody SysUserPO sysUserPO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        return sysUserService.listUser(loginUser, sysUserPO);
    }

    @RequestMapping (value = "/update", method = RequestMethod.POST, produces = "application/json")
    @RequiresPermissions ("sys:user:update")
    @ApiOperation (nickname = "update", value = "修改用户信息",
            notes = "修改用户信息\n权限：sys:user:update")
    public R update(@RequestBody SysUserPO sysUserPO) {
        ValidatorUtils.validateEntity(sysUserPO, UpdateGroup.class);
        return sysUserService.updateUser(sysUserPO);
    }

    @RequestMapping (value = "/delete", method = RequestMethod.POST, produces = "application/json")
    @RequiresPermissions ("sys:user:delete")
    @ApiOperation (nickname = "delete", value = "删除用户 Ps：参数为数组",
            notes = "删除用户 Ps：参数为数组\n权限：sys:user:delete")
    public R delete(@RequestBody Long[] userIds) {
        return sysUserService.deleteUser(userIds);
    }

    @RequestMapping (value = "/{userId}", method = RequestMethod.GET)
    @RequiresPermissions ("sys:user:info")
    @ApiOperation (nickname = "info", value = "获取单个用户信息", notes = "获取单个用户信息\n权限：sys:user:info")
    public Result<SysUserPO> info(@PathVariable (value = "userId") long userId) {
        return sysUserService.getUserByUserId(userId);
    }
}
