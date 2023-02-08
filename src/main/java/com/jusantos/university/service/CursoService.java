package com.jusantos.university.service;

import com.jusantos.university.entity.Curso;
import com.jusantos.university.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public List<Curso> getAll() {
        return cursoRepository.findAll();
    }

    public void insert(Curso curso) {
        cursoRepository.save(curso);
    }

    public Curso getCursoById(Integer Id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(Id);
        if (cursoOptional.get() != null) {
            return cursoOptional.get();
        }
        return null;
    }

    public void alterarCurso(Curso cursoEntrada){
        Curso curso = getCursoById(cursoEntrada.getId());
        curso.setNome(cursoEntrada.getNome());
        curso.setPreco(cursoEntrada.getPreco());

        cursoRepository.save(curso);

    }
}
