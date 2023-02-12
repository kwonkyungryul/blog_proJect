package shop.mtcoding.myblog.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import shop.mtcoding.myblog.handler.ex.CustomException;
import shop.mtcoding.myblog.util.Script;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> customException(CustomException e) {
        return new ResponseEntity<>(Script.back(e.getMessage()), e.getStatus());
    }
}