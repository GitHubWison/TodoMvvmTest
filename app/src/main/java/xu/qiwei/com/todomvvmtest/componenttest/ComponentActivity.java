package xu.qiwei.com.todomvvmtest.componenttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xu.qiwei.com.todomvvmtest.R;

public class ComponentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);
    }
}
