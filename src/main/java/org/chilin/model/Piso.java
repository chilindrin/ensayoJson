package org.chilin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class Piso {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nombre;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Banio> banios;

}
