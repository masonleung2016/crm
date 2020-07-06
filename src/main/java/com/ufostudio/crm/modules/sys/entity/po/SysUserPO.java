package com.ufostudio.crm.modules.sys.entity.po;

import com.ufostudio.crm.common.entity.BaseEntity;
import com.ufostudio.crm.common.validator.group.AddGroup;
import com.ufostudio.crm.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:19
 * @Package: com.ufostudio.crm.modules.sys.entity.po
 */
public class SysUserPO extends BaseEntity<SysUserPO> {
    /**
     *
     */
    private Long userId;

    /**
     * 部门ID
     */
    @NotNull (message = "部门不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long deptId;
    /**
     * 部门
     */
    private SysDeptPO dept;

    /**
     * 公司ID
     */
    @NotNull (message = "公司不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long companyId;
    /**
     * 公司
     */
    private SysDeptPO company;
    /**
     * 用户名
     */
    @NotBlank (message = "用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String username;

    /**
     * 密码
     */
    @NotBlank (message = "密码不能为空", groups = AddGroup.class)
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    @NotBlank (message = "邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Email (message = "邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    private String email;

    /**
     * 手机号
     */
    @NotBlank (message = "手机号不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String mobile;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 最后登陆IP
     */
    private String loginIp;

    /**
     * 最后登陆时间
     */
    private Date loginDate;

    /**
     * 是否删除  1：已删除  0：正常
     */
    private Integer isDeleted;

    /**
     * 是否可用  0：不可用  1：可用
     */
    @ApiModelProperty (value = "状态  0：禁用   1：正常")
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
     * 角色列表
     */

    private List<SysRolePO> roleList;
    private List<Long> roleIdList;

    public List<SysRolePO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRolePO> roleList) {
        this.roleList = roleList;
    }

    public SysDeptPO getDept() {
        return dept;
    }

    public void setDept(SysDeptPO dept) {
        this.dept = dept;
    }

    public SysDeptPO getCompany() {
        return company;
    }

    public void setCompany(SysDeptPO company) {
        this.company = company;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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
     * 用户名
     *
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     *
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 盐
     *
     * @return salt 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐
     *
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 邮箱
     *
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 手机号
     *
     * @return mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 头像
     *
     * @return avatar 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 最后登陆IP
     *
     * @return login_ip 最后登陆IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 最后登陆IP
     *
     * @param loginIp 最后登陆IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 最后登陆时间
     *
     * @return login_date 最后登陆时间
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * 最后登陆时间
     *
     * @param loginDate 最后登陆时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
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

    public boolean isAdmin() {
        return "1".equals(this.userId.toString());
    }

}
