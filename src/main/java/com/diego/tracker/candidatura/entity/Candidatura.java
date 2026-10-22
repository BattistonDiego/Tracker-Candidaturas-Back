package com.diego.tracker.candidatura.entity;

import com.diego.tracker.candidatura.enums.Plataforma;
import com.diego.tracker.candidatura.enums.StatusCandidatura;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "candidaturas")
@Getter
@Setter
@NoArgsConstructor
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String empresa;

    @Column(nullable = false, length = 150)
    private String cargo;

    @Column(name = "link_vaga", length = 2048)
    private String linkVaga;

    @Column(name = "data_candidatura", nullable = false)
    private LocalDate dataCandidatura;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusCandidatura status;

    @ElementCollection
    @CollectionTable(name = "candidatura_tecnologias", joinColumns = @JoinColumn(name = "candidatura_id"))
    @Column(name = "tecnologia", nullable = false, length = 100)
    private List<String> tecnologias = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Plataforma plataforma;

    @Column(length = 200)
    private String contato;

    @Column(columnDefinition = "TEXT")
    private String observacao;
}
