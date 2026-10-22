package com.diego.tracker.candidatura.service;

import com.diego.tracker.candidatura.dto.CandidaturaRequest;
import com.diego.tracker.candidatura.dto.CandidaturaResponse;
import com.diego.tracker.candidatura.entity.Candidatura;
import com.diego.tracker.candidatura.exception.CandidaturaNotFoundException;
import com.diego.tracker.candidatura.mapper.CandidaturaMapper;
import com.diego.tracker.candidatura.repository.CandidaturaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidaturaService {

    private final CandidaturaRepository repository;
    private final CandidaturaMapper mapper;

    public CandidaturaService(CandidaturaRepository repository, CandidaturaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<CandidaturaResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public CandidaturaResponse buscarPorId(Long id) {
        return mapper.toResponse(obterEntidade(id));
    }

    public CandidaturaResponse criar(CandidaturaRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public CandidaturaResponse atualizar(Long id, CandidaturaRequest request) {
        Candidatura candidatura = obterEntidade(id);
        mapper.atualizarEntidade(candidatura, request);
        return mapper.toResponse(repository.save(candidatura));
    }

    public void excluir(Long id) {
        repository.delete(obterEntidade(id));
    }

    private Candidatura obterEntidade(Long id) {
        return repository.findById(id).orElseThrow(() -> new CandidaturaNotFoundException(id));
    }
}
