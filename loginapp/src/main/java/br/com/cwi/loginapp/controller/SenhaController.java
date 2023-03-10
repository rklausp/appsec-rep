package br.com.cwi.loginapp.controller;


import br.com.cwi.loginapp.controller.request.AtualizarSenhaRequest;
import br.com.cwi.loginapp.domain.Usuario;
import br.com.cwi.loginapp.repository.UsuarioRepository;
import br.com.cwi.loginapp.service.EmailService;
import br.com.cwi.loginapp.service.TokenUtils;
import br.com.cwi.loginapp.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

import static br.com.cwi.loginapp.service.TokenUtils.generateToken;

@RestController
@RequestMapping("/senha")
public class SenhaController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private TokenUtils tokenUtils;

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @PostMapping("/esqueci-senha/{email}")
    public void forgotPassword(@PathVariable String email) throws MessagingException {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário com e-mail " + email + " não encontrado");
        }

        String token = generateToken(usuario);

        usuario.setTokenResetarSenha(token);

        usuarioRepository.save(usuario);

        String body = "Para recuperar sua senha, acesse o seguinte link: http://localhost:3000/recuperar-senha?token=" + token;

        emailService.enviar(email, "Recuperação de senha", body);
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @PostMapping("/recuperar-senha")
    public void resetPassword(@RequestBody AtualizarSenhaRequest request) {
        Usuario usuario = usuarioRepository.findByTokenResetarSenha(request.getToken());

        tokenUtils.resetarSenha( request.getToken(),  request.getNovaSenha());
    }
}
