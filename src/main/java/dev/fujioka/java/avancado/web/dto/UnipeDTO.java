package dev.fujioka.java.avancado.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class UnipeDTO {

    String curso;
    Double valorMensalidade;
}
