package xu.qiwei.com.todomvvmtest.component.spinner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import xu.qiwei.com.todomvvmtest.databinding.SpinnerComponentLayoutBinding;

/**
 * Created by xuqiwei on 17-2-16.
 */

public class SpinnerComponent extends LinearLayout {
    private SpinnerComponentLayoutBinding binding;
    public SpinnerComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        binding = SpinnerComponentLayoutBinding.inflate(LayoutInflater.from(context), this, true);
        binding.setViewmodel(new SpinnerComponentViewModel(context));
    }
}
