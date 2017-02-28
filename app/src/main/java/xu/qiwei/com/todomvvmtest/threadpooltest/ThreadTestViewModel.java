package xu.qiwei.com.todomvvmtest.threadpooltest;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Dex.XU on 2017/2/28.
 */

public class ThreadTestViewModel {
    private ThreadTestView mView;

    public ThreadTestViewModel(ThreadTestView view) {
        this.mView = view;
    }
    public void getData(){
        startAThread();
    }
    private void startAThread(){
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute( new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api.douban.com/v2/movie/in_theaters");
                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    connection.setConnectTimeout(8000);
                    connection.setRequestMethod("GET");
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    StringBuffer sb = new StringBuffer();
                    if ((line = reader.readLine())!=null) {
                        sb.append(line);
                    }
                    Log.e("resultdata=", Thread.currentThread().getName()+"");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
