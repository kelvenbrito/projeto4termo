package com.example.models;

import java.time.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Manutencao {
    private String id;
    private long maquinaID;
    private LocalDate data;
    private String tipo;
    private String pecasTrocadas;
    private long tempoDeParada;
    private String tecnicoID;
    private String observacoes;
}
