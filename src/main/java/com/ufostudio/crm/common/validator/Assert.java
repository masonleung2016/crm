package com.ufostudio.crm.common.validator;

import com.ufostudio.crm.common.exception.RRException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 *
 * @Author: LCF
 * @Date: 2020/7/5 18:24
 * @Package: com.ufostudio.crm.common.validator.group
 */

public abstract class Assert {
    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }
}
