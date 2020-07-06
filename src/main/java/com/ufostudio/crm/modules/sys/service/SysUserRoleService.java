package com.ufostudio.crm.modules.sys.service;

import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/6 0:34
 * @Package: com.ufostudio.crm.modules.sys.service
 */

public interface SysUserRoleService {
    /**
     * 新增或者更新用户角色关系
     *
     * @param userId
     * @param roleIdList
     * @return
     */
    int insertOrUpdate(long userId, List<Long> roleIdList);


}
