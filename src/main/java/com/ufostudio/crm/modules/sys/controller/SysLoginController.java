package com.ufostudio.crm.modules.sys.controller;

import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.common.utils.IPUtils;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserTokenPO;
import com.ufostudio.crm.modules.sys.service.SysLoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台登录
 *
 * @Author: LCF
 * @Date: 2020/7/5 22:10
 * @Package: com.ufostudio.crm.modules.sys.controller
 */

@Controller
@ResponseBody
@Api (value = "后台登录相关")
public class SysLoginController {
    @Autowired
    private SysLoginService sysLoginService;

    @RequestMapping (value = "/sys/login", method = RequestMethod.POST, produces = "application/json")
    public Result<SysUserTokenPO> login(@RequestBody SysUserPO sysUserPO, HttpServletRequest request) {
        sysUserPO.setLoginIp(IPUtils.getIpAddr(request));
        return sysLoginService.login(sysUserPO);
    }
}
