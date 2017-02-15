package xu.qiwei.com.todomvvmtest.details;

import android.databinding.ObservableArrayList;
import android.util.Log;

import java.util.List;

import xu.qiwei.com.todomvvmtest.data.source.SourceData;
import xu.qiwei.com.todomvvmtest.tasks.Task;

/**
 * Created by xuqiwei on 17-2-15.
 */

public class TaskDetailViewModel {
    public ObservableArrayList<Task> items = new ObservableArrayList<>();
    public SourceData localSourceData;

    public TaskDetailViewModel(SourceData localSourceData) {
        this.localSourceData = localSourceData;
    }

    public void loadTasks(){

        List<Task> tasks = localSourceData.getTasks();
        Log.e("taskslength",tasks.size()+"");
        items.clear();
        items.addAll(tasks);

    }
}
