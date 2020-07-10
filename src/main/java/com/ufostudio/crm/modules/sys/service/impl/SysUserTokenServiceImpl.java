package com.ufostudio.crm.modules.sys.service.impl;

import com.ufostudio.crm.modules.sys.dao.SysUserTokenPOMapper;
import com.ufostudio.crm.modules.sys.entity.po.SysUserTokenPO;
import com.ufostudio.crm.modules.sys.oauth2.TokenGenerator;
import com.ufostudio.crm.modules.sys.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:33
 * @Package: com.ufostudio.crm.modules.sys.service.impl
 */

@Service
public class SysUserTokenServiceImpl implements SysUserTokenService {

    /**
     * 12小时后过期
     */
    private final static int EXPIRE = 3600 * 12;
    
    @Autowired
    private SysUserTokenPOMapper sysUserTokenPOMapper;

    @Override
    public SysUserTokenPO createToken(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        SysUserTokenPO userToken = getTokenByUserId(userId);
        if (userToken == null) {
            //新建token
            userToken = new SysUserTokenPO();
            userToken.setUserId(userId);
            userToken.setExpireTime(expireTime);
            userToken.setToken(token);
            userToken.setGmtUpdate(now);
            sysUserTokenPOMapper.insertSelective(userToken);
        } else {
            //更新token
            userToken.setToken(token);
            userToken.setGmtUpdate(now);
            userToken.setExpireTime(expireTime);
            sysUserTokenPOMapper.updateByPrimaryKeySelective(userToken);
        }
        return userToken;
    }

    @Override
    public SysUserTokenPO getTokenByUserId(long userId) {
        return sysUserTokenPOMapper.selectByPrimaryKey(userId);
    }

    @Override
    public SysUserTokenPO getTokenByToken(String token) {
        return sysUserTokenPOMapper.getTokenByToken(token);
    }
}
