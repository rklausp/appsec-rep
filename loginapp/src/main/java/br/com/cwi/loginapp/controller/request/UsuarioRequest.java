package br.com.cwi.loginapp.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class UsuarioRequest {

    @NotBlank
    private String nome;

    @NotNull @Email
    private String email;

    @NotNull
    private String senha;

    @NotBlank
    private String telefone;

    @NotNull
    private String funcao;

    @NotNull
    private String foto;
}
