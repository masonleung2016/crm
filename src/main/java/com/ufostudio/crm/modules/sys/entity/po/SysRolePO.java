package com.ufostudio.crm.modules.sys.entity.po;

import com.ufostudio.crm.common.validator.group.AddGroup;
import com.ufostudio.crm.common.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:18
 * @Package: com.ufostudio.crm.modules.sys.entity.po
 */
public class SysRolePO {

    /**
     * 1：所有数据；
     */
    public static final String DATA_SCOPE_ALL = "1";
    /**
     * 2：所在公司及以下数据；
     */
    public static final String DATA_SCOPE_COMPANY_AND_CHILD = "2";
    /**
     * 3：所在公司数据；
     */
    public static final String DATA_SCOPE_COMPANY = "3";
    /**
     * 4：所在部门及以下数据；
     */
    public static final String DATA_SCOPE_OFFICE_AND_CHILD = "4";
    /**
     * 5：所在部门数据；
     */
    public static final String DATA_SCOPE_OFFICE = "5";
    /**
     * 8：仅本人数据；
     */
    public static final String DATA_SCOPE_SELF = "8";
    /**
     * 9：按明细设置;
     */
    public static final String DATA_SCOPE_CUSTOM = "9";
    /**
     *
     */
    private Long roleId;

    /**
     * 角色名称
     */
    @NotBlank (message = "角色名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String roleName;

    /**
     * 英文名称
     */
    private String enname;

    /**
     * 角色类型
     */
    private String roleType;

    /**
     * 数据范围
     */
    private String dataScope;

    /**
     * 是否系统数据 0：非系统数据 1：系统数据
     */
    private String isSys;

    /**
     * 备注
     */
    private String remark;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 是否删除  1：已删除  0：正常
     */
    private Integer isDeleted;

    /**
     * 是否可用  0：不可用  1：可用
     */
    private Integer isUsed;

    /**
     * 创建者Id
     */
    private Long createBy;

    /**
     * 更新者Id
     */
    private Long updateBy;

    /**
     *
     */
    private Date gmtCreate;

    /**
     *
     */
    private Date gmtUpdate;
    /**
     * 角色对应的菜单列表
     */
    private List<Long> menuIdList;
    /**
     * 角色对应的机构列表【数据过滤用到】
     */
    private List<Long> deptIdList;

    public List<Long> getDeptIdList() {
        return deptIdList;
    }

    public void setDeptIdList(List<Long> deptIdList) {
        this.deptIdList = deptIdList;
    }

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 角色名称
     *
     * @return role_name 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 英文名称
     *
     * @return enname 英文名称
     */
    public String getEnname() {
        return enname;
    }

    /**
     * 英文名称
     *
     * @param enname 英文名称
     */
    public void setEnname(String enname) {
        this.enname = enname == null ? null : enname.trim();
    }

    /**
     * 角色类型
     *
     * @return role_type 角色类型
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * 角色类型
     *
     * @param roleType 角色类型
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    /**
     * 数据范围
     *
     * @return data_scope 数据范围
     */
    public String getDataScope() {
        return dataScope;
    }

    /**
     * 数据范围
     *
     * @param dataScope 数据范围
     */
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope == null ? null : dataScope.trim();
    }

    /**
     * 是否系统数据 0：非系统数据 1：系统数据
     *
     * @return is_sys 是否系统数据 0：非系统数据 1：系统数据
     */
    public String getIsSys() {
        return isSys;
    }

    /**
     * 是否系统数据 0：非系统数据 1：系统数据
     *
     * @param isSys 是否系统数据 0：非系统数据 1：系统数据
     */
    public void setIsSys(String isSys) {
        this.isSys = isSys == null ? null : isSys.trim();
    }

    /**
     * 备注
     *
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 部门ID
     *
     * @return dept_id 部门ID
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 部门ID
     *
     * @param deptId 部门ID
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 是否删除  1：已删除  0：正常
     *
     * @return is_deleted 是否删除  1：已删除  0：正常
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除  1：已删除  0：正常
     *
     * @param isDeleted 是否删除  1：已删除  0：正常
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 是否可用  0：不可用  1：可用
     *
     * @return is_used 是否可用  0：不可用  1：可用
     */
    public Integer getIsUsed() {
        return isUsed;
    }

    /**
     * 是否可用  0：不可用  1：可用
     *
     * @param isUsed 是否可用  0：不可用  1：可用
     */
    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    /**
     * 创建者Id
     *
     * @return create_by 创建者Id
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 创建者Id
     *
     * @param createBy 创建者Id
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 更新者Id
     *
     * @return update_by 更新者Id
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新者Id
     *
     * @param updateBy 更新者Id
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * @return gmt_create
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return gmt_update
     */
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    /**
     * @param gmtUpdate
     */
    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

}
