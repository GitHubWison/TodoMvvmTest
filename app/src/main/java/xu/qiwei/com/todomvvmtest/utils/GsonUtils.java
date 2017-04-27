package xu.qiwei.com.todomvvmtest.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 获取GSON实例
 *
 * @author Administrator
 */
public class GsonUtils {

    private static GsonUtils instance;

    private Gson gson;

    private GsonUtils() {

    }

    public static GsonUtils getInstance() {
        if (instance == null) {
            synchronized (GsonUtils.class) {
                if (instance == null) {
                    instance = new GsonUtils();
                }
            }
        }
        return instance;
    }

    public Gson get() {
        if (gson == null) {
            gson = new GsonBuilder().serializeNulls().create();
        }
        return gson;
    }

}
