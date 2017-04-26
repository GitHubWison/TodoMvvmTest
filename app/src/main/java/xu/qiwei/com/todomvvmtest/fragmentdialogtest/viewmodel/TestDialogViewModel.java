package xu.qiwei.com.todomvvmtest.fragmentdialogtest.viewmodel;

import xu.qiwei.com.todomvvmtest.TasksNavigator;

/**
 * Created by xuqiwei on 17-4-20.
 */

public class TestDialogViewModel {
    private TasksNavigator navigator;

    public TestDialogViewModel(TasksNavigator navigator) {
        this.navigator = navigator;
    }

    public void testClick()
    {
        navigator.showToast("maintest");
    }
}
