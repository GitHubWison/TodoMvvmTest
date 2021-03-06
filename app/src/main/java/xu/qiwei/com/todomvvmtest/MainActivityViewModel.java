package xu.qiwei.com.todomvvmtest;

import xu.qiwei.com.todomvvmtest.utils.SqliteCopy;

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
    public void toAutoLayoutActivity(){
        tasksNavigator.toAutoLayoutActivity();
    }
    public void toBluePrintV2Activity(){
        tasksNavigator.toBluePrintV2Activity();
    }
    public void toLoadActivity(){
        tasksNavigator.toLoadActivity();
    }
    public void toShowTest(){
        tasksNavigator.toShowTest();
    }
    public void tofragmentless(){
        tasksNavigator.tofragmentless();
    }
    public void toVLayoutTest(){
        tasksNavigator.toVLayoutTest();
    }
    public void toTakePhoto(){
        tasksNavigator.toTakePhoto();
    }
    public void copySqlite(){
        SqliteCopy.copySqlite();
    }
    public void toIFly(){
        tasksNavigator.toIFly();
    }
    public void toMutiProcess(){
        tasksNavigator.toMutiProcess();
    }

}
