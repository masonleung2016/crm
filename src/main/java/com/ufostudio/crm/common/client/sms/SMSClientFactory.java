package com.ufostudio.crm.common.client.sms;

import com.ufostudio.crm.common.client.sms.impl.DefaultSMSClient;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:26
 * @Package: com.ufostudio.crm.common.client.sms
 */

public class SMSClientFactory {

    private static SMSClient SMSClient;

    static {
        SMSClient = new DefaultSMSClient();
    }

    public SMSClientFactory() {
    }

    public static SMSClient getSMSClient() {
        return SMSClient;
    }
}
