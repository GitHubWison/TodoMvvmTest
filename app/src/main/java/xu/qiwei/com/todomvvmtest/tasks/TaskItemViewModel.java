package xu.qiwei.com.todomvvmtest.tasks;


import android.databinding.Observable;
import android.databinding.ObservableField;

/**
 * Created by xuqiwei on 17-2-10.
 */

public class TaskItemViewModel {
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<Task> mTask = new ObservableField<>();

    public TaskItemViewModel() {
        mTask.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Task task = mTask.get();
                title.set(task.getTitle());
                description.set(task.getDescription());
            }
        });
    }

    public void setTask(Task task){
        mTask.set(task);
    }

}
