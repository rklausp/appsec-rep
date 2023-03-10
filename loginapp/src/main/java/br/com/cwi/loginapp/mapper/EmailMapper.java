package br.com.cwi.loginapp.mapper;

import br.com.cwi.loginapp.controller.response.EmailResponse;


public class EmailMapper {

    public static EmailResponse toResponse(String entity) {
        return EmailResponse.builder()
                .email(entity)
                .build();
    }
}
