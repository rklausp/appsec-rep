package br.com.cwi.loginapp.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String funcao;
    private String foto;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private String tokenResetarSenha;
}
