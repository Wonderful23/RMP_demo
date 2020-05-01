package ty0207.example.demo.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ty0207.example.demo.exception.exceptions.CustomizeException;
import ty0207.example.demo.exception.exceptions.RequestValidationException;

@ControllerAdvice
public class ExceptionHandlers {

  @ExceptionHandler(value = {CustomizeException.class})
  public ResponseEntity<?> customizeExceptionHandle(CustomizeException e) {

    Map<String, Object> m = new HashMap<>();
    m.put("msg", e.getMessage());
    return new ResponseEntity<>(m, e.getCode());
  }

  @ExceptionHandler(value = {RequestValidationException.class})
  public ResponseEntity<?> requestValidationExceptionHandle(RequestValidationException e) {
    return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
  }

}
