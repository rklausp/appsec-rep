package br.com.cwi.loginapp.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;


@Getter
@Setter
public class AlterarUsuarioRequest {

    private String nome;


    @Email
    private String email;


    private String senha;


    private String telefone;

    private String foto;
}
