package com.ufostudio.crm.modules.sys.entity.po;

import com.ufostudio.crm.common.entity.BaseEntity;
import com.ufostudio.crm.common.validator.group.AddGroup;
import com.ufostudio.crm.common.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:16
 * @Package: com.ufostudio.crm.modules.sys.entity.po
 */

public class SysDeptPO extends BaseEntity<SysDeptPO> {

    private Long deptId;

    /**
     * 上级部门ID，一级部门为0
     */
    @NotBlank (message = "上级部门ID不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long parentId;

    /**
     * 所有父级编号
     */
    private String parentIds;

    /**
     * 部门名称
     */
    @NotBlank (message = "部门名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;

    /**
     * 部门别名
     */
    private String aliasName;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 机构邮箱
     */
    private String deptEmail;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 机构联系地址
     */
    private String address;

    /**
     * 机构类型
     */
    private Integer type;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 备注
     */
    private String remarks;

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

    private Date gmtCreate;

    private Date gmtUpdate;

    private List<SysDeptPO> childDept;

    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<SysDeptPO> getChildDept() {
        return childDept;
    }

    public void setChildDept(List<SysDeptPO> childDept) {
        this.childDept = childDept;
    }

    /**
     * @return dept_id
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 上级部门ID，一级部门为0
     *
     * @return parent_id 上级部门ID，一级部门为0
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 上级部门ID，一级部门为0
     *
     * @param parentId 上级部门ID，一级部门为0
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 所有父级编号
     *
     * @return parent_ids 所有父级编号
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 所有父级编号
     *
     * @param parentIds 所有父级编号
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * 部门名称
     *
     * @return name 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 部门别名
     *
     * @return alias_name 部门别名
     */
    public String getAliasName() {
        return aliasName;
    }

    /**
     * 部门别名
     *
     * @param aliasName 部门别名
     */
    public void setAliasName(String aliasName) {
        this.aliasName = aliasName == null ? null : aliasName.trim();
    }

    /**
     * 电话号码
     *
     * @return phone 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 传真
     *
     * @return fax 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 传真
     *
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * 机构邮箱
     *
     * @return dept_email 机构邮箱
     */
    public String getDeptEmail() {
        return deptEmail;
    }

    /**
     * 机构邮箱
     *
     * @param deptEmail 机构邮箱
     */
    public void setDeptEmail(String deptEmail) {
        this.deptEmail = deptEmail == null ? null : deptEmail.trim();
    }

    /**
     * 邮政编码
     *
     * @return zip_code 邮政编码
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 邮政编码
     *
     * @param zipCode 邮政编码
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * 机构联系地址
     *
     * @return address 机构联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 机构联系地址
     *
     * @param address 机构联系地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 机构类型
     *
     * @return type 机构类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 机构类型
     *
     * @param type 机构类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 排序
     *
     * @return order_num 排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 排序
     *
     * @param orderNum 排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 备注
     *
     * @return remarks 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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
