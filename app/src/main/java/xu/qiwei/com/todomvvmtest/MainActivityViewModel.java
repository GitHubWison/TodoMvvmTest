package xu.qiwei.com.todomvvmtest;

/**
 * Created by xuqiwei on 17-2-10.
 */

public class MainActivityViewModel {
    private TasksNavigator tasksNavigator;

    public MainActivityViewModel(TasksNavigator tasksNavigator) {
        this.tasksNavigator = tasksNavigator;
    }

    public void toTaskListActivity(){
        tasksNavigator.toTaskListActivity();
    }
}
