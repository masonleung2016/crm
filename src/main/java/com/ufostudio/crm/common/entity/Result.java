package com.ufostudio.crm.common.entity;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * 返回数据封装类
 *
 * @Author: LCF
 * @Date: 2020/7/5 17:43
 * @Package: com.ufostudio.crm.common.entity
 */

@ApiModel (value = "接口返回对象", description = "")
public class Result<T> implements java.io.Serializable {

    /**
     * 是否成功标识
     */
    @ApiModelProperty (value = "是否成功标识，0为成功", required = true)
    private int status = 0;

    // 消息
    @ApiModelProperty (value = "消息", required = true)
    private String msg = "";

    // 返回的数据
    @ApiModelProperty (value = "返回的数据", required = true)
    private T res;

    private Map<String, Object> extMap;

    public Result() {
    }

    /**
     * 成功直接返回数据
     */
    public Result(T res) {
        this.res = res;
    }

    /**
     * 成功直接返回数据 带拓展字段
     */
    public Result(T res, Map<String, Object> extMap) {
        this.res = res;
        this.extMap = extMap;
    }

    public Result(Map<String, Object> extMap) {
        this.extMap = extMap;
    }

    /**
     * 错误代码（有额外信息）
     *
     * @param errorCodeEnum
     * @param extendMsg
     */
    public Result(ErrorCodeEnum errorCodeEnum, String extendMsg) {
        this.status = errorCodeEnum.getStatus();
        String wellNumberSign = "#";
        this.msg = errorCodeEnum.getMsg() + wellNumberSign + extendMsg;
    }

    /**
     * 错误
     *
     * @param errorCodeEnum
     */
    public Result(ErrorCodeEnum errorCodeEnum) {
        this.status = errorCodeEnum.getStatus();
        this.msg = errorCodeEnum.getMsg();
    }

    public Result(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Result(ErrorCodeEnum errorCodeEnum, T res) {
        this.status = errorCodeEnum.getStatus();
        this.msg = errorCodeEnum.getMsg();
        this.res = res;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }

    public Map<String, Object> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, Object> extMap) {
        this.extMap = extMap;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
