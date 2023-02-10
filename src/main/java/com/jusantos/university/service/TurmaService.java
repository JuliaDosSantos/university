package com.jusantos.university.service;

import com.jusantos.university.entity.Turma;
import com.jusantos.university.entity.dto.AlunoRequest;
import com.jusantos.university.entity.dto.TurmaResponse;
import com.jusantos.university.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public List<TurmaResponse> getAll() {
        List<Turma> turmas = turmaRepository.findAll();
        List<TurmaResponse> turmaResponses = new ArrayList<>();
        for (Turma turma: turmas) {
            TurmaResponse turmaResponse = new TurmaResponse();
            turmaResponse.setCodigo(turma.getCodigo());
            turmaResponse.setCursoId(turma.getCursoId());
            turmaResponses.add(turmaResponse);
        }

        return turmaResponses;
    }

    public void insert(Turma turma) {
        turmaRepository.save(turma);
    }

    public Turma getTurmaById(Integer id){
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        if (turmaOptional.get() != null) {
            return turmaOptional.get();
        }

        return null;
    }

    public void alterarTurma(Turma turmaEntrada) {
        Turma turma = getTurmaById(turmaEntrada.getCodigo());
        turma.setCursoId(turmaEntrada.getCursoId());
        turma.setAlunos(turmaEntrada.getAlunos());

        turmaRepository.save(turma);
    }

    public void deleteTurma(Integer id){
        turmaRepository.deleteById(id);
    }
}
