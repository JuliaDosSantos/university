package com.jusantos.university.service;

import com.jusantos.university.entity.Aluno;
import com.jusantos.university.entity.dto.AlunoRequest;
import com.jusantos.university.entity.dto.AlunoResponse;
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

    public List<AlunoResponse> getAll() {
        List<Aluno> alunos = alunoRepository.findAll();
        List<AlunoResponse> alunoResponses = new ArrayList<>();
        for (Aluno aluno: alunos) {
            AlunoResponse alunoResponse = new AlunoResponse();
            alunoResponse.setMatricula(aluno.getMatricula());
            alunoResponse.setNome(aluno.getNome());
            alunoResponse.setEmail(aluno.getEmail());
            alunoResponses.add(alunoResponse);
        }
        return alunoResponses;
    }

    public void insert(AlunoRequest alunoRequest) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoRequest.getNome());
        aluno.setEmail(alunoRequest.getEmail());

        List<Integer> cursos = new ArrayList<>();
        cursos.add(alunoRequest.getCursoId());
        aluno.setCursosId(cursos);

        alunoRepository.save(aluno);
    }

    public Aluno getAlunoById(Integer matricula) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(matricula);
        if (alunoOptional.get() != null) {
            return alunoOptional.get();
        }
        return null;
    }

    public void alterarAluno (Aluno alunoEntrada) {
        Aluno aluno = getAlunoById(alunoEntrada.getMatricula());
        aluno.setNome(alunoEntrada.getNome());
        aluno.setEmail(alunoEntrada.getEmail());

        alunoRepository.save(aluno);
    }
}
