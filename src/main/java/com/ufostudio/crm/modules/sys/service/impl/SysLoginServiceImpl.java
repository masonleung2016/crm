package com.ufostudio.crm.modules.sys.service.impl;

import com.ufostudio.crm.common.entity.Result;
import com.ufostudio.crm.modules.sys.dao.SysUserPOMapper;
import com.ufostudio.crm.modules.sys.entity.po.SysUserPO;
import com.ufostudio.crm.modules.sys.entity.po.SysUserTokenPO;
import com.ufostudio.crm.modules.sys.service.SysLoginService;
import com.ufostudio.crm.modules.sys.service.SysUserService;
import com.ufostudio.crm.modules.sys.service.SysUserTokenService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:28
 * @Package: com.ufostudio.crm.modules.sys.service.impl
 */

@Service
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    private SysUserPOMapper sysUserPOMapper;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public Result<SysUserTokenPO> login(SysUserPO sysUserPO) {
        //根据手机号码登录
        SysUserPO localUser = sysUserPOMapper.queryByMobile(sysUserPO.getUsername());
        //账号不存在
        if (localUser == null) {
            return new Result<>(-1, "账号不存在");
        }
        //密码错误
        if (!localUser.getPassword().equals(new Sha256Hash(sysUserPO.getPassword(), localUser.getSalt()).toHex())) {
            return new Result<>(-1, "密码错误");
        }
        //账号被锁定
        if (localUser.getIsUsed() == 0) {
            return new Result<>(-1, "账号已被锁定,请联系管理员");
        }
        SysUserTokenPO sysUserTokenPO = sysUserTokenService.createToken(localUser.getUserId());
        localUser.setLoginDate(new Date());
        localUser.setLoginIp(sysUserPO.getLoginIp());
        sysUserService.updateLoginIPAndTime(localUser);
        return new Result<>(sysUserTokenPO);
    }
}
