package com.ufostudio.crm.modules.sys.controller;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.common.exception.RRException;
import com.ufostudio.crm.common.utils.ShiroUtils;
import com.ufostudio.crm.modules.sys.entity.po.SysMenuPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.service.SysMenuService;
import com.ufostudio.crm.common.enums.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:10
 * @Package: com.ufostudio.crm.modules.sys.controller
 */

@Controller
@RequestMapping ("/sys/menu")
@ResponseBody
@Api (value = "后台菜单相关")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping (value = "/list", method = RequestMethod.GET)
    @ApiOperation (nickname = "list", value = "当前用户菜单列表（不带button）", notes = "渲染菜单接口，附带权限信息，和用户信息")
    public R list() {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        List<SysMenuPO> menuList = sysMenuService.getUserMenuList(loginUser.getUserId());
        Set<String> permissionList = sysMenuService.getUserPermissions(loginUser.getUserId());
        return R.ok().put("menu", menuList)
                .put("permissions", permissionList)
                .put("user", loginUser);
    }

    @RequestMapping (value = "/deptALlList", method = RequestMethod.GET)
    @ApiOperation (nickname = "listDeptMenuWithButton", value = "当前用户所在公司菜单列表（不带button）", notes = "当前用户所在公司菜单列表（带button）")
    public R deptALlList() {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        List<SysMenuPO> menuList = sysMenuService.listDeptMenu(loginUser.getUserId());
        return R.ok().put("menuList", menuList);
    }

    @RequestMapping (value = "/listDeptMenuWithButton", method = RequestMethod.GET)
    @ApiOperation (nickname = "listDeptMenuWithButton", value = "当前用户所在公司菜单列表（带button）", notes = "当前用户所在公司菜单列表（带button）")
    public R listDeptMenuWithButton() {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        List<SysMenuPO> menuList = sysMenuService.listDeptMenuWithButton(loginUser.getUserId());
        return R.ok().put("menuList", menuList);
    }

    @RequestMapping (value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation (value = "新增菜单", notes = "新增菜单\n权限：sys:menu:save")
    @RequiresPermissions ("sys:menu:save")
    public R addMenu(@RequestBody SysMenuPO sysMenuPO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        if (!loginUser.isAdmin()) {
            return R.error("非管理员用户无权添加菜单");
        }
        //数据校验
        verifyForm(sysMenuPO);
        sysMenuService.addMenu(sysMenuPO);
        return R.ok();
    }

    @RequestMapping (value = "/{meunId}", method = RequestMethod.GET)
    @ApiOperation (value = "根据菜单id获取单个菜单信息", notes = "根据菜单id获取单个菜单信息\n权限：sys:menu:info")
    @RequiresPermissions ("sys:menu:info")
    public Result<SysMenuPO> getMenuById(@PathVariable ("meunId") long menuId) {
        SysMenuPO sysMenuPO = sysMenuService.getSysMenuById(menuId);
        return new Result<>(sysMenuPO);
    }

    @RequestMapping (value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation (value = "修改菜单",
            notes = "修改菜单\n权限：sys:menu:update")
    @RequiresPermissions ("sys:menu:update")
    public R updateMenu(@RequestBody SysMenuPO sysMenuPO) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        if (!loginUser.isAdmin()) {
            return R.error("非管理员用户无权修改菜单");
        }
        //数据校验
        verifyForm(sysMenuPO);
        sysMenuService.updateMenu(sysMenuPO);
        return R.ok();
    }

    @RequestMapping (value = "/{menuId}", method = RequestMethod.DELETE)
    @ApiOperation (value = "删除菜单", notes = "删除菜单\n权限：sys:menu:delete")
    @RequiresPermissions ("sys:menu:delete")
    public R deleteMenu(@PathVariable ("menuId") long menuId) {
        sysMenuService.deleteMenu(menuId);
        return R.ok();
    }

    /**
     * 菜单参数校验
     * @param menu
     */
    private void verifyForm(SysMenuPO menu) {
        if (StringUtils.isBlank(menu.getName())) {
            throw new RRException("菜单名称不能为空");
        }

        if (menu.getParentId() == null) {
            throw new RRException("上级菜单不能为空");
        }

        //菜单
        if (menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (StringUtils.isBlank(menu.getUrl())) {
                throw new RRException("菜单URL不能为空");
            }
        }

        //上级菜单类型
        int parentType = Constant.MenuType.CATALOG.getValue();
        if (menu.getParentId() != 0) {
            SysMenuPO parentMenu = sysMenuService.getSysMenuById(menu.getParentId());
            parentType = parentMenu.getType();
        }

        //目录、菜单
        if (menu.getType() == Constant.MenuType.CATALOG.getValue() ||
                menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (parentType != Constant.MenuType.CATALOG.getValue()) {
                throw new RRException("上级菜单只能为目录类型");
            }
            return;
        }

        //按钮
        if (menu.getType() == Constant.MenuType.BUTTON.getValue()) {
            if (parentType != Constant.MenuType.MENU.getValue()) {
                throw new RRException("上级菜单只能为菜单类型");
            }
        }
    }
}
