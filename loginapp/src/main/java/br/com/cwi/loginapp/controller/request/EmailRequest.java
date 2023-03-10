package br.com.cwi.loginapp.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class EmailRequest {

    @NotBlank
    private String email;
}
