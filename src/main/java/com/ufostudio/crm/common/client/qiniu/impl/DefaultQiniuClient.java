package com.ufostudio.crm.common.client.qiniu.impl;

import com.ufostudio.crm.common.client.qiniu.QiniuClient;
import com.qiniu.util.Auth;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:06
 * @Package: com.ufostudio.crm.common.client.qiniu.impl
 */

public class DefaultQiniuClient implements QiniuClient {

    public static final String QINIU_URL = "";
    
    private static final String ACCESS_KEY = "";
    
    private static final String SECRET_KEY = "";
    
    private static final String BUCKET = "ckkey";

    @Override
    public String getUpToken() {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        return auth.uploadToken(BUCKET);
    }

    @Override
    public String getImgUrl(String imgName) {
        return QINIU_URL + '/' + imgName;
    }
}
