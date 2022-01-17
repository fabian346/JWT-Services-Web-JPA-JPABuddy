package com.kardex.api.commons.util;


import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class GsonUtils {

    public static String serialize(Object src){
        Gson gson = new Gson();
        return gson.toJson(src);
    }

    public static <T> T toObject(String json, Class<T> dClass){
        Gson gson = new Gson();
        return gson.fromJson(json, dClass);
    }

    public static <T> T toObject(Object src, Class<T> dClass){
        Gson gson = new Gson();
        String sJson = gson.toJson(src);
        return gson.fromJson((JsonElement) src, dClass);
    }
}
