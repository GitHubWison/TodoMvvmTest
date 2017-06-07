package xu.qiwei.com.todomvvmtest.vlayouttest;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.DefaultLayoutHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.recyclelisttest.childs.viewmodels.RecycleViewModel1;
import xu.qiwei.com.todomvvmtest.recyclelisttest.childs.viewmodels.RecycleViewModel2;
import xu.qiwei.com.todomvvmtest.recyclelisttest.childs.viewmodels.RecycleViewModel3;
import xu.qiwei.com.todomvvmtest.recyclelisttest.childs.views.RecycleView1;
import xu.qiwei.com.todomvvmtest.recyclelisttest.childs.views.RecycleView2;
import xu.qiwei.com.todomvvmtest.recyclelisttest.childs.views.RecycleView3;

public class VLayoutTestActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<LinearLayout> views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlayout_test);
        initDatas();
        initViews();
    }

    private void initDatas() {
        views = new ArrayList<>();
        RecycleView1 recycleView1 = new RecycleView1(this);
        RecycleView2 recycleView2 = new RecycleView2(this);
        RecycleView3 recycleView3 = new RecycleView3(this);
        recycleView1.setViewModel(new RecycleViewModel1(null));
        recycleView2.setViewModel(new RecycleViewModel2(null));
        recycleView3.setViewModel(new RecycleViewModel3(null));
        RecycleView1 recycleView4 = new RecycleView1(this);
        RecycleView2 recycleView5 = new RecycleView2(this);
        RecycleView3 recycleView6 = new RecycleView3(this);
        recycleView4.setViewModel(new RecycleViewModel1(null));
        recycleView5.setViewModel(new RecycleViewModel2(null));
        recycleView6.setViewModel(new RecycleViewModel3(null));

        RecycleView1 recycleView7 = new RecycleView1(this);
        RecycleView2 recycleView8 = new RecycleView2(this);
        RecycleView3 recycleView9 = new RecycleView3(this);
        recycleView7.setViewModel(new RecycleViewModel1(null));
        recycleView8.setViewModel(new RecycleViewModel2(null));
        recycleView9.setViewModel(new RecycleViewModel3(null));
        views.add(recycleView1);
        views.add(recycleView2);
        views.add(recycleView3);
        views.add(recycleView4);
        views.add(recycleView5);
        views.add(recycleView6);

        views.add(recycleView7);
        views.add(recycleView8);
        views.add(recycleView9);
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.main_recycleview);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(10, 10, 10, 10);
            }
        });
        LayoutHelper layoutHelper = DefaultLayoutHelper.newHelper(views.size());
        List<LayoutHelper> layoutHelpers = new LinkedList<>();
        layoutHelpers.add(layoutHelper);
        layoutManager.setLayoutHelpers(layoutHelpers);
        recyclerView.setAdapter(new VirtualLayoutAdapter(layoutManager) {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Log.e("viewType==",parent.toString()+"");
                return new MainViewHolder(new LinearLayout(VLayoutTestActivity.this));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                holder.itemView.setLayoutParams(layoutParams);
                ((LinearLayout) holder.itemView).removeAllViews();
                ((LinearLayout) holder.itemView).addView(views.get(position));

               if (position % 2 == 0) {
                    holder.itemView.setBackgroundColor(0xaa00ff00);
                } else {
                    holder.itemView.setBackgroundColor(0xccff00ff);
                }
            }

            @Override
            public int getItemCount() {
                List<LayoutHelper> helpers = getLayoutHelpers();
                return views.size();
            }
        });
    }
    static class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(LinearLayout itemView) {
            super(itemView);
        }
    }
}
