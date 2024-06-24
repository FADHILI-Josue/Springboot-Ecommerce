package com.fadhili.Ecommerce.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.fadhili.Ecommerce.exceptions.AlreadyExistsException;
import com.fadhili.Ecommerce.exceptions.AlreadyExistsExceptionDetails;
import com.fadhili.Ecommerce.exceptions.BadRequestException;
import com.fadhili.Ecommerce.exceptions.BadRequestExceptionDetails;
import com.fadhili.Ecommerce.exceptions.BusinessException;
import com.fadhili.Ecommerce.exceptions.BusinessExceptionDetails;
import com.fadhili.Ecommerce.exceptions.ExceptionDetails;
import com.fadhili.Ecommerce.exceptions.NotFoundException;
import com.fadhili.Ecommerce.exceptions.NotFoundExceptionDetails;
import com.fadhili.Ecommerce.exceptions.ValidationExceptionDetails;

import io.micrometer.common.lang.Nullable;

@RestControllerAdvice
// @Log4j2
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException bre) {
        return new ResponseEntity<>(
            BadRequestExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception, Check the Documentation")
                .details(bre.getMessage())
                .developerMessage(bre.getClass().getName())
                .build(), 
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDetails> handleNotFoundException(NotFoundException nfe) {
        return new ResponseEntity<>(
            NotFoundExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("null")
                .details(nfe.getMessage())
                .developerMessage(nfe.getClass().getName())
                .build(),
            HttpStatus.NOT_FOUND  
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BusinessExceptionDetails> handleBusinessException(BusinessException be) {
        return new ResponseEntity<>(
            BusinessExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .title("Business Exception, Check Documentation")
                .details(be.getMessage())
                .developerMessage(be.getClass().getName())
                .build(),
            HttpStatus.UNPROCESSABLE_ENTITY  
        );
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<AlreadyExistsExceptionDetails> handleAlreadyExistsException(AlreadyExistsException aee) {
        return new ResponseEntity<>(
            AlreadyExistsExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .title("Already Exists Exception, Check Documentation")
                .details(aee.getMessage())
                .developerMessage(aee.getClass().getName())
                .build(),
            HttpStatus.CONFLICT  
        );
    }
    
    //*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(
            ValidationExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception, Invalid Fields")
                .details("Check the field(s) error")
                .developerMessage(exception.getClass().getName())
                .fields(fields)
                .fieldsMessage(fieldsMessage)
                .build(), 
            HttpStatus.BAD_REQUEST
        );
    } // */

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, 
            HttpStatus status, WebRequest request) {

        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
            .timestamp(LocalDateTime.now())
            .status(status.value())
            .title(ex.getCause().getMessage())
            .details(ex.getMessage())
            .developerMessage(ex.getClass().getName())
            .build();

        return new ResponseEntity<>(exceptionDetails, headers, status);
    }

}
