package xu.qiwei.com.todomvvmtest.commontest;

import android.content.Context;
import android.databinding.ObservableField;
import android.widget.Toast;

/**
 * Created by xuqiwei on 17-5-24.
 */

public class TestViewModel {
    Context context;
    public TestViewModel(Context context) {
        this.context = context;
    }

    public final ObservableField<String> checks = new ObservableField<>();
    public final void checkStr(){
        String str = checks.get();
        Toast.makeText(context, isDigitsOnly(str)+"", Toast.LENGTH_SHORT).show();
    }
    public static boolean isDigitsOnly(CharSequence str) {
        if (str==null||str.equals("")||str.equals("null")) {
            return false;
        }
        final int len = str.length();
        for (int cp, i = 0; i < len; i += Character.charCount(cp)) {
            cp = Character.codePointAt(str, i);
            if (!(Character.isDigit(cp)||cp==46)) {
                return false;
            }
        }
        return true;
    }
}
