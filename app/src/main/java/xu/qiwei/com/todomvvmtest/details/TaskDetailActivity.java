package xu.qiwei.com.todomvvmtest.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.ViewHolder;
import xu.qiwei.com.todomvvmtest.data.source.LocalSourceData;
import xu.qiwei.com.todomvvmtest.tasks.TaskItemNavigator;

public class TaskDetailActivity extends AppCompatActivity implements TaskItemNavigator{
    private static final String DETAIL_VIEWMODEL = "DETAIL_VIEWMODEL";
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
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), R.id.detail_main_framelayout,resultTaskDetailFragment );
        }
        return resultTaskDetailFragment;
    }

    @Nullable
    @SuppressWarnings("unchecked")
    private TaskDetailViewModel findOrCreateViewModel() {
//        ViewHolder<TaskDetailViewModel> viewHolder = new ViewHolder<>();
        ViewHolder<TaskDetailViewModel> viewHolder = (   ViewHolder<TaskDetailViewModel>)getSupportFragmentManager().findFragmentByTag(DETAIL_VIEWMODEL);
        if (viewHolder!=null&&viewHolder.getViewModel()!=null) {
            return viewHolder.getViewModel();
        }
        else
        {
            TaskDetailViewModel taskDetailViewModel = new TaskDetailViewModel(LocalSourceData.getInstance(this));
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
}
