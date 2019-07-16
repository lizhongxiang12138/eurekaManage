package com.lzx.demo.exception;

/**
 * 业务异常定义
 * @author lzx
 */
public class SystemRunServiceException extends RuntimeException {


    public SystemRunServiceException(String message) {
        super(message);
    }
}
