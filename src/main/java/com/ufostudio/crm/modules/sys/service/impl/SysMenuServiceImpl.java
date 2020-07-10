package com.ufostudio.crm.modules.sys.service.impl;

import com.ufostudio.crm.common.utils.ShiroUtils;
import com.ufostudio.crm.modules.sys.dao.SysMenuPOMapper;
import com.ufostudio.crm.modules.sys.dao.SysUserRolePOMapper;
import com.ufostudio.crm.modules.sys.entity.po.SysMenuPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.service.SysMenuService;
import com.ufostudio.crm.common.enums.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:28
 * @Package: com.ufostudio.crm.modules.sys.service.impl
 */

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuPOMapper sysMenuPOMapper;
    
    @Autowired
    private SysUserRolePOMapper sysUserRolePOMapper;

    @Override
    public List<SysMenuPO> getUserMenuList(Long userId) {
        return sysMenuPOMapper.listUserMenu(userId);
    }

    @Override
    public Set<String> getUserPermissions(long userId) {
        Set<String> permsSet = new HashSet<>();
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        List<String> allPerm;
        if (loginUser.isAdmin()) {
            allPerm = sysMenuPOMapper.listAllPermission();
        } else {
            allPerm = sysMenuPOMapper.listUserPermission(userId);
        }
        for (String perms : allPerm) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public List<SysMenuPO> listDeptMenu(long userId) {
        return getUserMenuList(userId);
    }

    @Override
    public List<SysMenuPO> listDeptMenuWithButton(long userId) {
        SysUserPO loginUser = ShiroUtils.getCurrentUser();
        List<SysMenuPO> allUserMenuList;
        if (loginUser.isAdmin()) {
            allUserMenuList = sysMenuPOMapper.listAllMenu();
        } else {
            allUserMenuList = sysMenuPOMapper.listUserMenu(userId);
        }
        List<SysMenuPO> menuList = getSysRootMenuList(allUserMenuList);
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SysMenuPO menu : menuList) {
            menu.setChildMenus(getChildWithButton(menu.getMenuId(), allUserMenuList));
        }
        Collections.sort(menuList);
        return menuList;
    }

    @Override
    @Transactional (rollbackFor = Exception.class)
    public void addMenu(SysMenuPO sysMenuPO) {
        sysMenuPOMapper.insertSelective(sysMenuPO);
    }

    @Override
    public SysMenuPO getSysMenuById(Long parentId) {
        return sysMenuPOMapper.selectByPrimaryKey(parentId);
    }

    @Override
    @Transactional (rollbackFor = Exception.class)
    public void updateMenu(SysMenuPO sysMenuPO) {
        sysMenuPOMapper.updateByPrimaryKeySelective(sysMenuPO);
    }

    @Override
    @Transactional (rollbackFor = Exception.class)
    public void deleteMenu(long menuId) {
        sysMenuPOMapper.deleteByPrimaryKey(menuId);
    }

    private List<SysMenuPO> getSysRootMenuList(List<SysMenuPO> allUserMenuList) {
        // 最后的结果
        List<SysMenuPO> menuList = new ArrayList<>();
        // 先找到所有的一级菜单
        for (SysMenuPO anAllUserMenuList : allUserMenuList) {
            // 一级菜单parentId为0
            if (anAllUserMenuList.getParentId() == 0) {
                menuList.add(anAllUserMenuList);
            }
        }
        Collections.sort(menuList);
        return menuList;
    }

    private List<SysMenuPO> getChildWithButton(Long menuId, List<SysMenuPO> allUserMenuList) {
        // 子菜单
        List<SysMenuPO> childList = new ArrayList<>();
        for (SysMenuPO menu : allUserMenuList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menu.getParentId() != null && menu.getParentId().equals(menuId)) {
                childList.add(menu);
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (SysMenuPO menu : childList) {
            // 还有子菜单
            // 递归
            menu.setChildMenus(getChildWithButton(menu.getMenuId(), allUserMenuList));
        }
        if (childList.size() == 0) {
            return null;
        }
        Collections.sort(childList);
        return childList;
    }

    private List<SysMenuPO> getChildNoButton(Long menuId, List<SysMenuPO> allUserMenuList) {
        // 子菜单
        List<SysMenuPO> childList = new ArrayList<>();
        for (SysMenuPO menu : allUserMenuList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menu.getParentId() != null) {
                if (menu.getParentId().equals(menuId) && menu.getType() != Constant.MenuType.BUTTON.getValue()) {
                    childList.add(menu);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (SysMenuPO menu : childList) {
            // 还有子菜单
            if (menu.getType() == Constant.MenuType.CATALOG.getValue()) {
                // 递归
                menu.setChildMenus(getChildNoButton(menu.getMenuId(), allUserMenuList));
            }
        }
        if (childList.size() == 0) {
            return null;
        }
        Collections.sort(childList);
        return childList;
    }

}
