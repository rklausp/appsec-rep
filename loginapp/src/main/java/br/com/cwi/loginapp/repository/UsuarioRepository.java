package br.com.cwi.loginapp.repository;


import br.com.cwi.loginapp.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario findByTokenResetarSenha(String token);
}