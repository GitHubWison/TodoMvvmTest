package xu.qiwei.com.todomvvmtest;

import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.activityloadmods.OneActivity;
import xu.qiwei.com.todomvvmtest.autolayouttest.views.AutoLayoutTestActivity;
import xu.qiwei.com.todomvvmtest.blueprint.views.PrintMainActivity;
import xu.qiwei.com.todomvvmtest.blueprintv2.BluePrinterV2Activity;
import xu.qiwei.com.todomvvmtest.commontest.TestActivity;
import xu.qiwei.com.todomvvmtest.customkeyboard.KeyBoareTestV2Activity;
import xu.qiwei.com.todomvvmtest.databinding.ActivityMainBinding;
import xu.qiwei.com.todomvvmtest.databindingtest.TwoBindTestActivity;
import xu.qiwei.com.todomvvmtest.fingerprint.FingetTestActivity;
import xu.qiwei.com.todomvvmtest.flowlayout.view.FlowLayoutTestActivity;
import xu.qiwei.com.todomvvmtest.fragmentdialogtest.viewmodel.TestDialogViewModel;
import xu.qiwei.com.todomvvmtest.fragmentdialogtest.views.TestFragmentDialog;
import xu.qiwei.com.todomvvmtest.iflytest.views.IflyTestActivity;
import xu.qiwei.com.todomvvmtest.mutiprocess.ProcessActivity;
import xu.qiwei.com.todomvvmtest.recyclelisttest.RecycleListActivity;
import xu.qiwei.com.todomvvmtest.signtest.SignTestActivity;
import xu.qiwei.com.todomvvmtest.takephoto.views.TakePhotoActivity;
import xu.qiwei.com.todomvvmtest.tasks.TasksActivity;
import xu.qiwei.com.todomvvmtest.threadpooltest.ThreadTestActivity;
import xu.qiwei.com.todomvvmtest.timesync.TimeSyncActivity;
import xu.qiwei.com.todomvvmtest.vlayouttest.VLayoutTestActivity;
import xu.qiwei.com.todomvvmtest.zxingtest.ZXingTestActivity;

public class MainActivity extends AppCompatActivity implements TasksNavigator{
    private ActivityMainBinding binding;
    private static final String MAIN_VIEWMODEL_TAG = "MAIN_VIEWMODEL_TAG";
    private static final String TESTDIALOGVIEWMODEL = "TestDialogViewModel";
    private TestFragmentDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setViewmodel(findOrCreateViewModel());

         dialog = TestFragmentDialog.newInstance();
        TestDialogViewModel testDialogViewModel = findOrCreateTestDialogVM();
        dialog.setViewModel(testDialogViewModel);

    }

    private TestDialogViewModel findOrCreateTestDialogVM() {
        ViewHolder<TestDialogViewModel> viewModelViewHolder = (ViewHolder<TestDialogViewModel>)getSupportFragmentManager().findFragmentByTag(TESTDIALOGVIEWMODEL);
        if (viewModelViewHolder!=null&&viewModelViewHolder.getViewModel()!=null) {
            return viewModelViewHolder.getViewModel();

        }else
        {
            TestDialogViewModel viewModel = new TestDialogViewModel(this);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    ViewHolder.createViewModelContiner(viewModel),
                    TESTDIALOGVIEWMODEL);
            return viewModel;
        }

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

    @Override
    public void toCustomKeyboard() {
        startActivity(new Intent(this, KeyBoareTestV2Activity.class));
    }

    @Override
    public void toZXing() {
        startActivity(new Intent(this, ZXingTestActivity.class));

    }

    @Override
    public void toSignTest() {
        startActivity(new Intent(this, SignTestActivity.class));
    }

    @Override
    public void toFingerTest() {
        startActivity(new Intent(this, FingetTestActivity.class));
    }

    @Override
    public void toFlowLayoutTest() {
        startActivity(new Intent(this, FlowLayoutTestActivity.class));
    }

    @Override
    public void showDialog() {
        dialog.show(getSupportFragmentManager(),"");
    }

    @Override
    public void showToast(String maintest) {
        Toast.makeText(this, maintest+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toPrintActivity() {
        startActivity(new Intent(this, PrintMainActivity.class));
    }

    @Override
    public void toAutoLayoutActivity() {
        startActivity(new Intent(this, AutoLayoutTestActivity.class));
    }

    @Override
    public void toBluePrintV2Activity() {
        startActivity(new Intent(this, BluePrinterV2Activity.class));
    }

    @Override
    public void toLoadActivity() {
        startActivity(new Intent(this, OneActivity.class));
    }

    @Override
    public void toShowTest() {
        startActivity(new Intent(this, TestActivity.class));
    }

    @Override
    public void tofragmentless() {
        startActivity(new Intent(this,RecycleListActivity.class));
    }

    @Override
    public void toVLayoutTest() {
        startActivity(new Intent(this, VLayoutTestActivity.class));
    }

    @Override
    public void toTakePhoto() {
        startActivity(new Intent(this, TakePhotoActivity.class));
    }

    @Override
    public void toIFly() {
        startActivity(new Intent(this, IflyTestActivity.class));
    }

    @Override
    public void toMutiProcess() {
        startActivity(new Intent(this, ProcessActivity.class));
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
