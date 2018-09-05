package main.java.leonid_shop.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ShopExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<String> onNotFoundException(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }
}