package com.lzx.demo.config;

import com.lzx.demo.dto.ReturnData;
import com.lzx.demo.exception.SystemRunServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 全局的异常处理
 * @author lzx
 *
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 参数校验错误的异常处理
     * @param e 参数校验错误异常
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ReturnData handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error(e.getMessage(),e);
        BindingResult bindingResult = e.getBindingResult();
        StringBuffer errorMsg = new StringBuffer();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        allErrors.forEach(objectError -> {
            errorMsg.append(objectError.getDefaultMessage()).append(";");
        });
        return new ReturnData(HttpStatus.INTERNAL_SERVER_ERROR.value(),errorMsg.toString(),null);
    }

    /**
     * 查询不到资源
     * @param e 参数校验错误异常
     * @return
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity handlerResourceNotFoundException(ResourceNotFoundException e){
        log.error(e.getMessage(),e);
        StringBuffer errorMsg = new StringBuffer();
        errorMsg.append(e.getMessage());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> returnDataResponseEntity = new ResponseEntity<String>(null, httpHeaders, HttpStatus.NOT_FOUND);
        return returnDataResponseEntity;
    }

    /**
     * 系统运行时的业务异常
     * 不返回错误码（响应的状态码）
     *
     * @param e 系统运行时的业务异常
     * @return
     */
    @ExceptionHandler(SystemRunServiceException.class)
    @ResponseBody
    public ResponseEntity handlerOpenRequestException(SystemRunServiceException e){
        log.error(e.getMessage(),e);
        StringBuffer errorMsg = new StringBuffer();
        errorMsg.append(e.getMessage());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<ReturnData> returnDataResponseEntity = new ResponseEntity<>(new ReturnData(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMsg.toString(), null), httpHeaders, HttpStatus.OK);
        return returnDataResponseEntity;
    }


    /**
     * 未知遗产处理
     * @param e 未知异常处理
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handlerException(Exception e){
        log.error(e.getMessage(),e);
        StringBuffer errorMsg = new StringBuffer();
        errorMsg.append(e.getMessage());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<ReturnData> returnDataResponseEntity = new ResponseEntity<>(new ReturnData(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMsg.toString(), null), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        return returnDataResponseEntity;
    }

}
