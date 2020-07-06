package com.ufostudio.crm.common.client.qiniu;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:11
 * @Package: com.ufostudio.crm.common.client.qiniu.impl
 */

public interface QiniuClient {

    String getUpToken();

    String getImgUrl(String imgName);
}
