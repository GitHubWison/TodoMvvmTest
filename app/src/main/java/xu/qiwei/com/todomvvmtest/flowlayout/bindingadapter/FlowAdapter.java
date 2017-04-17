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
        TagTestAdapter adapter = new TagTestAdapter(items,flowLayout.getContext());
        flowLayout.setAdapter(adapter);
    }
    @BindingAdapter(requireAll = false,value = {"FlowlayoutListener"})
    public static void setFlowlayoutListener(TagFlowLayout flowLayout, TagFlowLayout.OnTagClickListener onTagClickListener){
        flowLayout.setOnTagClickListener(onTagClickListener);
    }
}
