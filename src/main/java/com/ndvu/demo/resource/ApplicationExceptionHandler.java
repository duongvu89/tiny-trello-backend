package com.ndvu.demo.resource;

import com.ndvu.demo.TinyTrelloBackEndApplication;
import com.ndvu.demo.exception.BadRequestException;
import com.ndvu.demo.exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LogManager.getLogger(TinyTrelloBackEndApplication.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleInternalServerException(ResourceNotFoundException exception) {
        logger.error(exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handleInternalServerException(BadRequestException exception) {
        logger.error(exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
