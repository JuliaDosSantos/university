package com.jusantos.university.service;

import com.jusantos.university.entity.Aluno;
import com.jusantos.university.entity.Curso;
import com.jusantos.university.entity.dto.AlunoDTO;
import com.jusantos.university.repository.AlunoRepository;
import com.jusantos.university.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    CursoRepository cursoRepository;

    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    public void insert(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());

        alunoRepository.save(aluno);
    }
}
