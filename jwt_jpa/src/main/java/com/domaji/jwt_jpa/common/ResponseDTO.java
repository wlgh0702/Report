package com.domaji.jwt_jpa.common;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ResponseDTO {

    private int status;
    private String message;
    private Object data;

    public ResponseDTO(HttpStatus http, String message, Object data) {
        this.status = http.value();
        this.message = message;
        this.data = data;
    }
}
