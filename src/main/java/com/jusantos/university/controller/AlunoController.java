package com.jusantos.university.controller;

import com.jusantos.university.entity.Aluno;
import com.jusantos.university.entity.dto.AlunoRequest;
import com.jusantos.university.entity.dto.AlunoResponse;
import com.jusantos.university.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping("/all")
    public List<AlunoResponse> getAll() {
        return alunoService.getAll();
    }

    @PostMapping()
    public void insert(@RequestBody AlunoRequest alunoRequest) {
        alunoService.insert(alunoRequest);
    }

    @GetMapping("/alunoId/{matricula}")
    public Aluno getAlunoById(@PathVariable Integer matricula) {
        return alunoService.getAlunoById(matricula);
    }

    @PutMapping("/alteraraluno")
    public void alterarAluno(@RequestBody Aluno alunoEntrada) {
        alunoService.alterarAluno(alunoEntrada);
    }

    @DeleteMapping("/deletealuno/{matricula}")
    public void deleteAluno(@PathVariable Integer matricula) {
        alunoService.deleteAluno(matricula);
    }
}
