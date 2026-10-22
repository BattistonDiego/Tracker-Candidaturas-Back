package com.diego.tracker.candidatura.repository;

import com.diego.tracker.candidatura.entity.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {
}
