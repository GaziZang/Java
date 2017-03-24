package gz.springMVC.helper;

import com.google.gson.Gson;

/**
 * Created by gazizang on 17/3/7.
 */
public class JsonHelper {
    private static Gson gson = new Gson();

    public static String objectToJson(Object object){
        return gson.toJson(object);
    }

    public static <T> T jsonToObject(String json, Class<T> classOfT){
        return gson.fromJson(json, classOfT);
    }
}
