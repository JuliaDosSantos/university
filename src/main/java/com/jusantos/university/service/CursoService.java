package com.jusantos.university.service;

import com.jusantos.university.entity.Curso;
import com.jusantos.university.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
}
