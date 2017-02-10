package xu.qiwei.com.todomvvmtest.tasks;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xuqiwei on 17-2-10.
 */

public class TasksListViewModel {
    public final ObservableList<Task> items = new ObservableArrayList<>();

    public TasksListViewModel() {
    }

    public void loadTasks(){
        List<Task> tempTasks = new ArrayList<>();

        for (int i=0;i<10;i++)
        {
            tempTasks.add(new Task("title"+ new Random().nextInt(10),"desc"+i));
        }

        items.clear();
        items.addAll(tempTasks);
    }

    public void onTestButtonClicked(){
        Log.e("onTestButtonClicked","onTestButtonClicked");
        loadTasks();

    }
}
