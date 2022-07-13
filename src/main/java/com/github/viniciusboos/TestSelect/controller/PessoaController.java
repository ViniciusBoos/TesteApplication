package com.github.viniciusboos.TestSelect.controller;

import com.github.viniciusboos.TestSelect.entities.Pessoa;
import com.github.viniciusboos.TestSelect.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@RequestBody @Valid Pessoa pessoa) {
        Pessoa pessoaASerSalva = new Pessoa(pessoa);
        pessoaRepository.save(pessoa);
        return ResponseEntity.ok(pessoaASerSalva);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getPessoa(Pessoa pessoa) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Pessoa> example = Example.of(pessoa, matcher);
        List<Pessoa> pessoas = pessoaRepository.findAll(example);
        return ResponseEntity.ok(pessoas);
    }
}
