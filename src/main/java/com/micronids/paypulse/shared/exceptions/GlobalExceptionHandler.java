package com.micronids.paypulse.shared.exceptions;

import com.micronids.paypulse.shared.exceptions.exception.DuplicateResourceException;
import com.micronids.paypulse.shared.exceptions.exception.ResourceNotFoundException;
import com.micronids.paypulse.shared.utils.BuildErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.micronids.paypulse.shared.generic.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse<Object>> handleDuplicateResourceException(
            DuplicateResourceException ex, WebRequest request) {

        String path = request.getDescription(false).replace("uri=","");
        ErrorResponse<Object> errorResponse = BuildErrorResponse.buildErrorResponse(
                HttpStatus.CONFLICT,
                ex.getMessage(),
                path,
                null
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        String path = request.getDescription(false).replace("url=","");
        ErrorResponse<Object> errorResponse = BuildErrorResponse.buildErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                path,
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}


