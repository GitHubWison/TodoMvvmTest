package xu.qiwei.com.todomvvmtest.commontest;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.databinding.ActivityTestBinding;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_test);
        binding.setViewmodel(new TestViewModel(this));
    }
}
