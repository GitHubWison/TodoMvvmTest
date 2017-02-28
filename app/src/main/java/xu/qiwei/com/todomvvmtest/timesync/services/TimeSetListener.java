package xu.qiwei.com.todomvvmtest.timesync.services;

import xu.qiwei.com.todomvvmtest.timesync.model.TimeModel;

/**
 * Created by xuqiwei on 17-2-28.
 */

public interface TimeSetListener {
    void onTimeSyncSuccess(TimeModel timeModel);
}
