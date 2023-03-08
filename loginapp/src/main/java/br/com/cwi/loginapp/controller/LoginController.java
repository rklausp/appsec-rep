package br.com.cwi.loginapp.controller;

import br.com.cwi.loginapp.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.loginapp.controller.response.UsuarioResponse;
import br.com.cwi.loginapp.service.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @PostMapping
    public UsuarioDetalhadoResponse login() {
        return buscarUsuarioService.buscar();
    }
}

