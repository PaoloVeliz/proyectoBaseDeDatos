package com.valtek.backend_database.persistence.validate;

import com.valtek.backend_database.domain.dto.RequestDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public String handleBusinessException(BusinessException exception) {
        printPartialBusinessException(exception);
        return createErrorResponse(exception.getExceptionCode(), exception.getExceptionMessage());
    }

    private String createErrorResponse(String code, String message) {
        return "error" + code + ":" + message;
    }

    private void printPartialBusinessException(BusinessException e) {
        int count = 0;
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            if (++count >= 3) {
                break;
            }
        }
    }
}
