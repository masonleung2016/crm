package com.ufostudio.crm.modules.crm.entity.po;

import com.ufostudio.crm.common.entity.BaseEntity;
import com.ufostudio.crm.modules.sys.entity.po.SysDeptPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author: LCF
 * @Date: 2020/7/5 18:42
 * @Package: com.ufostudio.crm.modules.crm.entity.po
 */

public class CrmCustomer extends BaseEntity<CrmCustomer> {
    
    private Long customerId;

    @ApiModelProperty (value = "客户名称")
    private String customerName;

    @ApiModelProperty (value = "所属公司ID")
    private Long companyId;

    @ApiModelProperty (value = "所属公司")
    private SysDeptPO company;

    @ApiModelProperty (value = "所属部门ID")
    private Long deptId;

    @ApiModelProperty (value = "所属部门")
    private SysDeptPO dept;

    @ApiModelProperty (value = "负责人ID")
    private Long chargeId;

    @ApiModelProperty (value = "负责人")
    private SysUserPO charger;

    @ApiModelProperty (value = "创建人")
    private SysUserPO creater;

    @ApiModelProperty (value = "省份")
    private String province;

    @ApiModelProperty (value = "城市")
    private String city;

    @ApiModelProperty (value = "区域")
    private String area;

    @ApiModelProperty (value = "详细地址")
    private String addressDetail;

    @ApiModelProperty (value = "电话号码")
    private String phoneNumber;

    @ApiModelProperty (value = "备注")
    private String remarks;

    @ApiModelProperty (value = "客户级别 分为 A、B、C三个级别")
    private String level;

    @ApiModelProperty (value = "邮政编码")
    private String postalCode;

    @ApiModelProperty (value = "客户所在行业")
    private String industry;

    @ApiModelProperty (value = "官网网址")
    private String website;

    @ApiModelProperty (value = "微博号")
    private String weibo;

    @ApiModelProperty (value = "QQ号")
    private String qq;

    @ApiModelProperty (value = "微信号")
    private String wechat;

    @ApiModelProperty (value = "传真号")
    private String fax;

    @ApiModelProperty (value = "公司人数")
    private Long companyNumber;

    /**
     * 是否删除  1：已删除  0：正常
     */
    @ApiModelProperty (value = "是否删除  1：已删除  0：正常 新增时不传")
    private Integer isDeleted;

    private Long createBy;

    private Long updateBy;

    private Date gmtCreate;

    private Date gmtUpdate;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getChargeId() {
        return chargeId;
    }

    public void setChargeId(Long chargeId) {
        this.chargeId = chargeId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo == null ? null : weibo.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public Long getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(Long companyNumber) {
        this.companyNumber = companyNumber;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}
