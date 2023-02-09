package com.jusantos.university.controller;

import com.jusantos.university.entity.Curso;
import com.jusantos.university.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("/all")
    public List<Curso> getAll() {
        return cursoService.getAll();
    }

    @PostMapping()
    public void insert(@RequestBody Curso curso) {
        cursoService.insert(curso);
    }

    @GetMapping("/cursobyid/{Id}")
    public Curso getCursoById(@PathVariable Integer id) {
        return cursoService.getCursoById(id);
    }

    @PutMapping("/alterarcurso")
    public void alterarCurso(@RequestBody Curso cursoEntrada){
       cursoService.alterarCurso(cursoEntrada);

    }

    @DeleteMapping("/deletecurso/{id}")
    public void deleteCurso(@PathVariable Integer id) {
        cursoService.deleteCurso(id);

    }

}
