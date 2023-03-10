package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.ProfessorDTO;
import dev.fujioka.java.avancado.web.dto.UnipeDTO;
import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.model.Unipe;
import dev.fujioka.java.avancado.web.repository.UnipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UnipeService {

    @Autowired
    private UnipeRepository unipeRepository;

    @Autowired
    private JmsTemplate jmsTemplate;


    public UnipeDTO salvar(Unipe unipe) {
        unipe = unipeRepository.save(unipe);

        jmsTemplate.convertAndSend("Unipe", unipe);

        return UnipeDTO.builder()
                .curso(unipe.getCurso())
                .valorMensalidade(unipe.getValorMensalidade())
                .build();
    }

    public List<Unipe> listarCurso() {
        return unipeRepository.findAll();
    }

    public Unipe consultarPorId(int id) {
        return unipeRepository.findById(id).orElseThrow();
    }

    public void excluir(int id) {
        unipeRepository.deleteById(id);
    }

    public Unipe alterar(Unipe curso) {
        if (Objects.isNull(curso.getId())) {
            throw new RuntimeException("ID não preenchido");
        }
        return unipeRepository.save(curso);
    }

    public List<Unipe> buscarUnipeLike(String curso) {
        return unipeRepository.buscarUnipePorCursoLike(curso);
    }


}