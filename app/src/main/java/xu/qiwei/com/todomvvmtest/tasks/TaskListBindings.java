package xu.qiwei.com.todomvvmtest.tasks;

import android.databinding.BindingAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by xuqiwei on 17-2-10.
 */

public class TaskListBindings {
    @SuppressWarnings("unchecked")
    @BindingAdapter("app:items")
    public static final void setListItems(ListView listView, List<Task> tasks)
    {
        TasksFragment.TaskAdapter adapter = (TasksFragment.TaskAdapter)listView.getAdapter();
        if (adapter!=null) {
            adapter.replaceTasks(tasks);
        }
    }
}
