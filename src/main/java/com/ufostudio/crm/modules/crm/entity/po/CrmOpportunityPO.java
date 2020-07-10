package com.ufostudio.crm.modules.crm.entity.po;

import java.util.Date;

/**
 * @Author: LCF
 * @Date: 2020/7/5 18:43
 * @Package: com.ufostudio.crm.modules.crm.entity.po
 */

public class CrmOpportunityPO {
    /**
     * 销售机会ID
     */
    private Long opportunityId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 公司ID
     */
    private Long companyId;

    /**
     * 所属部门
     */
    private Long deptId;

    /**
     * 这个客户的负责人（默认为创建人）
     */
    private Long chargeId;

    private String remarks;

    /**
     * 机会名称
     */
    private String name;

    /**
     * 销售金额（元）
     */
    private String salesAmount;

    /**
     * 结单日期
     */
    private Date completeDate;

    /**
     * 机会类型：新客户机会、老客户机会
     */
    private String opportunityType;

    /**
     * 机会来源
     */
    private String opportunitySource;

    /**
     * 是否删除  1：已删除  0：正常
     */
    private Integer isDeleted;

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

    /**
     * 销售机会ID
     *
     * @return opportunity_id 销售机会ID
     */
    public Long getOpportunityId() {
        return opportunityId;
    }

    /**
     * 销售机会ID
     *
     * @param opportunityId 销售机会ID
     */
    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    /**
     * 客户名称
     *
     * @return customer_name 客户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 客户名称
     *
     * @param customerName 客户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
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
     * 这个客户的负责人（默认为创建人）
     *
     * @return charge_id 这个客户的负责人（默认为创建人）
     */
    public Long getChargeId() {
        return chargeId;
    }

    /**
     * 这个客户的负责人（默认为创建人）
     *
     * @param chargeId 这个客户的负责人（默认为创建人）
     */
    public void setChargeId(Long chargeId) {
        this.chargeId = chargeId;
    }

    /**
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 机会名称
     *
     * @return name 机会名称
     */
    public String getName() {
        return name;
    }

    /**
     * 机会名称
     *
     * @param name 机会名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 销售金额（元）
     *
     * @return sales_amount 销售金额（元）
     */
    public String getSalesAmount() {
        return salesAmount;
    }

    /**
     * 销售金额（元）
     *
     * @param salesAmount 销售金额（元）
     */
    public void setSalesAmount(String salesAmount) {
        this.salesAmount = salesAmount == null ? null : salesAmount.trim();
    }

    /**
     * 结单日期
     *
     * @return complete_date 结单日期
     */
    public Date getCompleteDate() {
        return completeDate;
    }

    /**
     * 结单日期
     *
     * @param completeDate 结单日期
     */
    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    /**
     * 机会类型：新客户机会、老客户机会
     *
     * @return opportunity_type 机会类型：新客户机会、老客户机会
     */
    public String getOpportunityType() {
        return opportunityType;
    }

    /**
     * 机会类型：新客户机会、老客户机会
     *
     * @param opportunityType 机会类型：新客户机会、老客户机会
     */
    public void setOpportunityType(String opportunityType) {
        this.opportunityType = opportunityType == null ? null : opportunityType.trim();
    }

    /**
     * 机会来源
     *
     * @return opportunity_source 机会来源
     */
    public String getOpportunitySource() {
        return opportunitySource;
    }

    /**
     * 机会来源
     *
     * @param opportunitySource 机会来源
     */
    public void setOpportunitySource(String opportunitySource) {
        this.opportunitySource = opportunitySource == null ? null : opportunitySource.trim();
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
