package br.com.cwi.loginapp;


import br.com.cwi.loginapp.domain.Usuario;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioSecurity implements UserDetails {

    private static final String PREFIXO_PERMISSAO_SPRING = "ROLE_";

    private Long id;
    private String email;
    private String telefone;
    private String senha;
    private String foto;

    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private SimpleGrantedAuthority funcao;

    public UsuarioSecurity(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.telefone = usuario.getTelefone();
        this.funcao = converteFuncao(usuario);
        this.foto = usuario.getFoto();
        this.criadoEm = usuario.getCriadoEm();
        this.atualizadoEm = usuario.getAtualizadoEm();
    }

    private SimpleGrantedAuthority converteFuncao(Usuario usuario) {
        return new SimpleGrantedAuthority(PREFIXO_PERMISSAO_SPRING + usuario.getFuncao());
    }

    public Long getId() {
        return id;
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> lista = new ArrayList<SimpleGrantedAuthority>();
        lista.add(this.funcao);
        return lista;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
