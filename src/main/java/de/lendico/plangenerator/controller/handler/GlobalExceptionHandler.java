package de.lendico.plangenerator.controller.handler;

import de.lendico.plangenerator.controller.model.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception handlers.
 *
 * @author Andrei
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_CODE = "1";
    private static final String DEFAULT_ERROR_MESSAGE = "System error";

    private static final String ARG_NOT_VALID_ERROR_CODE = "2";
    private static final String ARG_NOT_VALID_ERROR_MESSAGE = "Request validation error";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleArgumentNotValidRequest() {
        final BaseResponse response = new BaseResponse();
        response.setSuccess(Boolean.FALSE);
        response.setErrorCode(ARG_NOT_VALID_ERROR_CODE);
        response.setMessage(ARG_NOT_VALID_ERROR_MESSAGE);
        return response;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public BaseResponse otherHandleException() {
        final BaseResponse response = new BaseResponse();
        response.setSuccess(Boolean.FALSE);
        response.setErrorCode(DEFAULT_ERROR_CODE);
        response.setMessage(DEFAULT_ERROR_MESSAGE);
        return response;
    }
}
