package br.com.cwi.loginapp.service;

import br.com.cwi.loginapp.controller.request.AlterarUsuarioRequest;
import br.com.cwi.loginapp.controller.response.UsuarioResponse;
import br.com.cwi.loginapp.domain.Usuario;
import br.com.cwi.loginapp.mapper.UsuarioMapper;
import br.com.cwi.loginapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AlterarUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioResponse alterar(AlterarUsuarioRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        if(request.getNome() != null && !request.getNome().isEmpty())
            usuario.setNome(request.getNome());
        if(request.getSenha() != null && !request.getSenha().isEmpty())
            usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        if(request.getFoto() != null && !request.getFoto().isEmpty())
            usuario.setFoto(request.getFoto());
        if(request.getTelefone() != null && !request.getTelefone().isEmpty())
            usuario.setTelefone(request.getTelefone());
        if(request.getEmail() != null && !request.getEmail().isEmpty())
            usuario.setEmail(request.getEmail());

        usuario.setAtualizadoEm(LocalDateTime.now());

        usuarioRepository.save(usuario);

        return UsuarioMapper.toResponse(usuario);
    }
}
