package org.chilin.gsonbuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.chilin.model.Casa;

public class GoogleSerializer {

    public String serializeCasaWithGoogle(Casa casa){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(String.class, new StringPeluncher())
                .create();
        return gson.toJson(casa);
    }

}
