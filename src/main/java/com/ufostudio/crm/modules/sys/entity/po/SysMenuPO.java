package com.ufostudio.crm.modules.sys.entity.po;

import java.util.Date;
import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:17
 * @Package: com.ufostudio.crm.modules.sys.entity.po
 */
public class SysMenuPO implements Comparable<SysMenuPO> {
    /**
     *
     */
    private Long menuId;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 删除标记
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

    private List<SysMenuPO> childMenus;

    public List<SysMenuPO> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<SysMenuPO> childMenus) {
        this.childMenus = childMenus;
    }

    /**
     * @return menu_id
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 父菜单ID，一级菜单为0
     *
     * @return parent_id 父菜单ID，一级菜单为0
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父菜单ID，一级菜单为0
     *
     * @param parentId 父菜单ID，一级菜单为0
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 菜单名称
     *
     * @return name 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 菜单URL
     *
     * @return url 菜单URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 菜单URL
     *
     * @param url 菜单URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     *
     * @return perms 授权(多个用逗号分隔，如：user:list,user:create)
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     *
     * @param perms 授权(多个用逗号分隔，如：user:list,user:create)
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * 类型   0：目录   1：菜单   2：按钮
     *
     * @return type 类型   0：目录   1：菜单   2：按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型   0：目录   1：菜单   2：按钮
     *
     * @param type 类型   0：目录   1：菜单   2：按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 菜单图标
     *
     * @return icon 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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
     * 删除标记
     *
     * @return is_deleted 删除标记
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 删除标记
     *
     * @param isDeleted 删除标记
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


    @Override
    public int compareTo(SysMenuPO o) {
        return this.getOrderNum().compareTo(o.getOrderNum());
    }

}
