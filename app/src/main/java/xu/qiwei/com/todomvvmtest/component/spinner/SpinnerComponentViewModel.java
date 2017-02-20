package xu.qiwei.com.todomvvmtest.component.spinner;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.ArrayList;

import xu.qiwei.com.todomvvmtest.adapter.PersonTestViewModel;
import xu.qiwei.com.todomvvmtest.adapter.PopWindowListAdapter;
import xu.qiwei.com.todomvvmtest.databinding.TestPopwindowLayoutBinding;
import xu.qiwei.com.todomvvmtest.utils.MeasureUtils;

/**
 * Created by xuqiwei on 17-2-16.
 */

public class SpinnerComponentViewModel {
    private PopupWindow popupWindow;
    private Context context;

    public SpinnerComponentViewModel(Context context) {
        this.context = context;
    }

    public void onSpinnerClicked(View view) {
        LinearLayout mainLayout = (LinearLayout) view;
        findOrCreatePopWindow(mainLayout).showAsDropDown(mainLayout, 0, 0);
    }

    private PopupWindow findOrCreatePopWindow(LinearLayout linearLayout) {
        if (popupWindow == null) {
            TestPopwindowLayoutBinding popwinbinding = TestPopwindowLayoutBinding.inflate(LayoutInflater.from(context), null, false);
            popwinbinding.setViewmodel(new PersonTestViewModel());
            popwinbinding.spinnerlistListview.setAdapter(new PopWindowListAdapter(new ArrayList<PopWindowListAdapter.Person>(0)));
            popupWindow = new PopupWindow(popwinbinding.getRoot(), linearLayout.getWidth(), MeasureUtils.dip2px(context, 300));
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);
            ColorDrawable colorDrawable = new ColorDrawable(0000000000);
            popupWindow.setBackgroundDrawable(colorDrawable);
        }
        return popupWindow;
    }

}
