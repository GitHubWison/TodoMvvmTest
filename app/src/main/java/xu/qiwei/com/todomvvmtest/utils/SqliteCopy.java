package xu.qiwei.com.todomvvmtest.utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import xu.qiwei.com.todomvvmtest.DemoApplication;


/**
 * LuoZheng on 2016/12/15 13:11<br />
 * Email : zheng.l@medicalsystem.cn <br />
 */

public class SqliteCopy {

    private static void exportDatabse(String databaseName) {
        try {
            File data = Environment.getDataDirectory();

            if (FileManager.getInstance().getCacheDir().canWrite()) {
                String currentDBPath = "//data//"+ DemoApplication.getContext().getPackageName()+"//databases//"+databaseName+"";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(FileManager.getInstance().getCacheDir(), "/sqlite/" + databaseName);
                backupDB.getParentFile().mkdirs();
                backupDB.createNewFile();
                Log.e("backupdbpath==",backupDB.getPath());

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {

        }
    }

    public static void copySqlite(){
        exportDatabse("wisdomaid.db");
    }


}
