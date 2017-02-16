package xu.qiwei.com.todomvvmtest.utils;

import android.content.Context;

/**
 * Created by xuqiwei on 17-2-16.
 */

public class MeasureUtils {
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
