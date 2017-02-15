package xu.qiwei.com.todomvvmtest.tasks;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import xu.qiwei.com.todomvvmtest.data.source.SourceData;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xuqiwei on 17-2-10.
 */

public class TaskItemViewModel extends BaseObservable {
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<Task> mTask = new ObservableField<>();
    public final ObservableBoolean completed = new ObservableBoolean();


    private TaskItemNavigator mTaskItemNavigator;
    private SourceData mLocalSourceData;

    public TaskItemViewModel(SourceData localSourceData, TaskItemNavigator taskItemNavigator) {
        mTaskItemNavigator = checkNotNull(taskItemNavigator);
        mLocalSourceData = checkNotNull(localSourceData);
        mTask.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Task task = mTask.get();
                title.set(task.getTitle());
                description.set(task.getDescription());
                completed.set(task.isCompleted());
            }
        });
    }

    public void setTask(Task task) {
        mTask.set(task);
    }

    public void toTaskDetail() {
        checkNotNull(mTaskItemNavigator).toTaskDetail();
    }

    @Bindable
    public boolean getCompleted() {
        return mTask.get().isCompleted();
    }

    public void setCompleted(boolean completed) {

//        修改ｔａｓｋ的勾选状态
//        Task temp = mTask.get();
//        this.completed.set(completed);
        mTask.get().setCompleted(completed);

        if (completed) {
            mLocalSourceData.completeTask(mTask.get());
        } else {
            mLocalSourceData.activedTask(mTask.get());
        }
    }

}
