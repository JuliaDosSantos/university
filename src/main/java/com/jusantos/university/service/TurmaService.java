package com.jusantos.university.service;

import com.jusantos.university.entity.Turma;
import com.jusantos.university.entity.dto.TurmaResponse;
import com.jusantos.university.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


}
