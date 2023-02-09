package com.jusantos.university.controller;

import com.jusantos.university.entity.Turma;
import com.jusantos.university.entity.dto.TurmaResponse;
import com.jusantos.university.service.AlunoService;
import com.jusantos.university.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @GetMapping("/all")
    public List<TurmaResponse> getAll() {
        return turmaService.getAll();
    }

    @PostMapping
    public void insert(@RequestBody Turma turma) {
        turmaService.insert(turma);
    }

    @GetMapping("/turmabyid/{id}")
    public Turma getTurmaById(@PathVariable Integer id){
        return turmaService.getTurmaById(id);
    }

}
