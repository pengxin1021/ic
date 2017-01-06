package com.ic.base.exception;

import com.ic.base.constants.CommonConstants;

/**
 * Created by perxin on 2017/1/6.
 */
public class BusinessException extends RuntimeException {

    static final long serialVersionUID = -7036897290745746979L;

    private CommonConstants.ErrorCode errorCode;

    private String detailMsg;

    public BusinessException(){};

    public BusinessException(CommonConstants.ErrorCode errorCode) {

    }
}
