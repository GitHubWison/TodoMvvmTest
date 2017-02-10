package xu.qiwei.com.todomvvmtest.tasks;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xuqiwei on 17-2-10.
 */

public class TasksListViewModel {
    public final ObservableList<Task> items = new ObservableArrayList<>();
    public ObservableField<Boolean> isRefreshing = new ObservableField<>();
    private TaskItemNavigator mTaskItemNavigator;
    public TasksListViewModel(@NotNull TaskItemNavigator taskItemNavigator) {
        mTaskItemNavigator = checkNotNull(taskItemNavigator);

    }

    public void loadTasks(){
        isRefreshing.set(true);
        List<Task> tempTasks = new ArrayList<>();

        for (int i=0;i<30;i++)
        {
            tempTasks.add(new Task("title"+ new Random().nextInt(10),"desc"+i));
        }

        items.clear();
        items.addAll(tempTasks);
        isRefreshing.set(false);
    }

    public void onTestButtonClicked(){
        Log.e("onTestButtonClicked","onTestButtonClicked");
        loadTasks();

    }
    public void onpageRefresh(){
        Log.e("onpageRefresh","onpageRefresh123");

        loadTasks();
    }
}
