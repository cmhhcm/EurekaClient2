package com.cmh.eurekaclient2.exception;

import com.cmh.eurekaclient2.vo.ResponseVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseVO globalExceptionHandler(Exception exception) {
        if (exception instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgExec = (MethodArgumentNotValidException) exception;
            BindingResult bindingResult = methodArgExec.getBindingResult();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            StringBuilder sb = new StringBuilder();
            fieldErrors.stream().forEach(eachError -> sb.append(eachError.getField() + ":" + eachError.getDefaultMessage() + ";"));
            return ResponseVO.failed(sb.toString().substring(0, sb.toString().length() - 1));
        } else if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            return ResponseVO.failed(businessException.getMessage());
        } else {
            exception.printStackTrace();
            return ResponseVO.failed(" unknown error");
        }
    }
}
