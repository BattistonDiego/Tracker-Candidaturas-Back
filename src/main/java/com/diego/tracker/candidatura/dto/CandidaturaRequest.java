package com.diego.tracker.candidatura.dto;

import com.diego.tracker.candidatura.enums.Plataforma;
import com.diego.tracker.candidatura.enums.StatusCandidatura;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record CandidaturaRequest(
        @NotBlank(message = "Informe o nome da empresa.") String empresa,
        @NotBlank(message = "Informe o cargo da vaga.") String cargo,
        String linkVaga,
        @NotNull(message = "Informe a data da candidatura.") LocalDate dataCandidatura,
        @NotNull(message = "Informe o status da candidatura.") StatusCandidatura status,
        @NotNull(message = "A lista de tecnologias é obrigatória.") List<String> tecnologias,
        @NotNull(message = "Informe a plataforma da vaga.") Plataforma plataforma,
        String contato,
        String observacao) {
}
