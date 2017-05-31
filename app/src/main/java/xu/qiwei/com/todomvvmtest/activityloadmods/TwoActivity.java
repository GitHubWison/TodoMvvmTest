package xu.qiwei.com.todomvvmtest.activityloadmods;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import xu.qiwei.com.todomvvmtest.R;


public class TwoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }
    public void toThree(View view)
    {
        Intent intent = new Intent(this,ThreeActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP );
        startActivity(intent);
    }
}
