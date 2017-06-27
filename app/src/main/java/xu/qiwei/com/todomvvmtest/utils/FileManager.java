package xu.qiwei.com.todomvvmtest.utils;

import android.os.Environment;

import java.io.File;

import xu.qiwei.com.todomvvmtest.DemoApplication;

/**
 * LuoZheng on 2016/12/19 13:35<br />
 * Email : zheng.l@medicalsystem.cn <br />
 */
public class FileManager {
    private static FileManager ourInstance = new FileManager();
    private File cacheDir;

    public static FileManager getInstance() {
        return ourInstance;
    }

    private FileManager() {
    }

    public File getCacheDir(){
        if(cacheDir == null){
            cacheDir = new File(Environment.getExternalStorageDirectory(),//
                    DemoApplication.getContext().getPackageName());
        }
        if(!cacheDir.exists()){
            cacheDir.mkdirs();
        }
        return cacheDir;
    }
}
