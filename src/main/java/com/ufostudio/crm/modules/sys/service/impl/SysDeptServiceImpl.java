package com.ufostudio.crm.modules.sys.service.impl;

import com.ufostudio.crm.common.entity.R;
import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.common.enums.Constant;
import com.ufostudio.crm.common.service.BaseService;
import com.ufostudio.crm.common.utils.CollectionsUtils;
import com.ufostudio.crm.modules.sys.dao.SysDeptPOMapper;
import com.ufostudio.crm.modules.sys.entity.po.SysDeptPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:22
 * @Package: com.ufostudio.crm.modules.sys.service.impl
 */

@Service
public class SysDeptServiceImpl extends BaseService implements SysDeptService {
    
    @Autowired
    private SysDeptPOMapper sysDeptPOMapper;

    @Override
    public List<SysDeptPO> listSysDept(SysUserPO loginUser) {
        SysDeptPO sysDeptPO = loginUser.getCompany();
        String sql = BaseService.dataScopeFilter(loginUser, "a", "");
        sysDeptPO.getSqlMap().put("dsf", sql);
        List<SysDeptPO> allDeptPOList = sysDeptPOMapper.listSysDept(sysDeptPO);
        if (!CollectionsUtils.isEmpty(allDeptPOList)) {
            List<Long> parentList = CollectionsUtils.extractToList(allDeptPOList, "parentId");
            long rootId = Collections.min(parentList);
            List<SysDeptPO> deptList = getSysRootDeptList(rootId, allDeptPOList);
            if (deptList.size() == 0) {
                return allDeptPOList;
            }
            // 为一级菜单设置子菜单，getChild是递归调用的
            for (SysDeptPO dept : deptList) {
                dept.setChildDept(getChild(dept.getDeptId(), allDeptPOList));
            }
            return deptList;
        }
        return new ArrayList<>();
    }

    @Override
    public List<SysDeptPO> listSysCompany(SysUserPO loginUser) {
        SysDeptPO sysDeptPO = loginUser.getCompany();
        String sql = BaseService.dataScopeFilter(loginUser, "a", "");
        sysDeptPO.getSqlMap().put("dsf", sql);
        List<SysDeptPO> allDeptPOList = sysDeptPOMapper.listSysCompany(sysDeptPO);
        List<Long> parentList = CollectionsUtils.extractToList(allDeptPOList, "parentId");
        long rootId = Collections.min(parentList);
        List<SysDeptPO> deptList = getSysRootCompanyList(rootId, allDeptPOList);
        if (deptList.size() == 0) {
            return allDeptPOList;
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SysDeptPO dept : deptList) {
            dept.setChildDept(getChildCompany(dept.getDeptId(), allDeptPOList));
        }
        return deptList;
    }

    @Override
    @Transactional (rollbackFor = Exception.class)
    public R addDept(SysUserPO loginUser, SysDeptPO sysDeptPO) {
        SysDeptPO parentDept = sysDeptPOMapper.selectByPrimaryKey(sysDeptPO.getParentId());
        sysDeptPO.setParentIds(parentDept.getParentIds() + parentDept.getDeptId() + ",");
        sysDeptPOMapper.insertSelective(sysDeptPO);
        return R.ok();
    }

    @Override
    @Transactional (rollbackFor = Exception.class)
    public R deleteDept(SysUserPO loginUser, long deptId) {
        SysDeptPO sysDeptPO = new SysDeptPO();
        sysDeptPO.setDeptId(deptId);
        List<SysDeptPO> allDeptPOList = sysDeptPOMapper.listChildDept(sysDeptPO);
        if (allDeptPOList.size() > 1) {
            return R.error("该部门含有子部门，无法删除");
        }
        sysDeptPOMapper.deleteByPrimaryKey(deptId);
        return R.ok();
    }

    @Override
    public Result<SysDeptPO> getDeptByDeptId(SysUserPO loginUser, long deptId) {
        return new Result<>(sysDeptPOMapper.selectByPrimaryKey(deptId));
    }

    @Override
    public R updateDept(SysUserPO loginUser, SysDeptPO sysDeptPO) {
        SysDeptPO parentDept = sysDeptPOMapper.selectByPrimaryKey(sysDeptPO.getParentId());
        sysDeptPO.setParentIds(parentDept.getParentIds() + parentDept.getDeptId() + ",");
        sysDeptPO.setUpdateBy(loginUser.getUserId());
        sysDeptPOMapper.updateByPrimaryKeySelective(sysDeptPO);
        return R.ok();
    }

    private List<SysDeptPO> getChild(Long deptId, List<SysDeptPO> allDeptPOList) {
        // 子菜单
        List<SysDeptPO> childList = new ArrayList<>();
        for (SysDeptPO dept : allDeptPOList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (dept.getParentId() != null) {
                if (dept.getParentId().equals(deptId)) {
                    childList.add(dept);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (SysDeptPO dept : childList) {
            // 还有子菜单
//            if (dept.getType() == Constant.DeptType.COMPANY.getValue()) {
            // 递归
            dept.setChildDept(getChild(dept.getDeptId(), allDeptPOList));
//            }
        }
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

    private List<SysDeptPO> getSysRootDeptList(long rootId, List<SysDeptPO> allDeptPOList) {
        // 最后的结果
        List<SysDeptPO> deptList = new ArrayList<>();
        // 先找到所有的一级菜单
        for (SysDeptPO an : allDeptPOList) {
            // 一级菜单parentId为0
            if (an.getParentId() == rootId) {
                deptList.add(an);
            }
        }
        return deptList;
    }

    private List<SysDeptPO> getChildCompany(Long deptId, List<SysDeptPO> allDeptPOList) {
        // 子菜单
        List<SysDeptPO> childList = new ArrayList<>();
        for (SysDeptPO dept : allDeptPOList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (dept.getParentId() != null && dept.getType().equals(Constant.DeptType.COMPANY.getValue())) {
                if (dept.getParentId().equals(deptId)) {
                    childList.add(dept);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (SysDeptPO dept : childList) {
            // 还有子菜单
            if (dept.getType() == Constant.DeptType.COMPANY.getValue()) {
                // 递归
                dept.setChildDept(getChild(dept.getDeptId(), allDeptPOList));
            }
        }
        if (childList.size() == 0) {
            return null;
        }
        return childList;

    }

    private List<SysDeptPO> getSysRootCompanyList(long rootId, List<SysDeptPO> allDeptPOList) {
        // 最后的结果
        List<SysDeptPO> deptList = new ArrayList<>();
        // 先找到所有的一级菜单
        for (SysDeptPO an : allDeptPOList) {
            // 一级菜单parentId为0
            if (an.getParentId() == rootId && an.getType().equals(Constant.DeptType.COMPANY.getValue())) {
                deptList.add(an);
            }
        }
        return deptList;
    }
}
