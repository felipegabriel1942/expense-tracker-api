package br.com.felipegabriel.expensetrackerapi.util;

import br.com.felipegabriel.expensetrackerapi.dto.ApiResponseDTO;

import br.com.felipegabriel.expensetrackerapi.config.enums.MessageEnum;
import org.springframework.http.ResponseEntity;

public class ResponseUtil<T> {

    public ResponseEntity<ApiResponseDTO<T>> ok(T payload, MessageEnum message) {
        ApiResponseDTO<T> body = ApiResponseDTO.<T>builder()
                .message(message.getValue())
                .content(payload).build();

        return ResponseEntity.ok(body);
    }

    public ResponseEntity<ApiResponseDTO<T>> ok(MessageEnum message) {
        ApiResponseDTO<T> body = ApiResponseDTO.<T>builder()
                .message(message.getValue()).build();

        return ResponseEntity.ok(body);
    }

    public ResponseEntity<ApiResponseDTO<T>> ok(T payload) {
        ApiResponseDTO<T> body = ApiResponseDTO.<T>builder().content(payload).build();

        return ResponseEntity.ok(body);
    }
}
