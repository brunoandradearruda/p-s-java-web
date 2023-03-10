package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.AlunoDTO;
import dev.fujioka.java.avancado.web.model.Aluno;
import dev.fujioka.java.avancado.web.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.simp.user.DestinationUserNameProvider;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;
import java.util.List;
import java.util.Objects;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    public AlunoDTO salvar(Aluno aluno) {

        aluno = alunoRepository.save(aluno);
        jmsTemplate.convertAndSend("Aluno", aluno);

        return AlunoDTO.builder()
                .nome(aluno.getNome())
                .matricula(aluno.getMatricula())
                .build();
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno consultarPorId(int id) {
        return alunoRepository.findById(id).orElseThrow();
    }

    public void excluir(int id) {
        alunoRepository.deleteById(id);
    }

    public Aluno alterar(Aluno aluno) {
        if (Objects.isNull(aluno.getId())) {
            throw new RuntimeException("ID não preenchido");
        }
        return alunoRepository.save(aluno);
    }

    public List<Aluno> buscarAlunoLike(String nome) {
        return alunoRepository.buscarAlunoPorNomeLike(nome);
    }


}
