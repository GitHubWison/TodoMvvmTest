package xu.qiwei.com.todomvvmtest.customkeyboard;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import xu.qiwei.com.todomvvmtest.R;

public class KeyBoardTestActivity extends AppCompatActivity {
    private EditText test_edittext;
    private KeyBoardUtils keyBoardUtils;
    private EditText test2_edittext;

    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {

            if (b) {
                keyBoardUtils.setEditText((EditText) view);
            }

        }
    };
    private  View.OnTouchListener onTouchListener =  new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            return false;
        }
    };

    public void hideSoftInputMethod(EditText ed){
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        int currentVersion = android.os.Build.VERSION.SDK_INT;
        String methodName = null;
        if(currentVersion >= 16){
            // 4.2
            methodName = "setShowSoftInputOnFocus";
        }
        else if(currentVersion >= 14){
            // 4.0
            methodName = "setSoftInputShownOnFocus";
        }

        if(methodName == null){
            ed.setInputType(InputType.TYPE_NULL);
        }
        else{
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnFocus;
            try {
                setShowSoftInputOnFocus = cls.getMethod(methodName, boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(ed, false);
            } catch (NoSuchMethodException e) {
                ed.setInputType(InputType.TYPE_NULL);
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_board_test);
        keyBoardUtils = new KeyBoardUtils(this, this);
        initViews();
        initEvent();
    }

    private void initViews() {
        test_edittext = (EditText) findViewById(R.id.test_edittext);
        test2_edittext = (EditText) findViewById(R.id.test2_edittext);

//        test_edittext.setInputType(InputType.TYPE_NULL);
//        test2_edittext.setInputType(InputType.TYPE_NULL);

        test_edittext.setShowSoftInputOnFocus(false);
        test2_edittext.setShowSoftInputOnFocus(false);

    }

    private void initEvent() {
        test_edittext.setOnFocusChangeListener(focusChangeListener);
        test2_edittext.setOnFocusChangeListener(focusChangeListener);
        test_edittext.setOnTouchListener(onTouchListener);
        test2_edittext.setOnTouchListener(onTouchListener);
    }
}
