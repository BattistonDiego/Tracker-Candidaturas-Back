package com.diego.tracker.candidatura.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Origem da vaga, incluindo os rótulos apresentados pelo frontend. */
public enum Plataforma {
    LINKEDIN("LINKEDIN"),
    GUPY("GUPY"),
    CATHO("CATHO"),
    INFOJOBS("INFOJOBS"),
    INDEED("INDEED"),
    OUTRO("OUTRO"),
    SITE_DA_EMPRESA("Site da empresa"),
    INDICACAO("Indicação");

    private final String valor;

    Plataforma(String valor) {
        this.valor = valor;
    }

    @JsonValue
    public String getValor() {
        return valor;
    }

    @JsonCreator
    public static Plataforma fromValor(String valor) {
        for (Plataforma plataforma : values()) {
            if (plataforma.valor.equalsIgnoreCase(valor)) {
                return plataforma;
            }
        }
        throw new IllegalArgumentException("Plataforma inválida: " + valor);
    }
}
