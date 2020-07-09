package com.ufostudio.crm.common.entity;

import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:37
 * @Package: com.ufostudio.crm.common.entity
 */

public abstract class BaseEntity<T> implements Serializable {

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    
    public static final String DEL_FLAG_DELETE = "1";
    
    public static final String DEL_FLAG_AUDIT = "2";
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 当前用户
     */
    protected SysUserPO currentUser;
    
    /**
     * 当前实体分页对象
     */
    protected PageInfoDTO page;
    
    /**
     * 自定义SQL（SQL标识，SQL内容）
     */
    protected Map<String, String> sqlMap;

    public BaseEntity() {

    }

    public SysUserPO getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(SysUserPO currentUser) {
        this.currentUser = currentUser;
    }

    public PageInfoDTO getPage() {
        return page;
    }

    public void setPage(PageInfoDTO page) {
        this.page = page;
    }

    public Map<String, String> getSqlMap() {
        if (sqlMap == null) {
            sqlMap = Maps.newHashMap();
        }
        return sqlMap;
    }

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
