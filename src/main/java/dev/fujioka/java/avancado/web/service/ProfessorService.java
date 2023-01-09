package dev.fujioka.java.avancado.web.service;
import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository ProfessorRepository;

    public Professor salvar(Professor professor){
        return ProfessorRepository.save(professor);
    }

    public List<Professor> listarProfessor(){
        return ProfessorRepository.findAll();
    }

    public Professor consultarPorId(int id){
        return ProfessorRepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        ProfessorRepository.deleteById(id);
    }

    public Professor alterar(Professor professor){
        if(Objects.isNull(professor.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return ProfessorRepository.save(professor);
    }

    public List<Professor> buscarProfessorLike(String nome){
        return ProfessorRepository.buscarProfessorPorNomeLike(nome);
    }


}
