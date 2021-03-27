package com.pdr.starter.cliente.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Control de excepciones globales y de ingreso
 * 
 * @author NelsonAlvaradoVidal
 *
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * Proporciona manejo de excepciones a lo largo de este servicio.
	 *
	 * @param ex      The target exception
	 * @param request The current request
	 */
	@ExceptionHandler({ UserNotFoundException.class, ContentNotAllowedException.class,
			MethodArgumentNotValidException.class, DependencyException.class, InsertOrUpdateException.class })
	@Nullable
	public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();

		log.error("Manejo " + ex.getClass().getSimpleName() + " debido a " + ex.getMessage());

		if (ex instanceof UserNotFoundException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			UserNotFoundException unfe = (UserNotFoundException) ex;
			return handleCommonException(unfe, headers, status, request);

		} else if (ex instanceof DependencyException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			DependencyException cnae = (DependencyException) ex;
			return handleDependencyException(cnae, headers, status, request);

		} else if (ex instanceof ExistException) {
			HttpStatus status = HttpStatus.CONFLICT;
			ExistException cnae = (ExistException) ex;
			return handleExistException(cnae, headers, status, request);

		} else if (ex instanceof DependencyException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StoredProcedureException cnae = (StoredProcedureException) ex;
			return handleStoreProcedureException(cnae, headers, status, request);

		} else if (ex instanceof InsertOrUpdateException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			InsertOrUpdateException cnae = (InsertOrUpdateException) ex;
			return handleInsertOrUpdateException(cnae, headers, status, request);

		} else if (ex instanceof ContentNotAllowedException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			ContentNotAllowedException cnae = (ContentNotAllowedException) ex;
			return handleContentNotAllowedException(cnae, headers, status, request);

		} else if (ex instanceof MethodArgumentNotValidException) {
			BindingResult result = ((MethodArgumentNotValidException) ex).getBindingResult();
			List<FieldError> fieldErrors = result.getFieldErrors();

			// obtiene la validacion de los campos obligatorios
			List<String> errorMessage = new ArrayList<>();
			fieldErrors.forEach(f -> errorMessage.add(f.getField() + " " + f.getDefaultMessage()));
			HttpStatus status = HttpStatus.BAD_REQUEST;
			MethodArgumentNotValidException excp = (MethodArgumentNotValidException) ex;
			return handleCommonException(excp, headers, status, request, errorMessage);

		} else {
			if (log.isWarnEnabled()) {
				log.warn("Unknown exception type: " + ex.getClass().getName());
			}

			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleExceptionInternal(ex, null, headers, status, request);
		}
	}

	@ExceptionHandler({ UserNotAuthException.class, GenerarDocumentException.class, DataNotFoundException.class,
			NotFoundException.class })
	@Nullable
	public final ResponseEntity<ApiError> handleNotAuthException(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		log.error("Manejo " + ex.getClass().getSimpleName() + " debido a " + ex.getMessage());

		if (ex instanceof UserNotAuthException) {
			HttpStatus status = HttpStatus.UNAUTHORIZED;
			UserNotAuthException unfe = (UserNotAuthException) ex;
			return handleCommonException(unfe, headers, status, request);
		} else if (ex instanceof NotFoundException) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			NotFoundException unfe = (NotFoundException) ex;
			return handleCommonException(unfe, headers, status, request);
		} else if (ex instanceof GenerarDocumentException){
			HttpStatus status = HttpStatus.BAD_REQUEST;
			GenerarDocumentException unfe = (GenerarDocumentException) ex;
			return handleCommonException(unfe, headers, status, request);
		} else if (ex instanceof DataNotFoundException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			DataNotFoundException unfe = (DataNotFoundException) ex;
			return handleCommonException(unfe, headers, status, request);
		} else {
			if (log.isWarnEnabled()) {
				log.warn("Unknown exception type: " + ex.getClass().getName());
			}

			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleExceptionInternal(ex, null, headers, status, request);
		}

	} 
	
	@ExceptionHandler(NoMeetConditionException.class)
	@Nullable
	public final ResponseEntity<ApiError> handleValidationError(Exception ex, WebRequest request) {
		
		HttpHeaders headers = new HttpHeaders();
		BindingResult result = ((NoMeetConditionException) ex).getBindingResult();
		List<ObjectError> fieldErrors = result.getAllErrors();
		List<String> errorMessage = new ArrayList<>();
		fieldErrors.forEach(f -> errorMessage.add(f.getDefaultMessage()));
		HttpStatus status = HttpStatus.BAD_REQUEST;
		NoMeetConditionException excp = (NoMeetConditionException) ex;
		return handleCommonException(excp, headers, status, request, errorMessage);
	}

	/**
	 * Personalizar la respuesta para handleNotFoundException.
	 *
	 * @param ex      The exception
	 * @param headers The headers to be written to the response
	 * @param status  The selected response status
	 * @return a {@code ResponseEntity} instance
	 */
	protected ResponseEntity<ApiError> handleCommonException(Exception ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		List<String> errors = Collections.singletonList(ex.getMessage());
		log.error("[handleCommonException]HttpHeaders --> " + headers.toString());
		log.error("[handleCommonException]HttpStatus --> " + status.toString());
		log.error("[handleCommonException]error --> " + ex.getLocalizedMessage(), ex);
		return handleExceptionInternal(ex, new ApiError(status, errors), headers, status, request);
	}

	/**
	 * Personalizar la respuesta para ExisteException.
	 *
	 * @param ex      The exception
	 * @param headers The headers to be written to the response
	 * @param status  The selected response status
	 * @return a {@code ResponseEntity} instance
	 */
	protected ResponseEntity<ApiError> handleExistException(Exception ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		List<String> errors = Collections.singletonList(ex.getMessage());
		log.error("[handleCommonException]HttpHeaders --> " + headers.toString());
		log.error("[handleCommonException]HttpStatus --> " + status.toString());
		log.error("[handleCommonException]error --> " + ex.getLocalizedMessage(), ex);
		return handleExceptionInternal(ex, new ApiError(status, errors), headers, status, request);
	}

	/**
	 * Personalizar la respuesta para handleNotFoundException.
	 * 
	 * @param ex      The exception
	 * @param headers The headers to be written to the response
	 * @param status  The selected response status
	 * @param request
	 * @param errors
	 * @return a {@code ResponseEntity} instance
	 */
	protected ResponseEntity<ApiError> handleCommonException(Exception ex, HttpHeaders headers, HttpStatus status,
			WebRequest request, List<String> errors) {
		log.error("[handleCommonException]HttpHeaders --> " + headers.toString());
		log.error("[handleCommonException]HttpStatus --> " + status.toString());
		//log.error("[handleCommonException]error --> " + ex.getLocalizedMessage(), ex);
		return handleExceptionInternal(ex, new ApiError(status, errors), headers, status, request);
	}

	/**
	 * Personalizar la respuesta paraContentNotAllowedException.
	 *
	 * @param ex      The exception
	 * @param headers The headers to be written to the response
	 * @param status  The selected response status
	 * @return a {@code ResponseEntity} instance
	 */
	protected ResponseEntity<ApiError> handleContentNotAllowedException(ContentNotAllowedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getErrors().stream()
				.map(contentError -> contentError.getObjectName() + " " + contentError.getDefaultMessage())
				.collect(Collectors.toList());
		log.error("[handleContentNotAllowedException]HttpHeaders --> " + headers.toString());
		log.error("[handleContentNotAllowedException]HttpStatus --> " + status.toString());
		log.error("[handleContentNotAllowedException]error --> " + ex.getLocalizedMessage(), ex);
		return handleExceptionInternal(ex, new ApiError(status, errorMessages), headers, status, request);
	}

	/**
	 * Personalizar la respuesta para DependencyException.
	 *
	 * @param ex      The exception
	 * @param headers The headers to be written to the response
	 * @param status  The selected response status
	 * @return a {@code ResponseEntity} instance
	 */
	protected ResponseEntity<ApiError> handleDependencyException(DependencyException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> errorMessages = new ArrayList<>();
		errorMessages.add(ex.getMessage());
		log.error("[handleDependencyException]HttpHeaders --> " + headers.toString());
		log.error("[handleDependencyException]HttpStatus --> " + status.toString());
		log.error("[handleDependencyException]error --> " + ex.getLocalizedMessage(), ex);
		return handleExceptionInternal(ex, new ApiError(status, errorMessages), headers, status, request);
	}

	/**
	 * Personalizar la respuesta para StoredProcedureException.
	 *
	 * @param cnae    The exception
	 * @param headers The headers to be written to the response
	 * @param status  The selected response status
	 * @return a {@code ResponseEntity} instance
	 */
	protected ResponseEntity<ApiError> handleStoreProcedureException(StoredProcedureException cnae, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> errorMessages = new ArrayList<>();
		errorMessages.add(cnae.getMessage());
		log.error("[handleDependencyException]HttpHeaders --> " + headers.toString());
		log.error("[handleDependencyException]HttpStatus --> " + status.toString());
		log.error("[handleDependencyException]error --> " + cnae.getLocalizedMessage(), cnae);
		return handleExceptionInternal(cnae, new ApiError(status, errorMessages), headers, status, request);
	}

	/**
	 * Personalizar la respuesta para InsertOrUpdateException.
	 *
	 * @param ex      The exception
	 * @param headers The headers to be written to the response
	 * @param status  The selected response status
	 * @return a {@code ResponseEntity} instance
	 */
	protected ResponseEntity<ApiError> handleInsertOrUpdateException(InsertOrUpdateException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> errorMessages = new ArrayList<>();
		errorMessages.add(ex.getMessage());
		log.error("[handleInsertOrUpdateException]HttpHeaders --> " + headers.toString());
		log.error("[handleInsertOrUpdateException]HttpStatus --> " + status.toString());
		log.error("[handleInsertOrUpdateException]error --> " + ex.getLocalizedMessage(), ex);
		return handleExceptionInternal(ex, new ApiError(status, errorMessages), headers, status, request);
	}

	/**
	 * Personalizacion de "response body" de todos los tipos de excepción.
	 *
	 * <p>
	 * La implementación predeterminada establece el
	 * {@link WebUtils#ERROR_EXCEPTION_ATTRIBUTE} solicitar atributo y crea un
	 * {@link ResponseEntity} de lo dado body, headers, and status.
	 *
	 * @param ex      The exception
	 * @param body    The body for the response
	 * @param headers The headers for the response
	 * @param status  The response status
	 * @param request The current request
	 */
	protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, @Nullable ApiError body,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}
		return new ResponseEntity<>(body, headers, status);
	}
}
