package com.ufostudio.crm.common.exception;

import com.ufostudio.crm.common.entity.R;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller错误统一处理
 *
 * @Author: LCF
 * @Date: 2020/7/5 17:48
 * @Package: com.ufostudio.crm.common.exception
 */

@ControllerAdvice
public class RRExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 自定义异常
     */
    @ExceptionHandler (RRException.class)
    @ResponseBody
    public R handleRRException(RRException e) {
        logger.error(e.getMessage(), e);
        return R.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler (DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        return R.error("数据库中已存在该记录");
    }

    @ExceptionHandler (AuthorizationException.class)
    @ResponseBody
    public R handleAuthorizationException(AuthorizationException e) {
        return R.error("没有权限，请联系管理员授权");
    }

    @ExceptionHandler (Exception.class)
    @ResponseBody
    public R handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return R.error();
    }
}
