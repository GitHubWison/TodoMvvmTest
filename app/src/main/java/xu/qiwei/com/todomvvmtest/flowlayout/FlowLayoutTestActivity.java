package xu.qiwei.com.todomvvmtest.flowlayout;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.com.zhy.view.flowlayout.TagFlowLayout;
import xu.qiwei.com.todomvvmtest.flowlayout.adapter.TagTestAdapter;

public class FlowLayoutTestActivity extends Activity {
    private TagFlowLayout mflowlayout;
    private List<String> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout_test);
        initDatas();
        initViews();
    }

    private void initViews() {
        mflowlayout = (TagFlowLayout)findViewById(R.id.mflowlayout);
        TagTestAdapter tagTestAdapter = new TagTestAdapter(datas,this,mflowlayout);
        mflowlayout.setAdapter(tagTestAdapter);
    }

    private void initDatas() {
        datas = new ArrayList<>();
        datas.add("111111111111111111111111111444444444111");
        datas.add("222222222222222222");
        datas.add("555555555555555555555555555555555555");
        datas.add("333333333333333333333333333333333333333333333333333333333333333333333333");
        datas.add("444444444444444444444444444");
        datas.add("555555555555555555555555555555555555");
    }
}
