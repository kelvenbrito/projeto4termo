package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeituraNotasAlunos {
    private List<Aluno> alunos;

    // Contrutor
    public LeituraNotasAlunos() {
        alunos = new ArrayList<>();
    }

    // Método Leitura
    public void leituraFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("notas.txt"))) {
            String linha = br.readLine();
            do {
                String[] aluno = linha.split(",");
                Aluno alunoNota = new Aluno(aluno[0],
                        Double.parseDouble(aluno[1]),
                        Double.parseDouble(aluno[2]),
                        Double.parseDouble(aluno[3]));
                alunos.add(alunoNota);
                linha = br.readLine();
            } while (linha != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(alunos);
    }

    //Metodo aluno com maior nota
    public void alunoMaiorNota(){
        String nome="";
        double maiorNota = 0;
        for (Aluno aluno : alunos) {
            if (aluno.maiorNotaAluno()>maiorNota) {
                maiorNota = aluno.maiorNotaAluno();
                nome = aluno.getNome();
            }
        }
        System.out.println("O Aluno com maior nota é "+nome+" com nota = "+maiorNota);
    }

       //Metodo aluno com maior nota
       public void alunoMenorNota(){
        String nome="";
        double menorNota = 10;
        for (Aluno aluno : alunos) {
            if (aluno.menorNotaAluno()<menorNota) {
                menorNota = aluno.menorNotaAluno();
                nome = aluno.getNome();
            }
        }
        System.out.println("O Aluno com menor nota é "+nome+" com nota = "+menorNota);
    }

    //calculo da Média
    public void mediaTurma(){
        double mediaNotasTurma = 0;
        for (Aluno aluno : alunos) {
            mediaNotasTurma+=aluno.media();
        }
        mediaNotasTurma/=alunos.size();
        System.out.println("A média da turma é "+mediaNotasTurma);
    }

}
