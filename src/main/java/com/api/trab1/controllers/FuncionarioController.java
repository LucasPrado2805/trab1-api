package com.api.trab1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.trab1.modelos.Funcionario;
import com.api.trab1.repositories.FuncionarioRepository;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Funcionario inserir(@RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com id: " + id));
    }

    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Integer id, @RequestBody Funcionario funcionarioAtualizado) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com id: " + id));

        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setEndereco(funcionarioAtualizado.getEndereco());

        return repository.save(funcionario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
