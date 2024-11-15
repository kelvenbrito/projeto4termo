package com.example.Controller;

import com.example.Model.Usuarios;
import com.example.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Criar um novo usuário
    @PostMapping
    public ResponseEntity<Usuarios> createUsuario(@RequestBody Usuarios usuario) {
        Usuarios savedUsuario = usuariosRepository.save(usuario);
        return ResponseEntity.ok(savedUsuario);
    }

    // Listar todos os usuários
    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    // Obter um usuário por e-mail
    @GetMapping("/{email}")
    public ResponseEntity<Usuarios> getUsuarioByEmail(@PathVariable String email) {
        Optional<Usuarios> usuario = usuariosRepository.findById(email);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um usuário
    @PutMapping("/{email}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable String email, @RequestBody Usuarios usuarioDetails) {
        Optional<Usuarios> optionalUsuario = usuariosRepository.findById(email);
        if (optionalUsuario.isPresent()) {
            Usuarios usuario = optionalUsuario.get();
            usuario.setNome(usuarioDetails.getNome());
            // Atualize outros campos, se necessário
            Usuarios updatedUsuario = usuariosRepository.save(usuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar um usuário
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String email) {
        if (usuariosRepository.existsById(email)) {
            usuariosRepository.deleteById(email);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
