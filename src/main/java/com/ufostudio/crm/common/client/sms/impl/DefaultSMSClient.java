package com.ufostudio.crm.common.client.sms.impl;

import com.ufostudio.crm.common.client.sms.SMSClient;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendSmsRequest;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:23
 * @Package: com.ufostudio.crm.common.client.sms.impl
 */

public class DefaultSMSClient implements SMSClient {

    private static Logger logger = LoggerFactory.getLogger(DefaultSMSClient.class);

    private static IAcsClient client;

    static {
        logger.info("============sms client 初始化===============");
        Properties prop = new Properties();
        InputStream in = DefaultSMSClient.class.getClassLoader().getResourceAsStream("sdk/sms.properties");
        try {
            prop.load(in);
        } catch (IOException error) {
            logger.info(error.toString());
        }

        String accessKeyId = prop.getProperty("accessKeyId");
        String accessKeySecret = prop.getProperty("accessKeySecret");
        String regionId = prop.getProperty("regionId");

        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        client = new DefaultAcsClient(profile);
    }

    public DefaultSMSClient() {

    }

    @Override
    public boolean sendSMSToUser(String mobile, String templateCode, String paramString) {
        logger.error("发送成功 " + mobile);
        try {
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName("画扇科技");
            request.setTemplateCode(templateCode);
            request.setRecNum(mobile);
            request.setParamString(paramString);
            client.getAcsResponse(request);
        } catch (Exception e) {
            logger.error(e.toString());
            return false;
        }
        return true;
    }
}
