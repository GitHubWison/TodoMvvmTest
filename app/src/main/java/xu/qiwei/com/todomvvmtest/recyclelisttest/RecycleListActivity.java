package xu.qiwei.com.todomvvmtest.recyclelisttest;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.databinding.ActivityRecycleListBinding;

public class RecycleListActivity extends Activity implements RecycleListMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecycleListBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_recycle_list);
        binding.setViewmodel(new RecycleListViewModel(this));
//        binding.mainListview.setAdapter(new RecycleListAdapter());
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
