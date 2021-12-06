package com.mohan.handler;

import com.mohan.exception.BaseException;
import com.mohan.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 处理所有业务异常
     * @param e 异常
     * @return 返回信息
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public Result handleBusinessException(BaseException e){
        LOGGER.error(e.getMessage(), e);

        return Result.failure("400", e.getMessage(), null);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNoFoundException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return Result.failure("404", "路径不存在，请检查路径是否正确",null);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        LOGGER.error(e.getMessage(), e);
        return Result.failure("数据库中已存在该记录");
    }

    /**
     * 处理所有不可知的异常
     * @param e 异常
     * @return 返回信息
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e){
        LOGGER.error(e.getMessage(), e);

        return Result.failure("400", e.getMessage(), null);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        LOGGER.error(e.getMessage(), e);
        return Result.failure(e.getMessage());
    }




}