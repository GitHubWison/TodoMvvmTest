package xu.qiwei.com.todomvvmtest.recyclelisttest.childs.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import xu.qiwei.com.todomvvmtest.databinding.ViewRecycle1LayoutBinding;
import xu.qiwei.com.todomvvmtest.testttr.interfacess.ViewWithViewModel;

/**
 * Created by xuqiwei on 17-6-1.
 */

public class RecycleView1 extends LinearLayout implements ViewWithViewModel{
    public RecycleView1(Context context) {
        super(context);
//        init();
    }

    public RecycleView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        init();
    }

    @Override
    public void setViewModel(Object viewModel) {
        ViewRecycle1LayoutBinding binding  = ViewRecycle1LayoutBinding.inflate(LayoutInflater.from(getContext()),this,true);
//        binding.setViemodel((RecycleViewModel1) viewModel);

    }
}
