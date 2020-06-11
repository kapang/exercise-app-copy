package kp.exercise.app.error;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.collect.ImmutableList;

@ControllerAdvice
public class ExerciseAppErrorHandler extends ResponseEntityExceptionHandler {

	  private static final Logger LOG = LoggerFactory.getLogger(ExerciseAppErrorHandler.class);

	  @ExceptionHandler(value = IllegalArgumentException.class)
	  ResponseEntity<ErrorResponse> handleMyRestTemplateException(
			  IllegalArgumentException ex, HttpServletRequest request) {
        List<String> details = ImmutableList.of(ex.getLocalizedMessage());
        LOG.error("Bad Request Error ({}) due to {}", request, ex);
        ErrorResponse error = new ErrorResponse(request.getRequestURI(), details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	  }
}