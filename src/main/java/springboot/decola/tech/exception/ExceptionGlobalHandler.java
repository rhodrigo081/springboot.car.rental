package springboot.decola.tech.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.directory.InvalidSearchFilterException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionGlobalHandler extends RuntimeException {

    private final Logger logger = LoggerFactory.getLogger(ExceptionGlobalHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {

        String error = "Invalid argument";
        String message = e.getMessage();

        logger.error(message, e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ErrorResponse(message, error,HttpStatus.UNPROCESSABLE_ENTITY.value()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException e) {

        String error ="Resource identifier not found";
        String message = e.getMessage();

        logger.error(message, e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(message, error, HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handleThrowable(Throwable e) {

        String error = "An unexpected error occurred";
        String message = e.getMessage();

        logger.error(message, e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(message, error, HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    public record ErrorResponse(String message, String error,int statusCode) {
    }

}
