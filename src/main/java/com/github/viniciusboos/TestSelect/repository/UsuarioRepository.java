package com.github.viniciusboos.TestSelect.repository;

import com.github.viniciusboos.TestSelect.entities.Pessoa;
import com.github.viniciusboos.TestSelect.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String username);
}
