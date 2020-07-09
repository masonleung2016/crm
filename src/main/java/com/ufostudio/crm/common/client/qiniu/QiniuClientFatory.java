package com.ufostudio.crm.common.client.qiniu;

import com.ufostudio.crm.common.client.qiniu.impl.DefaultQiniuClient;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:15
 * @Package: com.ufostudio.crm.common.client.qiniu
 */

public class QiniuClientFatory {
    public static QiniuClient qiniuClient;

    static {
        qiniuClient = new DefaultQiniuClient();
    }

    public static QiniuClient getQiniuClient() {
        return qiniuClient;
        
    }

}
