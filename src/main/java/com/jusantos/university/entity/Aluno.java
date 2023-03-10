package com.jusantos.university.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ALUNO")
public class Aluno implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer matricula;

    private String nome;

    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> cursoId;

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getCursosId() {
        return cursoId;
    }

    public void setCursosId(List<Integer> curso) {
        this.cursoId = curso;
    }
}
