package br.com.cwi.loginapp.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizarSenhaRequest {
    private String token;
    private String novaSenha;
}
