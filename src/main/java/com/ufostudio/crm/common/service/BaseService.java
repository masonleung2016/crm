package com.ufostudio.crm.common.service;

import com.ufostudio.crm.common.utils.SpringContextUtils;
import com.ufostudio.crm.modules.sys.dao.SysDeptPOMapper;
import com.ufostudio.crm.modules.sys.dao.SysRolePOMapper;
import com.ufostudio.crm.modules.sys.entity.po.SysDeptPO;
import com.ufostudio.crm.modules.sys.entity.po.SysRolePO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:55
 * @Package: com.ufostudio.crm.common.service
 */

@Component
public abstract class BaseService {
    private static SysRolePOMapper sysRolePOMapper = SpringContextUtils.getBean(SysRolePOMapper.class);
    
    private static SysDeptPOMapper sysDeptPOMapper = SpringContextUtils.getBean(SysDeptPOMapper.class);
    
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @param user        当前用户对象
     * @param officeAlias 机构表别名，多个用“,”逗号隔开。
     * @param userAlias   用户表别名，多个用“,”逗号隔开，传递空，忽略此参数
     * @return
     */
    public static String dataScopeFilter(SysUserPO user, String officeAlias, String userAlias) {

        StringBuilder sqlString = new StringBuilder();

        // 进行权限过滤，多个角色权限范围之间为或者关系。
        List<String> dataScope = Lists.newArrayList();
//        SysDeptPO company = sysDeptPOMapper.selectByPrimaryKey(user.getCompanyId());
//        SysDeptPO dept = sysDeptPOMapper.selectByPrimaryKey(user.getDeptId());
        SysDeptPO company = user.getCompany();
        SysDeptPO dept = user.getDept();
        // 超级管理员，跳过权限过滤
        if (!user.isAdmin()) {
            boolean isDataScopeAll = false;
            for (SysRolePO r : user.getRoleList()) {
                for (String oa : StringUtils.split(officeAlias, ",")) {
                    if (!dataScope.contains(r.getDataScope()) && StringUtils.isNotBlank(oa)) {
                        if (SysRolePO.DATA_SCOPE_ALL.equals(r.getDataScope())) {
                            isDataScopeAll = true;
                            //1、所在公司及以下数据
                        } else if (SysRolePO.DATA_SCOPE_COMPANY_AND_CHILD.equals(r.getDataScope())) {
                            //2：所在公司及以下数据；
                            sqlString.append(" OR ").append(oa).append(".dept_id = '").append(user.getCompanyId()).append("'");
                            sqlString.append(" OR ").append(oa).append(".parent_ids LIKE '").append(company.getParentIds()).append(user.getCompanyId()).append("_%'");
                        } else if (SysRolePO.DATA_SCOPE_COMPANY.equals(r.getDataScope())) {
                            //3、包括本公司下的部门 （type=1:公司；type=2：部门）
                            sqlString.append(" OR ").append(oa).append(".dept_id = '").append(user.getCompanyId()).append("'");
                            sqlString.append(" OR (").append(oa).append(".parent_id = '").append(user.getCompanyId()).append("' AND ").append(oa).append(".type = '2')");
                        } else if (SysRolePO.DATA_SCOPE_OFFICE_AND_CHILD.equals(r.getDataScope())) {
                            //4、：所在部门及以下数据；
                            sqlString.append(" OR ").append(oa).append(".dept_id = '").append(user.getDeptId()).append("'");
                            sqlString.append(" OR ").append(oa).append(".parent_ids LIKE '").append(dept.getParentIds()).append(user.getDeptId()).append("_%'");
                        } else if (SysRolePO.DATA_SCOPE_OFFICE.equals(r.getDataScope())) {
                            //5、所在部门数据；
                            sqlString.append(" OR ").append(oa).append(".dept_id = '").append(user.getDeptId()).append("'");
                        } else if (SysRolePO.DATA_SCOPE_CUSTOM.equals(r.getDataScope())) {
                            sqlString.append(" OR EXISTS (SELECT 1 FROM sys_role_dept WHERE role_id = '").append(r.getRoleId()).append("'");
                            sqlString.append(" AND dept_id = ").append(oa).append(".dept_id)");
                        }
                        dataScope.add(r.getDataScope());
                    }
                }
            }
            // 如果没有全部数据权限，并设置了用户别名，则当前权限为本人；如果未设置别名，当前无权限为已植入权限
            if (!isDataScopeAll) {
                if (StringUtils.isNotBlank(userAlias)) {
                    for (String ua : StringUtils.split(userAlias, ",")) {
                        sqlString.append(" OR ").append(ua).append(".user_id = '").append(user.getUserId()).append("'");
                    }
                } else {
                    for (String oa : StringUtils.split(officeAlias, ",")) {
                        sqlString.append(" OR ").append(oa).append(".dept_id IS NULL");
                    }
                }
            } else {
                // 如果包含全部权限，则去掉之前添加的所有条件，并跳出循环。
                sqlString = new StringBuilder();
            }
        }
        if (StringUtils.isNotBlank(sqlString.toString())) {
            return " AND (" + sqlString.substring(4) + ")";
        }
        return "";
    }
}
