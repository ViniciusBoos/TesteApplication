package com.github.viniciusboos.TestSelect.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{campo.nome-pessoa.obrigatorio}")
    private String nome;
    @NotNull(message = "{campo.sobrenome-pessoa.obrigatorio}")
    private String sobrenome;
    @NotNull(message = "{campo.cpf-pessoa.obrigatorio}")
    private String cpf;
    @NotNull(message = "{campo.idade-pessoa.obrigatorio}")
    private String idade;

    public Pessoa() {
    }

    public Pessoa(Pessoa pessoa) {
        this.id = pessoa.id;
        this.nome = pessoa.nome;
        this.sobrenome = pessoa.sobrenome;
        this.cpf = pessoa.cpf;
        this.idade = pessoa.idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
