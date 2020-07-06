package com.ufostudio.crm.modules.sys.service.impl;

import com.ufostudio.crm.modules.sys.dao.SysUserRolePOMapper;
import com.ufostudio.crm.modules.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:32
 * @Package: com.ufostudio.crm.modules.sys.service.impl
 */

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRolePOMapper sysUserRolePOMapper;

    @Override
    public int insertOrUpdate(long userId, List<Long> roleIdList) {
        if (roleIdList == null || roleIdList.size() == 0) {
            return 0;
        }
        //先删除用户与角色关系
        sysUserRolePOMapper.deleteByUserId(userId);
        //保存用户与角色关系
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("roleIdList", roleIdList);
        return sysUserRolePOMapper.insertBatch(map);
    }

}
