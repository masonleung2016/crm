package com.ufostudio.crm.common.client.sms;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:25
 * @Package: com.ufostudio.crm.common.client.sms
 */


public interface SMSClient {
    /**
     * 给单个用户发短信
     *
     * @param mobile       手机号码
     * @param templateCode templateCode 例如：SMS_13776105
     * @param paramString  模板变量值
     * @return
     */
    boolean sendSMSToUser(String mobile, String templateCode, String paramString);
}
