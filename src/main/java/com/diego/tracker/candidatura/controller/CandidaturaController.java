package com.diego.tracker.candidatura.controller;

import com.diego.tracker.candidatura.dto.CandidaturaRequest;
import com.diego.tracker.candidatura.dto.CandidaturaResponse;
import com.diego.tracker.candidatura.service.CandidaturaService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {

    private final CandidaturaService service;

    public CandidaturaController(CandidaturaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CandidaturaResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidaturaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CandidaturaResponse> criar(@Valid @RequestBody CandidaturaRequest request) {
        CandidaturaResponse criada = service.criar(request);
        return ResponseEntity.created(URI.create("/candidaturas/" + criada.id())).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidaturaResponse> atualizar(
            @PathVariable Long id, @Valid @RequestBody CandidaturaRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
