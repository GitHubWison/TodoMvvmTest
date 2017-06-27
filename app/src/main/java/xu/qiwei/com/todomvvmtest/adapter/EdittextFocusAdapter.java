package xu.qiwei.com.todomvvmtest.adapter;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.EditText;

import xu.qiwei.com.todomvvmtest.mutiprocess.MessageModel;

/**
 * Created by xuqiwei on 17-3-22.
 */

public class EdittextFocusAdapter {
    @BindingAdapter(value = {"EditTextFocus","EditTextOnTouch"},requireAll = false)
    public static void editTextFocusCommand(final EditText editText, View.OnFocusChangeListener onFocusChangeListener,View.OnTouchListener onTouchListener){
        editText.setShowSoftInputOnFocus(false);
        editText.setOnFocusChangeListener(onFocusChangeListener);
        editText.setOnTouchListener(onTouchListener);
    }
}
