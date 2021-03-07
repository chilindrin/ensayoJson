package org.chilin.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.chilin.model.Casa;

public class AndresitoSerializer {

    private ObjectMapper objectMapper;

    public AndresitoSerializer(){
        this.objectMapper = new ObjectMapper();
    }

    public String serializeCasa(Casa casa) throws JsonProcessingException {
        return objectMapper.writeValueAsString(casa);
    }

}
