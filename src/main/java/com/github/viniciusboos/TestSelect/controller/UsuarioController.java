package com.github.viniciusboos.TestSelect.controller;

import com.github.viniciusboos.TestSelect.entities.Usuario;
import com.github.viniciusboos.TestSelect.exception.NoEmptyFieldException;
import com.github.viniciusboos.TestSelect.repository.UsuarioRepository;
import com.github.viniciusboos.TestSelect.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public void createUsuario(@RequestBody @Valid Usuario usuario) {

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    @PostMapping("/auth")
    public String autenticar(@RequestBody Usuario usuario) {
        Usuario usuario1 = usuarioRepository.findByLogin(usuario.getLogin()).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));

        boolean matches = passwordEncoder.matches(usuario.getPassword(), usuario1.getPassword());
        if (matches) {
            String token = jwtService.gerarToken(usuario);
            return token;
        }
        throw new UsernameNotFoundException("Usuario não encontrado");
    }
}
