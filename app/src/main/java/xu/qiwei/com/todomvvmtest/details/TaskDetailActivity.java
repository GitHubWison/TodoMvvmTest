package xu.qiwei.com.todomvvmtest.details;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.PopupWindow;

import java.util.ArrayList;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.ViewHolder;
import xu.qiwei.com.todomvvmtest.adapter.PersonTestViewModel;
import xu.qiwei.com.todomvvmtest.adapter.PopWindowListAdapter;
import xu.qiwei.com.todomvvmtest.data.source.LocalSourceData;
import xu.qiwei.com.todomvvmtest.databinding.TestPopwindowLayoutBinding;
import xu.qiwei.com.todomvvmtest.tasks.TaskItemNavigator;
import xu.qiwei.com.todomvvmtest.utils.MeasureUtils;

public class TaskDetailActivity extends AppCompatActivity implements TaskItemNavigator, PopWindowNavigator {
    private static final String DETAIL_VIEWMODEL = "DETAIL_VIEWMODEL";
    PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        TaskDetailFragment taskDetailFragment = findOrCreateFragment();
        TaskDetailViewModel taskDetailViewModel = findOrCreateViewModel();
        taskDetailFragment.setViewModel(taskDetailViewModel);
    }

    private TaskDetailFragment findOrCreateFragment() {
        TaskDetailFragment resultTaskDetailFragment = (TaskDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_main_framelayout);
        if (resultTaskDetailFragment == null) {
            resultTaskDetailFragment = TaskDetailFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), R.id.detail_main_framelayout, resultTaskDetailFragment);
        }
        return resultTaskDetailFragment;
    }

    @Nullable
    @SuppressWarnings("unchecked")
    private TaskDetailViewModel findOrCreateViewModel() {
//        ViewHolder<TaskDetailViewModel> viewHolder = new ViewHolder<>();
        ViewHolder<TaskDetailViewModel> viewHolder = (ViewHolder<TaskDetailViewModel>) getSupportFragmentManager().findFragmentByTag(DETAIL_VIEWMODEL);
        if (viewHolder != null && viewHolder.getViewModel() != null) {
            return viewHolder.getViewModel();
        } else {
            TaskDetailViewModel taskDetailViewModel = new TaskDetailViewModel(LocalSourceData.getInstance(this), this);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    ViewHolder.createViewModelContiner(taskDetailViewModel),
                    DETAIL_VIEWMODEL);
            return taskDetailViewModel;
        }

    }

    @Override
    public void toTaskDetail() {

    }

    @Override
    public void toAddTaskActivity() {

    }

    @Override
    public void showPopWindow(final Button button) {
        final TestPopwindowLayoutBinding binding;
//
        binding = TestPopwindowLayoutBinding.inflate(LayoutInflater.from(this), null, false);
        binding.spinnerlistListview.setAdapter(new PopWindowListAdapter(new ArrayList<PopWindowListAdapter.Person>(0)));
        binding.setViewmodel(new PersonTestViewModel());
        popupWindow = new PopupWindow(binding.getRoot(), button.getWidth(), MeasureUtils.dip2px(TaskDetailActivity.this,300));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        ColorDrawable colorDrawable = new ColorDrawable(0000000000);
        popupWindow.setBackgroundDrawable(colorDrawable);
        popupWindow.showAsDropDown(button, 0, 0);

    }
}
