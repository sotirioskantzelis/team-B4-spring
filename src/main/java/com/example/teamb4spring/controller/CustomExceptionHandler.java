package com.example.teamb4spring.controller;

import com.example.teamb4spring.base.BaseComponent;
import com.example.teamb4spring.transfer.ApiError;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler extends BaseComponent {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ApiError> handleAllExceptions(final Exception ex, final WebRequest request) {
    logger.error("Unexpected exception occurred.", ex);
    return new ResponseEntity<>(
        getApiError(ex, HttpStatus.INTERNAL_SERVER_ERROR, request),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler({MissingServletRequestParameterException.class})
  protected ResponseEntity<ApiError> handleMissingServletRequestParameter(
      final MissingServletRequestParameterException ex, final WebRequest request) {
    logger.error("There was a parameter missing from incoming request", ex);
    return new ResponseEntity<>(getApiError(ex, HttpStatus.BAD_REQUEST, request),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public final ResponseEntity<ApiError> handleNonExistence(final NoSuchElementException ex,
      final WebRequest request) {
    logger.error("Reference to a non-existent object.", ex);
    return new ResponseEntity<>(
        getApiError(ex, HttpStatus.NOT_FOUND, request, "Reference to a non-existent object."),
        HttpStatus.NOT_FOUND);
  }



  private ApiError getApiError(final Exception ex, final HttpStatus status, final WebRequest request) {
    String path = request.getDescription(false);
    if (path.indexOf("uri=") == 0) {
      path = StringUtils.replace(path, "uri=", "");
    }
    return new ApiError(status.value(), ex.getMessage(), path);
  }

  private ApiError getApiError(final Exception ex, final HttpStatus status, final WebRequest request,
      String customMessage) {
    String path = request.getDescription(false);
    if (path.indexOf("uri=") == 0) {
      path = StringUtils.replace(path, "uri=", "");
    }
    return new ApiError(status.value(), customMessage != null ? customMessage : ex.getMessage(), path);
  }

}
