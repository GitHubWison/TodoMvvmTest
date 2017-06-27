package xu.qiwei.com.todomvvmtest;

import android.app.Application;
import android.content.Context;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
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
        SpeechUtility.createUtility(context, SpeechConstant.APPID +"=5940c354");
//               SpeechUtility.createUtility(this, SpeechConstant.APPID +"=582a9719");
    }
    public static Context getContext() {
        return context;
    }
}
