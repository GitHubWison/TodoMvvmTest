package xu.qiwei.com.todomvvmtest.customkeyboard;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.widget.EditText;

import xu.qiwei.com.todomvvmtest.R;

/**
 * Created by xuqiwei on 17-3-20.
 */

public class KeyBoardUtils {
    private Keyboard keyboard;
    private KeyboardView keyboardView;
    private EditText editText;

    public KeyBoardUtils(Activity activity, Context context) {
        keyboard = new Keyboard(context, R.xml.symbols);
        keyboardView = (KeyboardView) activity.findViewById(R.id.keyboard_view);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setEnabled(true);
        keyboardView.setPreviewEnabled(false);
        keyboardView.setOnKeyboardActionListener(listener);
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    private KeyboardView.OnKeyboardActionListener listener = new KeyboardView.OnKeyboardActionListener() {
        @Override
        public void swipeUp() {
        }

        @Override
        public void swipeRight() {
        }

        @Override
        public void swipeLeft() {
        }

        @Override
        public void swipeDown() {
        }

        @Override
        public void onText(CharSequence text) {
        }

        @Override
        public void onRelease(int primaryCode) {
        }

        @Override
        public void onPress(int primaryCode) {
        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            if (editText != null) {
                Editable editable = editText.getText();
                int start = editText.getSelectionStart();

                if (primaryCode == Keyboard.KEYCODE_DELETE) {// 回退
                    if (editable != null && editable.length() > 0) {
                        if (start > 0) {
                            editable.delete(start - 1, start);
                        }
                    }
                } else {
                    editable.insert(start, Character.toString((char) primaryCode));
                }
            }

       /*     Editable editable = ed.getText();
            int start = ed.getSelectionStart();
            if (primaryCode == Keyboard.KEYCODE_CANCEL) {// 完成
                hideKeyboard();
            } else if (primaryCode == Keyboard.KEYCODE_DELETE) {// 回退
                if (editable != null && editable.length() > 0) {
                    if (start > 0) {
                        editable.delete(start - 1, start);
                    }
                }
            } else if (primaryCode == Keyboard.KEYCODE_SHIFT) {// 大小写切换
                changeKey();
                keyboardView.setKeyboard(k1);

            } else if (primaryCode == Keyboard.KEYCODE_MODE_CHANGE) {// 数字键盘切换
                if (isnun) {
                    isnun = false;
                    keyboardView.setKeyboard(k1);
                } else {
                    isnun = true;
                    keyboardView.setKeyboard(k2);
                }
            } else if (primaryCode == 57419) { // go left
                if (start > 0) {
                    ed.setSelection(start - 1);
                }
            } else if (primaryCode == 57421) { // go right
                if (start < ed.length()) {
                    ed.setSelection(start + 1);
                }
            } else {
                editable.insert(start, Character.toString((char) primaryCode));
            }*/
        }
    };
}
