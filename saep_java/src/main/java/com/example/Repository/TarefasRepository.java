package com.example.Repository;

import com.example.Model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
    // Métodos adicionais podem ser definidos aqui, se necessário
}
