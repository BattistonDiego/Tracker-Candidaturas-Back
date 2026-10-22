package com.diego.tracker.candidatura.dto;

import com.diego.tracker.candidatura.enums.Plataforma;
import com.diego.tracker.candidatura.enums.StatusCandidatura;
import java.time.LocalDate;
import java.util.List;

/** Representação pública de uma candidatura. */
public record CandidaturaResponse(
        Long id,
        String empresa,
        String cargo,
        String linkVaga,
        LocalDate dataCandidatura,
        StatusCandidatura status,
        List<String> tecnologias,
        Plataforma plataforma,
        String contato,
        String observacao) {
}
