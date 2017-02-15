package xu.qiwei.com.todomvvmtest.details;

import android.databinding.BindingAdapter;
import android.widget.Spinner;

import java.util.List;

import xu.qiwei.com.todomvvmtest.tasks.Task;
import xu.qiwei.com.todomvvmtest.tasks.TasksFragment;

/**
 * Created by xuqiwei on 17-2-15.
 */

public class SpinnerBindings {
    @BindingAdapter("items")
    public static final void setItems(Spinner spinner, List<Task> tasks){
        TasksFragment.TaskAdapter adapter = (TasksFragment.TaskAdapter)spinner.getAdapter();
        if (adapter!=null) {
            adapter.replaceTasks(tasks);
        }
    }
}
