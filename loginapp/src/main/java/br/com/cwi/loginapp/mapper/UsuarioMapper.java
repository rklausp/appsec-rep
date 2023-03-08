package br.com.cwi.loginapp.mapper;

import br.com.cwi.loginapp.controller.request.UsuarioRequest;
import br.com.cwi.loginapp.controller.response.UsuarioResponse;
import br.com.cwi.loginapp.domain.Usuario;


import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNome(request.getNome());
        entity.setEmail(request.getEmail());
        entity.setTelefone(request.getTelefone());
        entity.setFoto(request.getFoto());
        entity.setFuncao(request.getFuncao());
        entity.setCriadoEm(LocalDateTime.now());
        entity.setAtualizadoEm(LocalDateTime.now());
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        return UsuarioResponse.builder()
                .nome(entity.getNome())
                .email(entity.getEmail())
                .build();
    }
}
