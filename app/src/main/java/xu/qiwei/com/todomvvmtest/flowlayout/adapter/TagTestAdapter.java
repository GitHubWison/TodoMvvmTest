package xu.qiwei.com.todomvvmtest.flowlayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.com.zhy.view.flowlayout.FlowLayout;
import xu.qiwei.com.todomvvmtest.com.zhy.view.flowlayout.TagAdapter;
import xu.qiwei.com.todomvvmtest.com.zhy.view.flowlayout.TagFlowLayout;


/**
 * Created by xuqiwei on 17-4-12.
 */

public class TagTestAdapter extends TagAdapter<String> {
    private List<String> datas;
    private Context context;
    private TagFlowLayout tagFlowLayout;
    public TagTestAdapter(List<String> datas, Context context, TagFlowLayout tagFlowLayout) {
        super(datas);
        this.datas = datas;
        this.context = context;
        this.tagFlowLayout=tagFlowLayout;
    }

    @Override
    public View getView(FlowLayout parent, int position, String s) {
         LayoutInflater mInflater = LayoutInflater.from(context);
       View view =  mInflater.inflate(R.layout.flowlayouttest_layout,
               tagFlowLayout, false);
        TextView radioButton = (TextView)view.findViewById(R.id.main_radiobutton);
        radioButton.setText(s);
        return view;
    }

    public void replaceData(List<String> items) {
        datas = items;
        notifyDataChanged();
    }
}
