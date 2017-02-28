package xu.qiwei.com.todomvvmtest.timesync.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by xuqiwei on 17-2-28.
 */

public class TimeSyncBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        定时操作，开启定时服务
        context.startService(new Intent(context,TimeSyncService.class));
    }
}
