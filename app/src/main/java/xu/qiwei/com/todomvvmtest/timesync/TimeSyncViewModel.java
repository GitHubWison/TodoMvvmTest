package xu.qiwei.com.todomvvmtest.timesync;

import android.databinding.ObservableField;

/**
 * Created by xuqiwei on 17-2-28.
 */

public class TimeSyncViewModel {
    private TimeSyncView mView;
    public ObservableField<String> timeShow = new ObservableField<>();

    public TimeSyncViewModel(TimeSyncView view) {
        this.mView = view;
    }

    public void startService() {
        mView.startService();
    }

    public void stopService() {
        mView.stopService();
    }

    public void adjustTime() {
        mView.adjustTime();
    }
}
