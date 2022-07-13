package com.github.viniciusboos.TestSelect.repository;

import com.github.viniciusboos.TestSelect.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
