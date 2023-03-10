package br.com.cwi.loginapp.service;

import br.com.cwi.loginapp.controller.request.UsuarioRequest;
import br.com.cwi.loginapp.controller.response.UsuarioResponse;
import br.com.cwi.loginapp.domain.Usuario;
import br.com.cwi.loginapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static br.com.cwi.loginapp.mapper.UsuarioMapper.toEntity;
import static br.com.cwi.loginapp.mapper.UsuarioMapper.toResponse;

@Service
public class IncluirUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioResponse incluir(UsuarioRequest request) {

        Usuario usuario = toEntity(request);
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }

    public String getSenhaCriptografada(String novaSenha) {
        return passwordEncoder.encode(novaSenha);
    }
}