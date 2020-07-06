package com.ufostudio.crm.common.client.impl;

import com.ufostudio.crm.common.client.ThirdClient;
import com.ufostudio.crm.common.client.qiniu.QiniuClient;
import com.ufostudio.crm.common.client.qiniu.QiniuClientFatory;
import com.ufostudio.crm.common.client.sms.SMSClient;
import com.ufostudio.crm.common.client.sms.SMSClientFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:10
 * @Package: com.ufostudio.crm.common.client.impl
 */
@Component ("thirdClient")
public class DefaultThirdClient implements ThirdClient {

    private static final SMSClient SMS_CLIENT = SMSClientFactory.getSMSClient();
    private static final QiniuClient QINIU_CLIENT = QiniuClientFatory.getQiniuClient();


    @Override
    public boolean sendVerifyCode(String mobile, String verifyCode) {
        String paramStr = "{\"code\":\"" + verifyCode + "\"}";
        return SMS_CLIENT.sendSMSToUser(mobile, "SMS_13776105", paramStr);
    }

    @Override
    public String getUpToken() {
        return QINIU_CLIENT.getUpToken();
    }

    @Override
    public String getImgUrl(String imgName) {
        return QINIU_CLIENT.getImgUrl(imgName);
    }
}
