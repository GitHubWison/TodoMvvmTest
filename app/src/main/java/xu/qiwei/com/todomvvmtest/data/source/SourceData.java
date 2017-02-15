package xu.qiwei.com.todomvvmtest.data.source;

import java.util.List;

import xu.qiwei.com.todomvvmtest.tasks.Task;

/**
 * Created by xuqiwei on 17-2-13.
 */

public interface SourceData {
    public List<Task> getTasks();
    public void addTask(Task task);
    public void completeTask(Task task);
    public void activedTask(Task task);

}
