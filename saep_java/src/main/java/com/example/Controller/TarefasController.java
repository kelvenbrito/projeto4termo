package com.example.Controller;

import com.example.Model.Tarefas;
import com.example.Repository.TarefasRepository;
import com.example.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TarefasController {

    @Autowired
    private TarefasRepository tarefasRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping("/")
    public String index() {
        return "redirect:/gerenciamento-tarefas"; // Redireciona para a tela de gerenciamento de tarefas
    }

    @GetMapping("/gerenciamento-tarefas")
    public String gerenciamentoTarefas(Model model) {
        List<Tarefas> tarefas = tarefasRepository.findAll();
        model.addAttribute("tarefas", tarefas);
        return "gerenciamento-tarefas"; // Nome do template Thymeleaf
    }

    @GetMapping("/editar-tarefa/{id}")
    public String editarTarefa(@PathVariable Long id, Model model) {
        Tarefas tarefa = tarefasRepository.findById(id).orElse(null);
        model.addAttribute("tarefa", tarefa);
        model.addAttribute("usuarios", usuariosRepository.findAll());
        return "cadastro-tarefa"; // Redireciona para o formulário de cadastro
    }

    @PostMapping("/atualizar-tarefa")
    public String atualizarTarefa(@ModelAttribute Tarefas tarefa) {
        tarefasRepository.save(tarefa);
        return "redirect:/gerenciamento-tarefas";
    }

    @PostMapping("/excluir-tarefa/{id}")
    public String excluirTarefa(@PathVariable Long id) {
        tarefasRepository.deleteById(id);
        return "redirect:/gerenciamento-tarefas";
    }

    @PostMapping("/atualizar-status/{id}")
    public String atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        Tarefas tarefa = tarefasRepository.findById(id).orElse(null);
        if (tarefa != null) {
            tarefa.setStatus(status);
            tarefasRepository.save(tarefa);
        }
        return "redirect:/gerenciamento-tarefas";
    }
}
