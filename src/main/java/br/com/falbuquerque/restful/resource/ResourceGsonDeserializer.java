package br.com.falbuquerque.restful.resource;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Deserializes a resource.
 * 
 * @author Felipe Albuquerque
 */
public class ResourceGsonDeserializer implements JsonDeserializer<Resource<? extends Item>> {

    @Override
    public Resource<? extends Item> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        final Resource<? extends Item> resource = new Gson().fromJson(json, typeOfT);

        if (resource.getItems() != null) {
            resource.getItems().forEach(item -> item.setResource(resource));
        }

        if (resource.getItem() != null) {
            resource.getItem().setResource(resource);
        }

        return resource;
    }

}
