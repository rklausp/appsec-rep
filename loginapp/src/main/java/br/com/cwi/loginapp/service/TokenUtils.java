package br.com.cwi.loginapp.service;

import br.com.cwi.loginapp.domain.Usuario;
import br.com.cwi.loginapp.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TokenUtils {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    private static final String SECRET = "mySecret"; // chave secreta para assinar o token

    @Transactional
    public static String generateToken(Usuario user) {
        String token = Jwts.builder()
                .setSubject(user.getEmail())
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return token;
    }

    @Transactional
    public void     resetarSenha(String token, String novaSenha) {
        Usuario usuario = usuarioRepository.findByTokenResetarSenha(token);

        if (usuario == null) {
            throw new RuntimeException("Token inválido");
        }

        String novaSenhaCriptografada = incluirUsuarioService.getSenhaCriptografada(novaSenha);

        usuario.setSenha(novaSenhaCriptografada);
        usuario.setTokenResetarSenha(null);

        usuarioRepository.save(usuario);
    }
}
