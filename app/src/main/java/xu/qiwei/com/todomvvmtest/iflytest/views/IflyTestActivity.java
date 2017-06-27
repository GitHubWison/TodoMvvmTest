package xu.qiwei.com.todomvvmtest.iflytest.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.databinding.ActivityIflyTestBinding;
import xu.qiwei.com.todomvvmtest.iflytest.iviews.IIflyTestActivityView;
import xu.qiwei.com.todomvvmtest.iflytest.viewmodels.IflyTestActivityViewModel;
import xu.qiwei.com.todomvvmtest.iflytest.viewmodels.IflyTestViewModel;

public class IflyTestActivity extends FragmentActivity implements IIflyTestActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIflyTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_ifly_test);
        binding.setViewmodel(new IflyTestActivityViewModel(this));
        initFragments();
    }

    private void initFragments() {
        IflyTestFragment iflyTestFragment = IflyTestFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),R.id.ifly_test_framelayout,iflyTestFragment);
        iflyTestFragment.setViewModel(new IflyTestViewModel(),this);

    }
}
