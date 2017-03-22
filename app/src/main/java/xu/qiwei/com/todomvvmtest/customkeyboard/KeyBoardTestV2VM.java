package xu.qiwei.com.todomvvmtest.customkeyboard;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by xuqiwei on 17-3-22.
 */

public class KeyBoardTestV2VM {
    private KeyBoardV2View keyBoardV2View;
    int count = 1;
    public View.OnFocusChangeListener onEditFocus = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {
            if (b) {
                InputMethodManager imm = (InputMethodManager) keyBoardV2View.getMainActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
            Log.e("onEditFocus", "onEditFocus");
        }
    };

    public void onTextClick(View view) {
        InputMethodManager imm = (InputMethodManager) keyBoardV2View.getMainActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InputMethodManager imm = (InputMethodManager) keyBoardV2View.getMainActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
            Log.e("onTouchListener", "ACTION_UP");

            return false;
        }
    };

    public KeyBoardTestV2VM(KeyBoardV2View keyBoardV2View) {
        this.keyBoardV2View = keyBoardV2View;
    }
}
