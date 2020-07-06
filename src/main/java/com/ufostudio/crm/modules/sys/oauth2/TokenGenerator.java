package com.ufostudio.crm.modules.sys.oauth2;

import com.ufostudio.crm.common.exception.RRException;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * token生成
 *
 * @Author: LCF
 * @Date: 2020/7/5 22:22
 * @Package: com.ufostudio.crm.modules.sys.oauth2
 */
public class TokenGenerator {

    private static final char[] HEX_CODE = "0123456789abcdef".toCharArray();

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    public static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(HEX_CODE[(b >> 4) & 0xF]);
            r.append(HEX_CODE[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new RRException("生成Token失败", e);
        }
    }
}
