package xu.qiwei.com.todomvvmtest.flowlayout.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import xu.qiwei.com.todomvvmtest.com.zhy.view.flowlayout.FlowLayout;
import xu.qiwei.com.todomvvmtest.com.zhy.view.flowlayout.TagFlowLayout;
import xu.qiwei.com.todomvvmtest.flowlayout.view.FlowLayoutView;

/**
 * Created by xuqiwei on 17-4-14.
 */

public class FlowLayoutTestViewModel implements TagFlowLayout.OnTagClickListener{
    public final ObservableList<String> items = new ObservableArrayList<>();
    private FlowLayoutView flowView;
    public FlowLayoutTestViewModel(FlowLayoutView flowView) {
        this.flowView = flowView;
        initDatas();
    }

    private void initDatas() {
        items.clear();
        List<String> testdata = new ArrayList<>();
        testdata.add("1111111111111111111111");
        testdata.add("2222222222");
        testdata.add("33333333333333333333333333333333");
        testdata.add("44444444444444444444444444444444444444444444444");
        testdata.add("555");
        items.addAll(testdata);
    }

    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {

        TagFlowLayout tagflowlayout =  (TagFlowLayout)parent;
        String item= (String)tagflowlayout.getAdapter().getItem(position);
        if (flowView!=null) {
            flowView.toastMsg(item+"ｃｌｉｃｋ");
        }
        return true;
    }
}
