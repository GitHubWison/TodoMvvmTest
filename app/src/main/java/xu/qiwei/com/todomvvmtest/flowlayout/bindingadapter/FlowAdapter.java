package xu.qiwei.com.todomvvmtest.flowlayout.bindingadapter;

import android.databinding.BindingAdapter;

import java.util.List;

import xu.qiwei.com.todomvvmtest.com.zhy.view.flowlayout.TagFlowLayout;
import xu.qiwei.com.todomvvmtest.flowlayout.adapter.TagTestAdapter;

/**
 * Created by xuqiwei on 17-4-14.
 */

public class FlowAdapter {
    @BindingAdapter(requireAll = false,value = {"flowitems"})
    public static void setFlowItems(TagFlowLayout flowLayout, List<String> items){
        TagTestAdapter adapter = (TagTestAdapter)flowLayout.getAdapter();
        if (adapter!=null) {
            adapter.replaceData(items);
        }
    }
}
