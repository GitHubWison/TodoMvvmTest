package xu.qiwei.com.todomvvmtest.recyclelisttest.childs.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import xu.qiwei.com.todomvvmtest.databinding.ViewRecycle3LayoutBinding;
import xu.qiwei.com.todomvvmtest.recyclelisttest.childs.viewmodels.RecycleViewModel3;
import xu.qiwei.com.todomvvmtest.testttr.interfacess.ViewWithViewModel;

/**
 * Created by xuqiwei on 17-6-1.
 */

public class RecycleView3 extends LinearLayout implements ViewWithViewModel{
    public RecycleView3(Context context) {
        super(context);
    }

    public RecycleView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setViewModel(Object viewModel) {
        ViewRecycle3LayoutBinding binding  = ViewRecycle3LayoutBinding.inflate(LayoutInflater.from(getContext()),this,true);
        binding.setViemodel((RecycleViewModel3) viewModel);
    }
}
