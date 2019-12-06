package com.exception.globalexception.conf;

import com.exception.globalexception.common.BusinessException;
import com.exception.globalexception.model.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p><b>@name:</b> GlobalException.java</p>
 * <p><b>@title:</b> 全局异常处理类</p>
 * <p>@description: </p>
 * <p>@author: <font color='blue'>Edison</font></p>
 * <p>@time: 2019年12月05日 21点11分</p>
 * <p>
 * 桃之夭夭,灼灼其华
 */
@ControllerAdvice
public class GlobalException {
    
    private final static Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ReturnResult handleBusinessException(BusinessException e) {
        logger.error("========== SyncPrescriptionController sync BusinessException error={} ==========", e.getMessage());
        return ReturnResult.instance(false, null, e.getMessage());
    }
}
