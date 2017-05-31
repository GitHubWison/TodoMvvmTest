package xu.qiwei.com.todomvvmtest.activityloadmods;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import xu.qiwei.com.todomvvmtest.R;

public class ThreeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Log.e("ThreeActivitylog=","onCreate");
    }
    public void toFour(View view)
    {
        startActivity(new Intent(this,FourActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ThreeActivitylog=","onResume");
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
//        Log.i(TAG, "Key_Stuta = " + event.getAction());
        if (keycode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // 右键处理

            moveTaskToBack(true); }

        return true;
    }

}
