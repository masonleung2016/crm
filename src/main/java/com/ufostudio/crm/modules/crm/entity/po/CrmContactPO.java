package com.ufostudio.crm.modules.crm.entity.po;

import com.ufostudio.crm.common.entity.BaseEntity;
import com.ufostudio.crm.modules.sys.entity.po.SysDeptPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: LCF
 * @Date: 2020/7/5 18:41
 * @Package: com.ufostudio.crm.modules.crm.entity.po
 */

public class CrmContactPO extends BaseEntity<CrmContactPO> implements Serializable {

    private static final long serialVersionUID = -7412049457715034610L;

    private Long contactId;

    private Long customerId;

    /**
     * 这个联系人的负责人（默认为创建人）
     */
    private Long chargeId;

    private String name;

    /**
     * 公司ID
     */
    private Long companyId;

    /**
     * 所属部门
     */
    private Long deptId;

    /**
     * 职位
     */
    private String position;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 手机号码
     */
    private String cellPhoneNumber;

    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 该联系人在公司的哪个部门
     */
    private String department;

    private String weibo;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 是否删除  1：已删除  0：正常
     */
    private Integer isDeleted;

    /**
     * 客户
     */
    private CrmCustomer customer;
    /**
     * 创建者Id
     */
    private Long createBy;

    /**
     * 更新者Id
     */
    private Long updateBy;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最后更新时间
     */
    private Date gmtUpdate;

    @ApiModelProperty (value = "所属公司")
    private SysDeptPO company;

    @ApiModelProperty (value = "所属部门")
    private SysDeptPO dept;

    @ApiModelProperty (value = "负责人")
    private SysUserPO charger;

    @ApiModelProperty (value = "创建人")
    private SysUserPO creater;

    public CrmCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(CrmCustomer customer) {
        this.customer = customer;
    }

    public SysDeptPO getCompany() {
        return company;
    }

    public void setCompany(SysDeptPO company) {
        this.company = company;
    }

    public SysDeptPO getDept() {
        return dept;
    }

    public void setDept(SysDeptPO dept) {
        this.dept = dept;
    }

    public SysUserPO getCharger() {
        return charger;
    }

    public void setCharger(SysUserPO charger) {
        this.charger = charger;
    }

    public SysUserPO getCreater() {
        return creater;
    }

    public void setCreater(SysUserPO creater) {
        this.creater = creater;
    }

    /**
     * @return contact_id
     */
    public Long getContactId() {
        return contactId;
    }

    /**
     * @param contactId
     */
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    /**
     * @return customer_id
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 这个联系人的负责人（默认为创建人）
     *
     * @return charge_id 这个联系人的负责人（默认为创建人）
     */
    public Long getChargeId() {
        return chargeId;
    }

    /**
     * 这个联系人的负责人（默认为创建人）
     *
     * @param chargeId 这个联系人的负责人（默认为创建人）
     */
    public void setChargeId(Long chargeId) {
        this.chargeId = chargeId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 公司ID
     *
     * @return company_id 公司ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 所属部门
     *
     * @return dept_id 所属部门
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 所属部门
     *
     * @param deptId 所属部门
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 职位
     *
     * @return position 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 职位
     *
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 电话号码
     *
     * @return phone_number 电话号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 电话号码
     *
     * @param phoneNumber 电话号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 手机号码
     *
     * @return cell_phone_number 手机号码
     */
    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    /**
     * 手机号码
     *
     * @param cellPhoneNumber 手机号码
     */
    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber == null ? null : cellPhoneNumber.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 地址
     *
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
     * 该联系人在公司的哪个部门
     *
     * @return department 该联系人在公司的哪个部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 该联系人在公司的哪个部门
     *
     * @param department 该联系人在公司的哪个部门
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * @return weibo
     */
    public String getWeibo() {
        return weibo;
    }

    /**
     * @param weibo
     */
    public void setWeibo(String weibo) {
        this.weibo = weibo == null ? null : weibo.trim();
    }

    /**
     * 性别
     *
     * @return gender 性别
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别
     *
     * @param gender 性别
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 出生日期
     *
     * @return birthday 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 邮政编码
     *
     * @return postal_code 邮政编码
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 邮政编码
     *
     * @param postalCode 邮政编码
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
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
     * 创建时间
     *
     * @return gmt_create 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 最后更新时间
     *
     * @return gmt_update 最后更新时间
     */
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    /**
     * 最后更新时间
     *
     * @param gmtUpdate 最后更新时间
     */
    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}
