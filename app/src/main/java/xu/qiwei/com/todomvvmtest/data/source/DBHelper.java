package xu.qiwei.com.todomvvmtest.data.source;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import xu.qiwei.com.todomvvmtest.data.entity.TaskEntity;

/**
 * Created by xuqiwei on 17-2-13.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String TABLE_PATH_NAME="task.db";
    private static final int TASK_TABLE_VERSION=1;
    private static final String TEXT_TYPE=" TEXT";
    private static final String BOOLEAN_TYPE = " INTEGER";
    public DBHelper(Context context) {
        super(context, TABLE_PATH_NAME, null, TASK_TABLE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+ TaskEntity.TABLE_NAME+"( "+TaskEntity.TASK_ID+TEXT_TYPE+" PRIMARY KEY , "
                +TaskEntity.TASK_TITLE+TEXT_TYPE+", "
                +TaskEntity.TASK_DESCRIPTION+TEXT_TYPE
                +", "+TaskEntity.TASK_ISCOMPLETE+BOOLEAN_TYPE+")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
