package xu.qiwei.com.todomvvmtest.componenttest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.databinding.ActivityComponentBinding;

public class ComponentActivity extends AppCompatActivity implements ComponentView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityComponentBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_component);
        binding.setViewmodel(new ComponentModel(this));
    }
}
