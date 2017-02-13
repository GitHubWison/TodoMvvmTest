package xu.qiwei.com.todomvvmtest.data.source;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import xu.qiwei.com.todomvvmtest.data.entity.TaskEntity;
import xu.qiwei.com.todomvvmtest.tasks.Task;

import static com.google.common.base.Preconditions.checkNotNull;
import static xu.qiwei.com.todomvvmtest.data.entity.TaskEntity.TASK_ISCOMPLETE;

/**
 * Created by xuqiwei on 17-2-13.
 */

public class LocalSourceData implements SourceData{
    private static LocalSourceData INSTANCE;
    private  DBHelper db ;

    public LocalSourceData(Context context) {
        checkNotNull(context);
        db = new DBHelper(context);
    }

    public static LocalSourceData getInstance(Context context) {
        if (INSTANCE==null) {
            INSTANCE = new LocalSourceData(context);
        }
        return INSTANCE;
    }

    @Override
    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query(TaskEntity.TABLE_NAME,new String[]{TaskEntity.TASK_TITLE,TaskEntity.TASK_DESCRIPTION, TASK_ISCOMPLETE},null,null,null,null,null);
        while (c.moveToNext()){
            String title = c.getString(c.getColumnIndexOrThrow(TaskEntity.TASK_TITLE));
            String desc = c.getString(c.getColumnIndexOrThrow(TaskEntity.TASK_DESCRIPTION));
            boolean iscomplete = c.getInt(c.getColumnIndexOrThrow(TaskEntity.TASK_ISCOMPLETE))==1;
            Task temp = new Task(title,desc,iscomplete);
            tasks.add(temp);
        }
        if (c!=null) {
            c.close();
        }
        database.close();
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues cont = new ContentValues();
        cont.put(TaskEntity.TASK_TITLE,task.getTitle());
        cont.put(TaskEntity.TASK_DESCRIPTION,task.getDescription());
        cont.put(TaskEntity.TASK_ISCOMPLETE,task.isCompleted());

        database.insert(TaskEntity.TABLE_NAME,null,cont);
        database.close();
    }
}
