package dev.fujioka.brunoarruda.service;
import dev.fujioka.brunoarruda.model.Aluno;
import dev.fujioka.brunoarruda.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    //,,,,

    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno consultarPorId(int id){
        return alunoRepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        alunoRepository.deleteById(id);
    }

    public Aluno alterar(Aluno aluno){
        if(Objects.isNull(aluno.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return alunoRepository.save(aluno);
    }

    public List<Aluno> buscarAlunoLike(String nome){
        return alunoRepository.buscarAlunoPorNomeLike(nome);
    }


}
