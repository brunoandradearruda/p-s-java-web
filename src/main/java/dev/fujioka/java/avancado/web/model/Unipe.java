package dev.fujioka.java.avancado.web.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
@Getter
@Setter
@Entity
public class Unipe {

    @Id
    @GeneratedValue
    private Integer id;

    private String curso;

    private double valorMensalidade;



}
