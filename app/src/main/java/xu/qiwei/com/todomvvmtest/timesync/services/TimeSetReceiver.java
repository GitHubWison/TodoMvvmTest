package xu.qiwei.com.todomvvmtest.timesync.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import xu.qiwei.com.todomvvmtest.timesync.model.TimeModel;

/**
 * Created by xuqiwei on 17-2-28.
 */

public class TimeSetReceiver extends BroadcastReceiver {

    private TimeSetListener listener;

    public TimeSetReceiver(TimeSetListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        TimeModel timeModel = (TimeModel)intent.getParcelableExtra("SyncTime");
        if (listener!=null) {
            listener.onTimeSyncSuccess(timeModel);
        }
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            Log.e("StackTraceElement==",elements[i].getMethodName());
        }
        Log.e("timeModel==",timeModel.getTime());
    }
}
