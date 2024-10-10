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

public class Falha {
    private String id;
    private String maquinaID;
    private LocalDate data;
    private String problema;
    private String prioridade;
    private String operador;
   
}
