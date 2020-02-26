package com.ppp.demo.exception;

import com.ppp.demo.response.ResponseResult;
import com.ppp.demo.response.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/2/25 13:56
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 缺少参数异常
     * @param e
     * @return
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ResponseResult paramMiss(MissingServletRequestParameterException e){
        log.error("",e);
        return new ResponseResult(ResultEnum.PARAM_ERROR.getCode(),e.getParameterName()+"is required !");
    }

    /**
     * 缺少请求体异常
     * @return
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseResult paramBodyMiss(HttpMessageNotReadableException e){
        log.error("",e);
        return new ResponseResult(ResultEnum.PARAM_ERROR.getCode(),"request body is required !");
    }

    /**
     * 参数校验异常
     * @return
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseResult paramValid(MethodArgumentNotValidException e){
        log.error("",e);
        //获取异常信息
        BindingResult exceptions = e.getBindingResult();
        //判断异常中是否有错误信息，如果存在就使用异常中的消息
        if(exceptions.hasErrors()){
            List<ObjectError> errors = exceptions.getAllErrors();
            if(!errors.isEmpty()){
                //这里列出了全部错误参数，按正常逻辑取第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return new ResponseResult(ResultEnum.PARAM_ERROR.getCode(),fieldError.getDefaultMessage());
            }
        }
        return new ResponseResult(ResultEnum.PARAM_ERROR);
    }

    /**
     * 自定义参数异常
     * @return
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ParamErrorException.class})
    public ResponseResult paramException(ParamErrorException e){
        log.error("",e);
        if(!StringUtils.isEmpty(e.getMessage())){
            return new ResponseResult(ResultEnum.PARAM_ERROR.getCode(),e.getMessage());
        }
        return new ResponseResult(ResultEnum.PARAM_ERROR);
    }

    /**
     * 系统异常处理
     * @param e
     * @return
     */
    @ResponseStatus
    @ExceptionHandler(value = {Exception.class})
    public ResponseResult sysError(Exception e){
        log.error("",e);
        return new ResponseResult(ResultEnum.UNKNOWN_ERROR);
    }
}
