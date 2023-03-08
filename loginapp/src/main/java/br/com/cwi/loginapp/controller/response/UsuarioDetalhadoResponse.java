package br.com.cwi.loginapp.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDetalhadoResponse {

    private String nome;
    private String email;
    private String telefone;
    private String foto;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
