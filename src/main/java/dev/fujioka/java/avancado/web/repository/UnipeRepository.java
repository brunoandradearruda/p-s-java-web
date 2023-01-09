package dev.fujioka.java.avancado.web.repository;
import dev.fujioka.java.avancado.web.model.Unipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UnipeRepository extends JpaRepository<Unipe, Integer> {

    @Query("select a from Unipe a order by a.curso ASC")
    public List<Unipe> listarOrdernadoPorCurso();
    public List<Unipe> findAllByOrderByCursoAsc();

    @Query("select a from Unipe a where a.curso like %:curso% ")
    public List<Unipe> buscarUnipePorCursoLike(@Param("curso") String curso);
    public Unipe findByCurso(String curso);

    public Unipe findByvalorMensalidadeAndCurso(String valorMensalidade, String curso);

}