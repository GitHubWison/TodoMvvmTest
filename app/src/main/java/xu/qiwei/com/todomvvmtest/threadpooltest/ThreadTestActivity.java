package xu.qiwei.com.todomvvmtest.threadpooltest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.databinding.ActivityThreadTestBinding;

public class ThreadTestActivity extends AppCompatActivity implements ThreadTestView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThreadTestBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_thread_test);
        binding.setViewmodel(new ThreadTestViewModel(this));
    }

    @Override
    public void getData() {

    }
}
