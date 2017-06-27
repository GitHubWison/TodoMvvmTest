package xu.qiwei.com.todomvvmtest.testpy.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.databinding.ActivityTestOneBinding;
import xu.qiwei.com.todomvvmtest.testpy.iviews.ITestOneActivityView;
import xu.qiwei.com.todomvvmtest.testpy.viewmodels.TestOneActivityViewModel;
import xu.qiwei.com.todomvvmtest.testpy.viewmodels.TestOneViewModel;

public class TestOneActivity extends FragmentActivity implements ITestOneActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestOneBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_test_one);
        binding.setViewmodel(new TestOneActivityViewModel(this));
        initFragments();
    }

    private void initFragments() {
        TestOneFragment testOneFragment = TestOneFragment.newInstance();
        testOneFragment.setViewModel(new TestOneViewModel());
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),R.id.testone_framelayout,testOneFragment);
    }
}
