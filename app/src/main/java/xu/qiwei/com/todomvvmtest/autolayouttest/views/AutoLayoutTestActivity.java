package xu.qiwei.com.todomvvmtest.autolayouttest.views;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.zhy.autolayout.AutoLayoutActivity;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.ViewHolder;
import xu.qiwei.com.todomvvmtest.autolayouttest.viewmodels.AutoLayoutViewModel;

@SuppressWarnings("unchecked")
public class AutoLayoutTestActivity extends AutoLayoutActivity {
    private static final String AUTOLAYOUTVIEWMODEL_TAG = "AutoLayoutViewModel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_layout);
        initFragments();
    }

    private void initFragments() {
        AutoLayoutFragment autoLayoutFragment = AutoLayoutFragment.newInstance();
        autoLayoutFragment.setViewModel(findOrCreateAutoLayoutVM());
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                R.id.autolayoutmain_framelayout,autoLayoutFragment);
    }

    private AutoLayoutViewModel findOrCreateAutoLayoutVM() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ViewHolder<AutoLayoutViewModel> viewModelViewHolder =
                (ViewHolder<AutoLayoutViewModel>) fragmentManager.findFragmentByTag(AUTOLAYOUTVIEWMODEL_TAG);
        if (viewModelViewHolder != null && viewModelViewHolder.getViewModel() != null) {
            return viewModelViewHolder.getViewModel();
        } else {
            AutoLayoutViewModel autoLayoutViewModel = new AutoLayoutViewModel();
            ActivityUtils.addFragmentToActivity(fragmentManager,
                    ViewHolder.createViewModelContiner(autoLayoutViewModel),
                    AUTOLAYOUTVIEWMODEL_TAG
                    );

            return autoLayoutViewModel;
        }

    }
}
