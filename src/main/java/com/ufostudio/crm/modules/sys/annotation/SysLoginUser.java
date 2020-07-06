package com.ufostudio.crm.modules.sys.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: LCF
 * @Date: 2020/7/5 22:08
 * @Package: com.ufostudio.crm.modules.sys.annotation
 */

@Target (ElementType.PARAMETER)
@Retention (RetentionPolicy.RUNTIME)
public @interface SysLoginUser {

}
