package dev.fujioka.java.avancado.web.resource;
import dev.fujioka.java.avancado.web.model.Unipe;
import dev.fujioka.java.avancado.web.service.UnipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/unipe")
public class UnipeResource {

    @Autowired
    private UnipeService unipeService;

    @PostMapping
    public ResponseEntity<Unipe> salvar(@RequestBody Unipe curso){
        return ResponseEntity.ok(unipeService.salvar(curso));
    }


    @GetMapping
    public ResponseEntity<List<Unipe>> getUnipe(){
        return ResponseEntity.ok(unipeService.listarCurso());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unipe> consultaPorId(@PathVariable int id){
        return ResponseEntity.ok(unipeService.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Unipe> deletePorId(@PathVariable int id){
        unipeService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Unipe> alterar(@RequestBody Unipe curso){
        return ResponseEntity.ok(unipeService.alterar(curso));
    }


    @GetMapping("/like/{nome}")
    public ResponseEntity<List<Unipe>> listarPorLike(@PathVariable String curso){
        return ResponseEntity.ok(unipeService.buscarUnipeLike(curso));
    }


}