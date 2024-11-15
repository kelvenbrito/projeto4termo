package com.example.Model;

import java.io.Serializable;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.*;

@Entity
@Setter
@Getter
public class Usuarios implements Serializable {
    // atributos
    @Id
    private String email;
    private String nome;
    
  
   

   

}