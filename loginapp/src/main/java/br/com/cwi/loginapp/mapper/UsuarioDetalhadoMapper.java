package br.com.cwi.loginapp.mapper;

import br.com.cwi.loginapp.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.loginapp.controller.response.UsuarioResponse;
import br.com.cwi.loginapp.domain.Usuario;

public class UsuarioDetalhadoMapper {

    public static UsuarioDetalhadoResponse toResponse(Usuario entity) {
        return UsuarioDetalhadoResponse.builder()
                .nome(entity.getNome())
                .email(entity.getEmail())
                .telefone(entity.getTelefone())
                .foto(entity.getFoto())
                .criadoEm(entity.getCriadoEm())
                .atualizadoEm(entity.getAtualizadoEm())
                .build();
    }
}
