package com.springfeatures.springrestservice.errorhandling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler {

    private static final Logger LOGGER = LogManager.getLogger(ErrorHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> invalidArgumentsException(Exception ex) {
        Map<String, Object> responseBodyMap = new HashMap<>();
        responseBodyMap.put("message", ex.getMessage());
        responseBodyMap.put("code", HttpStatus.BAD_REQUEST);

        LOGGER.info(ex);

        return new ResponseEntity<>(responseBodyMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> uncheckedException(RuntimeException ex) {
        Map<String, Object> responseBodyMap = new HashMap<>();
        responseBodyMap.put("message", ex.getMessage());
        responseBodyMap.put("code", HttpStatus.INTERNAL_SERVER_ERROR);

        LOGGER.error(ex);

        return new ResponseEntity<>(responseBodyMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
