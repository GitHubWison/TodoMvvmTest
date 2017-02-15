package xu.qiwei.com.todomvvmtest.tasks;

import java.util.UUID;

/**
 * Created by xuqiwei on 17-2-10.
 */

public class Task {
    private String title;
    private String description;
    private boolean completed;
    private String taskid;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Task(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.taskid = UUID.randomUUID().toString();
    }

    public Task(String taskid, String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.taskid = taskid;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
