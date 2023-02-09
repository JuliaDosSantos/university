package com.jusantos.university.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TURMA")
public class Turma implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    private Integer cursoId;


    @ElementCollection
    private List<Integer> alunosId;

    public Turma() {}

    public Turma(Integer codigo, Integer cursoId, List<Integer> alunosId) {
        this.codigo = codigo;
        this.cursoId = cursoId;
        this.alunosId = alunosId;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public List<Integer> getAlunos() {
        return alunosId;
    }

    public void setAlunos(List<Integer> alunos) {
        this.alunosId = alunos;
    }
}
