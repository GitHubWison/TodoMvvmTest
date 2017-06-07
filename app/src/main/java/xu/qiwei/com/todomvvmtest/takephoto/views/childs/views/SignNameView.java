package xu.qiwei.com.todomvvmtest.takephoto.views.childs.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import xu.qiwei.com.todomvvmtest.databinding.ViewSignnameBinding;
import xu.qiwei.com.todomvvmtest.takephoto.views.childs.viewmodels.SignNameViewModel;
import xu.qiwei.com.todomvvmtest.testttr.interfacess.ViewWithViewModel;

/**
 * Created by xuqiwei on 17-6-6.
 */

public class SignNameView extends LinearLayout implements ViewWithViewModel{
    public SignNameView(Context context) {
        super(context);
    }

    public SignNameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setViewModel(Object viewModel) {
        ViewSignnameBinding binding = ViewSignnameBinding.inflate(LayoutInflater.from(getContext()),this,true);
        binding.setViewmodel((SignNameViewModel)viewModel);
    }
}
