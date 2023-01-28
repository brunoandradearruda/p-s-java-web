package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.CursoDTO;
import dev.fujioka.java.avancado.web.dto.ProfessorDTO;
import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository ProfessorRepository;
    @Autowired
    private JmsTemplate jmsTemplate;

    public ProfessorDTO salvar(Professor professor) {
        professor = ProfessorRepository.save(professor);

       jmsTemplate.convertAndSend("Professor", professor);

        return ProfessorDTO.builder()
                .nome(professor.getNome())
                .disciplina(professor.getDisciplina())
                .build();
    }

    public List<Professor> listarProfessor() {
        return ProfessorRepository.findAll();
    }

    public Professor consultarPorId(int id) {
        return ProfessorRepository.findById(id).orElseThrow();
    }

    public void excluir(int id) {
        ProfessorRepository.deleteById(id);
    }

    public Professor alterar(Professor professor) {
        if (Objects.isNull(professor.getId())) {
            throw new RuntimeException("ID não preenchido");
        }
        return ProfessorRepository.save(professor);
    }

    public List<Professor> buscarProfessorLike(String nome) {
        return ProfessorRepository.buscarProfessorPorNomeLike(nome);
    }


}
