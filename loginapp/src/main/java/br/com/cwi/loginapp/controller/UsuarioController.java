package br.com.cwi.loginapp.controller;

import br.com.cwi.loginapp.controller.request.AlterarUsuarioRequest;
import br.com.cwi.loginapp.controller.request.EmailRequest;
import br.com.cwi.loginapp.controller.request.UsuarioRequest;
import br.com.cwi.loginapp.controller.response.EmailResponse;
import br.com.cwi.loginapp.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.loginapp.controller.response.UsuarioResponse;
import br.com.cwi.loginapp.domain.Usuario;
import br.com.cwi.loginapp.service.AlterarUsuarioService;
import br.com.cwi.loginapp.service.BuscarUsuarioService;
import br.com.cwi.loginapp.service.EmailService;
import br.com.cwi.loginapp.service.IncluirUsuarioService;
import br.com.cwi.loginapp.controller.request.UsuarioRequest;
import br.com.cwi.loginapp.controller.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @Autowired
    private  AlterarUsuarioService alterarUsuarioService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private EmailService emailService;

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
