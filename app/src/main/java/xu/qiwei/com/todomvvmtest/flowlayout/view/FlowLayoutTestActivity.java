package xu.qiwei.com.todomvvmtest.flowlayout.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.ViewHolder;
import xu.qiwei.com.todomvvmtest.com.zhy.view.flowlayout.TagFlowLayout;
import xu.qiwei.com.todomvvmtest.flowlayout.viewmodel.FlowLayoutTestViewModel;

public class FlowLayoutTestActivity extends AppCompatActivity implements FlowLayoutView{
    private TagFlowLayout mflowlayout;
    private List<String> datas;
    private static final String FLOWLAYOUTTESTVIEWMODEL = "FlowLayoutTestViewModel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout_test);
        FlowLayoutTestViewModel flowLayoutTestViewModel = findOrCreateFlowLayoutTestVM();
        FlowLayoutTestFragment flowLayoutTestFragment = FlowLayoutTestFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),R.id.main_framelayout,flowLayoutTestFragment);
        flowLayoutTestFragment.setViewModel(flowLayoutTestViewModel);
//        initDatas();
//        initViews();
    }

    @SuppressWarnings("unchecked")
    private FlowLayoutTestViewModel findOrCreateFlowLayoutTestVM() {
        FragmentManager fragmentManager  = getSupportFragmentManager();
        ViewHolder<FlowLayoutTestViewModel> viewModelViewHolder =
                (ViewHolder<FlowLayoutTestViewModel>)fragmentManager.findFragmentByTag(FLOWLAYOUTTESTVIEWMODEL);
        if (viewModelViewHolder!=null&&viewModelViewHolder.getViewModel()!=null) {
            return viewModelViewHolder.getViewModel();
        }else {
            FlowLayoutTestViewModel flowLayoutTestViewModel = new FlowLayoutTestViewModel(this);
            ActivityUtils.addFragmentToActivity(fragmentManager,
                    ViewHolder.createViewModelContiner(flowLayoutTestViewModel)
            ,FLOWLAYOUTTESTVIEWMODEL);
            return flowLayoutTestViewModel;
        }
    }

    @Override
    public void toastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


 /*   private void initViews() {
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
    }*/
}
