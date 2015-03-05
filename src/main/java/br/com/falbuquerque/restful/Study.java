package br.com.falbuquerque.restful;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import br.com.falbuquerque.restful.resource.Resource;
import br.com.falbuquerque.restful.resource.ResourceGsonDeserializer;
import br.com.falbuquerque.restful.resource.user.UserItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Study {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        final String referenceJson = "{\"baseUrl\":\"https://www.baseurl.com\",\"rel\":\"/users\",\"items\":[{\"id\": 1,\"name\": \"Felipe\",\"rel\": \"/users/1\",\"links\":{\"history\": \"/history\",\"products\": \"/products\"}},{\"id\": 2,\"name\": \"Fulano\",\"rel\": \"/users/2\",\"links\":{\"history\": \"/history\",\"products\": \"/products\"}}],\"links\": {\"a\": \"/a\",\"b\": \"/b\"}}";
        final Type type = new TypeToken<Resource<UserItem>>() {
        }.getType();

        final Gson gson = new GsonBuilder().registerTypeAdapter(type, new ResourceGsonDeserializer()).create();
        final Resource<UserItem> resource = gson.fromJson(referenceJson, type);
        final UserItem userItem = resource.getItems().iterator().next();

        System.out.println(userItem.getURL(UserItem.Links.HISTORY.key()));
        System.out.println(userItem.getURL(UserItem.Links.PRODUCTS.key()));
    }

}
