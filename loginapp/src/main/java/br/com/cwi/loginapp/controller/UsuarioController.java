package br.com.cwi.loginapp.controller;

import br.com.cwi.loginapp.controller.request.AlterarUsuarioRequest;
import br.com.cwi.loginapp.controller.request.UsuarioRequest;
import br.com.cwi.loginapp.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.loginapp.controller.response.UsuarioResponse;
import br.com.cwi.loginapp.service.AlterarUsuarioService;
import br.com.cwi.loginapp.service.BuscarUsuarioService;
import br.com.cwi.loginapp.service.IncluirUsuarioService;
import br.com.cwi.loginapp.controller.request.UsuarioRequest;
import br.com.cwi.loginapp.controller.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @Autowired
    AlterarUsuarioService alterarUsuarioService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @PostMapping
    public UsuarioResponse incluir(@Valid @RequestBody UsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @PutMapping
    public UsuarioResponse alterar(@Valid @RequestBody AlterarUsuarioRequest request){
        return alterarUsuarioService.alterar(request);
    }

    @GetMapping("/me")
    public UsuarioDetalhadoResponse buscar() {
        return buscarUsuarioService.buscar();
    }
}
