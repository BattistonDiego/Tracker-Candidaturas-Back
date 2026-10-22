package com.diego.tracker.candidatura.mapper;

import com.diego.tracker.candidatura.dto.CandidaturaRequest;
import com.diego.tracker.candidatura.dto.CandidaturaResponse;
import com.diego.tracker.candidatura.entity.Candidatura;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CandidaturaMapper {

    public Candidatura toEntity(CandidaturaRequest request) {
        Candidatura candidatura = new Candidatura();
        atualizarEntidade(candidatura, request);
        return candidatura;
    }

    public void atualizarEntidade(Candidatura candidatura, CandidaturaRequest request) {
        candidatura.setEmpresa(request.empresa().trim());
        candidatura.setCargo(request.cargo().trim());
        candidatura.setLinkVaga(request.linkVaga());
        candidatura.setDataCandidatura(request.dataCandidatura());
        candidatura.setStatus(request.status());
        candidatura.setTecnologias(new ArrayList<>(request.tecnologias()));
        candidatura.setPlataforma(request.plataforma());
        candidatura.setContato(request.contato());
        candidatura.setObservacao(request.observacao());
    }

    public CandidaturaResponse toResponse(Candidatura candidatura) {
        return new CandidaturaResponse(
                candidatura.getId(), candidatura.getEmpresa(), candidatura.getCargo(), candidatura.getLinkVaga(),
                candidatura.getDataCandidatura(), candidatura.getStatus(), List.copyOf(candidatura.getTecnologias()),
                candidatura.getPlataforma(), candidatura.getContato(), candidatura.getObservacao());
    }
}
