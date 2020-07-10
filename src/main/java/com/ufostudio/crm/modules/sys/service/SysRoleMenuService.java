package com.ufostudio.crm.modules.sys.service;

import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/6 0:33
 * @Package: com.ufostudio.crm.modules.sys.service
 */

public interface SysRoleMenuService {
    /**
     * 新增或修改角色和菜单关系
     * @param roleId
     * @param menuIdList
     */
    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    /**
     * 根据角色id查询菜单id列表
     * @param roleId
     * @return
     */
    List<Long> queryMenuIdList(long roleId);
}
