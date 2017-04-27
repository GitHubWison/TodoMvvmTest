package xu.qiwei.com.todomvvmtest;

import android.app.Application;
import android.content.Context;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by xuqiwei on 17-3-20.
 */

public class DemoApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
        context = this;
    }
    public static Context getContext() {
        return context;
    }
}
