package xu.qiwei.com.todomvvmtest.timesync;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.ViewHolder;
import xu.qiwei.com.todomvvmtest.timesync.model.TimeModel;
import xu.qiwei.com.todomvvmtest.timesync.services.TimeSetListener;
import xu.qiwei.com.todomvvmtest.timesync.services.TimeSetReceiver;
import xu.qiwei.com.todomvvmtest.timesync.services.TimeSyncService;

public class TimeSyncActivity extends AppCompatActivity implements TimeSyncView,TimeSetListener {
    private static final String TIMESYNCVIEWMODEL = "TimeSyncViewModel";
    private TimeSyncViewModel timeSyncViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_sync);
        TimeSyncFragment timeSyncFragment = findOrCreateFragment();
        timeSyncViewModel = findOrCreateViewModel();
        timeSyncFragment.setViewModel(timeSyncViewModel);
        registerTimeShowBroadcast();

    }

    private void registerTimeShowBroadcast() {
        IntentFilter intentFilter = new IntentFilter("com.xu.test.timesysnc");
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        TimeSetReceiver timeSetReceiver = new TimeSetReceiver(this);
        localBroadcastManager.registerReceiver(timeSetReceiver, intentFilter);
    }

    @SuppressWarnings("unchecked")
    private TimeSyncViewModel findOrCreateViewModel() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ViewHolder<TimeSyncViewModel> viewModelViewHolder = (ViewHolder<TimeSyncViewModel>) fragmentManager.findFragmentByTag(TIMESYNCVIEWMODEL);
        if (viewModelViewHolder != null && viewModelViewHolder.getViewModel() != null) {
            return viewModelViewHolder.getViewModel();
        } else {
            TimeSyncViewModel timeSyncViewModel = new TimeSyncViewModel(this);
            viewModelViewHolder = ViewHolder.createViewModelContiner(timeSyncViewModel);
            ActivityUtils.addFragmentToActivity(fragmentManager, viewModelViewHolder, TIMESYNCVIEWMODEL);
            return timeSyncViewModel;
        }
    }

    private TimeSyncFragment findOrCreateFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        TimeSyncFragment fragment = (TimeSyncFragment) fragmentManager.findFragmentById(R.id.timesyncmain_fragmelayout);
        if (fragment == null) {
            fragment = TimeSyncFragment.newInstance();
            ActivityUtils.addFragmentToActivity(fragmentManager, R.id.timesyncmain_fragmelayout, fragment);
        }
        return fragment;
    }

    @Override
    public void startService() {
        startService(new Intent(this, TimeSyncService.class));
    }

    @Override
    public void stopService() {

    }

    @Override
    public void adjustTime() {
    }

    @Override
    public void onTimeSyncSuccess(TimeModel timeModel) {
        timeSyncViewModel.timeShow.set(timeModel.getTime());
    }
}
