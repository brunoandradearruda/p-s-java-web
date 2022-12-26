package dev.fujioka.java.avancado.web.resource;
import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

    @Autowired
    private ProfessorService ProfessorService;

    @PostMapping
    public ResponseEntity<Professor> salvar(@RequestBody Professor professor){
        return ResponseEntity.ok(ProfessorService.salvar(professor));
    }


    @GetMapping
    public ResponseEntity<List<Professor>> getProfessor(){
        return ResponseEntity.ok(ProfessorService.listarProfessor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> consultaPorId(@PathVariable int id){
        return ResponseEntity.ok(ProfessorService.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Professor> deletePorId(@PathVariable int id){
        ProfessorService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Professor> alterar(@RequestBody Professor professor){
        return ResponseEntity.ok(ProfessorService.alterar(professor));
    }


    @GetMapping("/like/{nome}")
    public ResponseEntity<List<Professor>> listarPorLike(@PathVariable String nome){
        return ResponseEntity.ok(ProfessorService.buscarProfessorLike(nome));
    }


}
