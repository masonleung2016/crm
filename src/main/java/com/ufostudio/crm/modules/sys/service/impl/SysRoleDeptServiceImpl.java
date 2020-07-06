package com.ufostudio.crm.modules.sys.service.impl;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.modules.sys.dao.SysRoleDeptPOMapper;
import com.ufostudio.crm.modules.sys.dao.SysRolePOMapper;
import com.ufostudio.crm.modules.sys.entity.po.SysRolePO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.service.SysRoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:29
 * @Package: com.ufostudio.crm.modules.sys.service.impl
 */

@Service
public class SysRoleDeptServiceImpl implements SysRoleDeptService {
    @Autowired
    private SysRoleDeptPOMapper sysRoleDeptPOMapper;
    @Autowired
    private SysRolePOMapper sysRolePOMapper;

    @Override
    public void saveOrUpdate(Long roleId, List<Long> deptIdList) {
        if (deptIdList.size() == 0) {
            return;
        }
        sysRoleDeptPOMapper.deleteByRoleId(roleId);
        //保存角色与菜单关系
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("deptIdList", deptIdList);
        sysRoleDeptPOMapper.saveBatch(map);
    }

    @Override
    public R listSysRoleByUserDept(SysUserPO loginUser, SysUserPO sysUserPO) {
        List<SysRolePO> rolePOList = sysRolePOMapper.listSysRoleByUserDept(sysUserPO);
        return R.ok().put("roleList", rolePOList);
    }

}
