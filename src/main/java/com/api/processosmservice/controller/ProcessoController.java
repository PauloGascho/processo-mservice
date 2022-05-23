package com.api.processosmservice.controller;

import com.api.processosmservice.model.Processo;
import com.api.processosmservice.service.ProcessoService;
import lombok.AllArgsConstructor;
import static lombok.AccessLevel.PRIVATE;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processos")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ProcessoController {

    ProcessoService processoService;

    @GetMapping
    public ResponseEntity<List<Processo>> listarProcessos() {
        var processos = this.processoService.findAll();
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/numeros")
    public ResponseEntity<List<Integer>> listarNumeros() {
        List<Integer> numeros = this.processoService.findNumeros();
        return ResponseEntity.ok(numeros);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Processo> create(@RequestBody Processo processo) {
        var processoCriado = this.processoService.create(processo);
        return ResponseEntity.ok().body(processoCriado);
    }

    @PutMapping
    public ResponseEntity<Processo> addReu(
            @RequestParam Integer numero,
            @RequestParam String reu
    ) {
        var processoAlterado = this.processoService.addReu(numero, reu);
        return ResponseEntity.ok().body(processoAlterado);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestParam Integer numero) {
        this.processoService.delete(numero);
        return ResponseEntity.ok().build();
    }
}
