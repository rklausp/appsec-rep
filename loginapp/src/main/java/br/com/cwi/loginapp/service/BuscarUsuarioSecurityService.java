package br.com.cwi.loginapp.service;

import br.com.cwi.loginapp.UsuarioSecurity;
import br.com.cwi.loginapp.repository.UsuarioRepository;
import br.com.cwi.loginapp.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioSecurityService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return new UsuarioSecurity(usuario);
    }
}
