package org.chilin.gsonbuilder;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

public class StringPeluncher implements JsonSerializer<String> {
    @Override
    public JsonElement serialize(String s, Type type, JsonSerializationContext jsonSerializationContext) {
        if (StringUtils.isBlank(s)){
            return null;
        }
        return new JsonPrimitive(s);
    }
}
