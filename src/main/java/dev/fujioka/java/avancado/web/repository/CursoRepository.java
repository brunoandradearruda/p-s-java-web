package dev.fujioka.java.avancado.web.repository;
import dev.fujioka.java.avancado.web.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    @Query("select a from Aluno a order by a.nome ASC")
    public List<Curso> listarOrdernadoPorNome();
    public List<Curso> findAllByOrderByNomeAsc();

    @Query("select a from Curso a where a.nome like %:nome% ")
    public List<Curso> buscarAlunoPorNomeLike(@Param("nome") String nome);
    public Curso findByNome(String nome);

    public Curso findByAreaConhecimentoAndNome(String areaConhecimento, String nome);

}