package com.diego.tracker.candidatura.exception;

public class CandidaturaNotFoundException extends RuntimeException {
    public CandidaturaNotFoundException(Long id) {
        super("Candidatura com id " + id + " não foi encontrada.");
    }
}
