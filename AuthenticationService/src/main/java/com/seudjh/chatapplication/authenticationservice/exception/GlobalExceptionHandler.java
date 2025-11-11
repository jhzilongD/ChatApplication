package com.seudjh.chatapplication.authenticationservice.exception;


import com.seudjh.chatapplication.authenticationservice.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Throwable.class)
    public Result<?> handleException(Throwable err) {
        log.error("未知错误，{}",err);
        return Result.ServerError(err.getMessage());

    }

    @ExceptionHandler(value = UserException.class)
    public Result<?> handleUserException(UserException err) {
        log.error("用户错误信息，{}",err.getMessage());
        return Result.UserError(err.getCode(), err.getMessage());
    }

    @ExceptionHandler(value = CodeException.class)
    public Result<?> handleCodeException(CodeException err) {
        log.error("验证码错误，{}",err.getMessage());
        return Result.UserError(err.getCode(), err.getMessage());
    }

    @ExceptionHandler(value = DatabaseException.class)
    public Result<?> handleDatabaseException(DatabaseException err) {
        log.error("数据库存储失败，{}",err.getMessage());
        return Result.DatabaseError(err.getMessage());
    }
}
