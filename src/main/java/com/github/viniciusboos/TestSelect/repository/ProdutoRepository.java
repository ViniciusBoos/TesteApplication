package com.github.viniciusboos.TestSelect.repository;

import com.github.viniciusboos.TestSelect.entities.Pessoa;
import com.github.viniciusboos.TestSelect.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
