package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Curso {
    // Atributos
    private String nomeCurso;
    private List<Aluno> alunos;
    private Professor professor;

    // Construtor
    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        alunos = new ArrayList<>();
    }

    // Método adicionar professor
    public void addProf(Professor professor) {
        this.professor = professor;
    }

    // Método adicionar aluno
    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    // Método info curso
    public void infoCurso() {
        System.out.println("Curso: " + nomeCurso);
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Alunos matriculados: ");
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getNome() + " RA: " + aluno.getMatricula());
        }
    }

    // Método lançar nota
    public void atribuirNota() {
        if (alunos.size()==0) {
            
        }else{
        for (Aluno aluno : alunos) {// Percorrer arraylist
           double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota do "+aluno.getNome()+":"));
           aluno.setNota(nota);
            }

        }
        System.out.println("Aluno não encontrado!");

    }

    //Método Exibir Resultado Final
    public void exibirResultadoFinal(){
        for (Aluno aluno : alunos) {
            System.out.println(aluno.exibirInfo());
            System.out.println(aluno.avaliarDesempenho());
        }
    }

}
