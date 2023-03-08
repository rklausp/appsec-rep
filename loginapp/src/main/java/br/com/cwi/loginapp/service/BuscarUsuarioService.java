package br.com.cwi.loginapp.service;

import br.com.cwi.loginapp.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.loginapp.domain.Usuario;
import br.com.cwi.loginapp.mapper.UsuarioDetalhadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public UsuarioDetalhadoResponse buscar() {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();
        return UsuarioDetalhadoMapper.toResponse(usuarioAutenticado);
    }
}