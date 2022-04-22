package br.com.rts.wefin.test.wefintestrodolpho.service;

import br.com.rts.wefin.test.wefintestrodolpho.controller.request.UsuarioRequest;
import br.com.rts.wefin.test.wefintestrodolpho.entity.Usuario;
import br.com.rts.wefin.test.wefintestrodolpho.exception.UsuarioNotFoundException;
import br.com.rts.wefin.test.wefintestrodolpho.repository.UsuarioRepository;
import br.com.rts.wefin.test.wefintestrodolpho.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class UsuarioService implements Serializable {

    @Autowired
    private UsuarioRepository repository;

    public Page<Usuario> findByNome(String nome, Pageable pageable) {
        return this.repository.findByNome(SQLUtils.formatterString(nome), pageable);
    }

    public Optional<Usuario> findOptionalByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    public Usuario findByUsername(String username) {
        return findOptionalByUsername(username).orElseThrow(UsuarioNotFoundException::new);
    }

    public Optional<Usuario> findOptionalByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    public void delete(Long idUsuario) throws Exception {
        this.repository.delete(
                findById(idUsuario));
    }

    public Usuario findById(Long idUsuario) {
        return this.findOptionalById(idUsuario).orElseThrow(UsuarioNotFoundException::new);
    }

    public Usuario save(UsuarioRequest usuarioRequest) throws Exception {

        Optional<Usuario> usuario = findOptionalByUsername(usuarioRequest.getUsername());
        if (usuario.isPresent())
            throw new Exception("Já existe usuário com este Username!");

        usuario = findOptionalByEmail(usuarioRequest.getEmail());
        if (usuario.isPresent())
            throw new Exception("Já existe usuário com este E-Mail!");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Usuario usuarioBuilder =
                Usuario.builder()
                        .email(usuarioRequest.getEmail())
                        .nome(usuarioRequest.getNome())
                        .password(
                                passwordEncoder.encode(usuarioRequest.getPassword()))
                        .username(usuarioRequest.getUsername())
                        .build();
        return this.repository.save(usuarioBuilder);
    }

    public Usuario update(Long idUsuario, UsuarioRequest usuarioRequest) throws Exception {

        Optional<Usuario> usuario = findOptionalById(idUsuario);
        if (!usuario.isPresent())
            throw new Exception("Não existe usuário com código informado!");

        usuario = findByEmailOutroUsername(usuarioRequest.getEmail(), usuarioRequest.getUsername());
        if (usuario.isPresent())
            throw new Exception("Já existe usuário com este E-Mail!");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Usuario usuarioBuilder =
                Usuario.builder()
                        .email(usuarioRequest.getEmail())
                        .nome(usuarioRequest.getNome())
                        .password(
                                passwordEncoder.encode(usuarioRequest.getPassword()))
                        .build();
        return this.repository.save(usuarioBuilder);
    }

    private Optional<Usuario> findOptionalById(Long idUsuario) {
        return this.repository.findById(idUsuario);
    }

    private Optional<Usuario> findByEmailOutroUsername(String email, String username) {
        return this.repository.findByEmailOutroUsername(
                SQLUtils.formatterString(email),
                SQLUtils.formatterString(username));
    }
}
