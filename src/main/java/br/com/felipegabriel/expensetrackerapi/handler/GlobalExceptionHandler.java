package br.com.felipegabriel.expensetrackerapi.handler;

import br.com.felipegabriel.expensetrackerapi.config.enums.ExceptionEnum;
import br.com.felipegabriel.expensetrackerapi.exception.TransactionNotFound;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Locale;


@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LogManager.getLogger();

    private final MessageSource messageSource;

    @ExceptionHandler(TransactionNotFound.class)
    public ResponseEntity<Object> handleTransactionNotFound(Exception e, WebRequest request) {
        return handleException(e, ExceptionEnum.TRANSACTION_NOT_FOUND);
    }

    private ResponseEntity<Object> handleException(Exception e, ExceptionEnum exceptionEnum) {
        ErrorApi error = getErrorApi(exceptionEnum);
        printExceptionLog(e);
        return new ResponseEntity<>(error, exceptionEnum.getHttpStatus());
    }

    private void printExceptionLog(Exception e) {
        LOG.info(ExceptionUtils.getStackTrace(e));
    }

    private  ErrorApi getErrorApi(ExceptionEnum exceptionEnum) {
        return ErrorApi.builder()
                .code(exceptionEnum.getCode())
                .message(getErrorMessage(exceptionEnum))
                .date(LocalDateTime.now())
                .build();
    }

    private String getErrorMessage(ExceptionEnum exceptionEnum) {
        return messageSource.getMessage(
                exceptionEnum.getMessageKey(), new Object[] {}, Locale.getDefault());
    }
}
