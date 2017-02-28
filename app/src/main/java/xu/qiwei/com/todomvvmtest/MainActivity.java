package xu.qiwei.com.todomvvmtest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.databinding.ActivityMainBinding;
import xu.qiwei.com.todomvvmtest.databindingtest.TwoBindTestActivity;
import xu.qiwei.com.todomvvmtest.tasks.TasksActivity;
import xu.qiwei.com.todomvvmtest.threadpooltest.ThreadTestActivity;
import xu.qiwei.com.todomvvmtest.timesync.TimeSyncActivity;

public class MainActivity extends AppCompatActivity implements TasksNavigator{
    private ActivityMainBinding binding;
    private static final String MAIN_VIEWMODEL_TAG = "MAIN_VIEWMODEL_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setViewmodel(findOrCreateViewModel());

    }

    private MainActivityViewModel findOrCreateViewModel() {
        @SuppressWarnings("unchecked")
        ViewHolder<MainActivityViewModel> viewModelViewHolder = (ViewHolder<MainActivityViewModel>)getSupportFragmentManager().findFragmentByTag(MAIN_VIEWMODEL_TAG);
        if (viewModelViewHolder!=null&&viewModelViewHolder.getViewModel()!=null) {
            return viewModelViewHolder.getViewModel();

        }else
        {
            MainActivityViewModel viewModel = new MainActivityViewModel(this);
           ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                   ViewHolder.createViewModelContiner(viewModel),
                   MAIN_VIEWMODEL_TAG);
            return viewModel;
        }
    }

    @Override
    public void toTaskListActivity() {
        startActivity(new Intent(this, TasksActivity.class));
    }

    @Override
    public void toBindingTest() {
        startActivity(new Intent(this, TwoBindTestActivity.class));
    }

    @Override
    public void toTimeSync() {
        startActivity(new Intent(this, TimeSyncActivity.class));
    }

    @Override
    public void toThreadTest() {
        startActivity(new Intent(this, ThreadTestActivity.class));
    }

}
