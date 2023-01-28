package dev.fujioka.java.avancado.web.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String matricula;

}
