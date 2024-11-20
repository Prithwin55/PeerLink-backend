package com.peerlink_backend.peerlink_backend.data.exception.handle;

import com.peerlink_backend.peerlink_backend.data.exception.ResourceAlreadyExistException;
import com.peerlink_backend.peerlink_backend.data.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> otherException(Exception ue, WebRequest req){
        ErrorDetails errorDetails=new ErrorDetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> otherException(ResourceNotFoundException ue, WebRequest req){
        ErrorDetails errorDetails=new ErrorDetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> otherException(ResourceAlreadyExistException ue, WebRequest req){
        ErrorDetails errorDetails=new ErrorDetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
