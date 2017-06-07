package xu.qiwei.com.todomvvmtest.takephoto.views.childs.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import xu.qiwei.com.todomvvmtest.databinding.ViewTakePhotoBinding;
import xu.qiwei.com.todomvvmtest.takephoto.views.childs.viewmodels.TakePhotoViewModel;
import xu.qiwei.com.todomvvmtest.testttr.interfacess.ViewWithViewModel;

/**
 * Created by xuqiwei on 17-6-6.
 */

public class TakePhotoView extends LinearLayout implements ViewWithViewModel {

    public TakePhotoView(Context context) {
        super(context);
        init();
    }

    public TakePhotoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
    }

    @Override
    public void setViewModel(Object viewModel) {
        ViewTakePhotoBinding binding = ViewTakePhotoBinding
                .inflate(LayoutInflater.from(getContext()),this,true);
        binding.setViewmodel((TakePhotoViewModel)viewModel);
    }
}
