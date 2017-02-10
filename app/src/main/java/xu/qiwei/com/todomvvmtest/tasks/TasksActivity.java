package xu.qiwei.com.todomvvmtest.tasks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.ViewHolder;

public class TasksActivity extends AppCompatActivity {

    private static final String TASKLIST_VIEWMODEL_TAG="TASKLIST_VIEWMODEL_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        TasksFragment tasksFragment = findOrCreateFragment();
        TasksListViewModel tasksListViewModel = findOrCreateViewModel();
        tasksFragment.setTasksListViewModel(tasksListViewModel);

    }

    private TasksListViewModel findOrCreateViewModel() {

        @SuppressWarnings("unchecked")
        ViewHolder<TasksListViewModel> tasksListViewModelViewHolder = (ViewHolder<TasksListViewModel>)getSupportFragmentManager().findFragmentByTag(TASKLIST_VIEWMODEL_TAG);
        if (tasksListViewModelViewHolder!=null&&tasksListViewModelViewHolder.getViewModel()!=null) {
            return tasksListViewModelViewHolder.getViewModel();
        }
        else
        {
            TasksListViewModel viewModel = new TasksListViewModel();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),ViewHolder.createViewModelContiner(viewModel),TASKLIST_VIEWMODEL_TAG);
            return viewModel;
        }
    }

    private TasksFragment findOrCreateFragment() {
        TasksFragment tasksFragment = (TasksFragment)getSupportFragmentManager().findFragmentById(R.id.task_fragmentlayout);
        if (tasksFragment==null) {
            tasksFragment = TasksFragment.newInstance();
        }
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),R.id.task_fragmentlayout,tasksFragment);
        return tasksFragment;
    }
}
