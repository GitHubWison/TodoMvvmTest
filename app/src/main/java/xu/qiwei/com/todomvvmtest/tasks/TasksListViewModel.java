package xu.qiwei.com.todomvvmtest.tasks;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import xu.qiwei.com.todomvvmtest.data.source.SourceData;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xuqiwei on 17-2-10.
 */

public class TasksListViewModel {
    public final ObservableList<Task> items = new ObservableArrayList<>();
    public ObservableField<Boolean> isRefreshing = new ObservableField<>();
    private TaskItemNavigator mTaskItemNavigator;
    private SourceData localSourceData;
    public TasksListViewModel(@NotNull TaskItemNavigator taskItemNavigator, SourceData localSourceData) {
        mTaskItemNavigator = checkNotNull(taskItemNavigator);
        this.localSourceData = checkNotNull(localSourceData);
    }

    public void loadTasks(){
        isRefreshing.set(true);
    /*    List<Task> tempTasks = new ArrayList<>();

        for (int i=0;i<30;i++)
        {
            tempTasks.add(new Task("title"+ new Random().nextInt(10),"desc"+i));
        }
*/

        List<Task> tasks = localSourceData.getTasks();
        Log.e("taskslength",tasks.size()+"");
        items.clear();
        items.addAll(tasks);
        isRefreshing.set(false);
    }
    public void addTask(){
        Task task = new Task("1111","desc1111",false);
        localSourceData.addTask(task);
        Log.e("localSourceDataadd","addsuccess");
    }

    public void onTestButtonClicked(){

        addTask();
        Log.e("addTasklog","addTasksuccess");

    }
    public void onpageRefresh(){
        Log.e("onpageRefresh","onpageRefresh123");

        loadTasks();
    }
}
