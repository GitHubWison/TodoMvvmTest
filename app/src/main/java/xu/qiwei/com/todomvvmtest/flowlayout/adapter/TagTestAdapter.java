package xu.qiwei.com.todomvvmtest.flowlayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.com.zhy.view.flowlayout.FlowLayout;
import xu.qiwei.com.todomvvmtest.com.zhy.view.flowlayout.TagAdapter;


/**
 * Created by xuqiwei on 17-4-12.
 */

public class TagTestAdapter extends TagAdapter<String> {
    private List<String> datas;
    private Context context;

    public TagTestAdapter(List<String> datas, Context context) {
        super(datas);
        this.datas = datas;
        this.context = context;

    }

    @Override
    public View getView(FlowLayout parent, int position, String s) {
         LayoutInflater mInflater = LayoutInflater.from(context);
       View view =  mInflater.inflate(R.layout.flowlayouttest_layout,
               parent, false);
        TextView radioButton = (TextView)view.findViewById(R.id.main_radiobutton);
        radioButton.setText(datas.get(position));
        return view;
    }

}
