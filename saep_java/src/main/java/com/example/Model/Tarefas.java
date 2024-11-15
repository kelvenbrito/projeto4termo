package com.example.Model;

import java.io.Serializable;

import jakarta.annotation.Priority;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class Tarefas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String descricao;
    private String setor;

    @Enumerated(EnumType.STRING)
    private Priority prioridade;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    private String status; // Atributo para o status da tarefa
}
