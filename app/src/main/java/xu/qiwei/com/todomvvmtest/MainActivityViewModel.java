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
    public void toBindingTest(){
        tasksNavigator.toBindingTest();
    }
    public void toTimeSync(){
        tasksNavigator.toTimeSync();
    }
    public void toThreadTest(){
        tasksNavigator.toThreadTest();
    }
    public void toCustomKeyboard(){
        tasksNavigator.toCustomKeyboard();
    }
    public void toZXing(){
        tasksNavigator.toZXing();
    }
    public void toSignTest(){
        tasksNavigator.toSignTest();
    }
    public void toFingerTest(){
        tasksNavigator.toFingerTest();
    }
    public void toFlowLayoutTest(){
        tasksNavigator.toFlowLayoutTest();
    }
    public void showDialog(){
        tasksNavigator.showDialog();
    }
    public void toPrintActivity(){
        tasksNavigator.toPrintActivity();
    }

}
