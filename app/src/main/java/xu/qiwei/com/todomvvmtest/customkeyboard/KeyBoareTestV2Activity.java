package xu.qiwei.com.todomvvmtest.customkeyboard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.databinding.ActivityKeyBoareTestV2Binding;

public class KeyBoareTestV2Activity extends AppCompatActivity implements KeyBoardV2View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityKeyBoareTestV2Binding binding = DataBindingUtil.
                setContentView(this,R.layout.activity_key_boare_test_v2);
        binding.setViewModel(new KeyBoardTestV2VM(this));
  /*      binding.onetEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.e("onEditFocus", "onEditFocus");
            }
        });
        binding.onetEdittext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
                Log.e("onTouchListener", "ACTION_UP");

                return false;
            }
        });*/
    }

    @Override
    public AppCompatActivity getMainActivity() {
        return this;
    }
}
