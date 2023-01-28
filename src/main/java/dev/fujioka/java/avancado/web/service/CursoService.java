package dev.fujioka.java.avancado.web.service;
import dev.fujioka.java.avancado.web.dto.AlunoDTO;
import dev.fujioka.java.avancado.web.dto.CursoDTO;
import dev.fujioka.java.avancado.web.model.Curso;
import dev.fujioka.java.avancado.web.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursorepository;
    @Autowired
    private JmsTemplate jmsTemplate;

    public CursoDTO salvar(Curso curso){
    curso = cursorepository.save(curso);
        jmsTemplate.convertAndSend("Curso", curso );

        return CursoDTO.builder()
                .nome(curso.getNome())
                .areConhecimento(curso.getAreaConhecimento())
                .build();
    }


    public List<Curso> listarCurso(){
        return cursorepository.findAll();
    }

    public Curso consultarPorId(int id){
        return cursorepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        cursorepository.deleteById(id);
    }

    public Curso alterar(Curso curso){
        if(Objects.isNull(curso.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return cursorepository.save(curso);
    }

    public List<Curso> buscarCursoLike(String nome){
        return cursorepository.buscarAlunoPorNomeLike(nome);
    }


}
