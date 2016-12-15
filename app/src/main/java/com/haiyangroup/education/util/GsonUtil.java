package com.haiyangroup.education.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GsonUtil {


    public static <T> T fromJson(String json, Class<T> clazz) {
        Gson gson = new Gson();
        T t = gson.fromJson(json, clazz);
        return t;
    }


    public static String toJson(Object object) {
        Gson gson = new Gson();
        String t = gson.toJson(object);
        return t;
    }


    public static Map<String, JsonElement> fromJson2MapJson(String json) {
        Gson gson = new Gson();
        Map<String, JsonElement> map = gson.fromJson(json,
                new TypeToken<Map<String, JsonElement>>() {
                }.getType());
        return map;
    }

    public static <T> ArrayList<T> fromJson2List(String json, Class<T> clazz) {
        Gson gson = new Gson();
        ArrayList<JsonObject> list = null;
        list = gson.fromJson(json, new TypeToken<List<JsonObject>>() {
        }.getType());
        ArrayList<T> resultList = new ArrayList<T>();
        for (JsonObject t : list) {
            resultList.add(new Gson().fromJson(t, clazz));
        }
        return resultList;
    }


}
