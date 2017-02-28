package xu.qiwei.com.todomvvmtest.timesync.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import xu.qiwei.com.todomvvmtest.timesync.model.TimeModel;

public class TimeSyncService extends Service {
    private static final long SPACE_SEC = 3000;

    public TimeSyncService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TimeSyncService", "onStartCommand");
//        执行耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                String time = "";
                try {
                    URL url = new URL("http://172.16.23.14:4500/api/Public/GetCurrentTime");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(8000);
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Authorization","Basic TWRzZC5QaGVwLkFwaTptZHNkLnBoZXAuYXBpLjIwMDUk");
                    connection.setRequestProperty("Accept","application/json");
                    connection.setRequestProperty("UserName","amp6eDE=");
                    connection.setRequestProperty("LoginName","amp6eDE=");
                    connection.setRequestProperty("RequestSource","VmVoaWNsZUFwcA==");
                    connection.setRequestProperty("Content-Type","application/json; charset=utf-8");

                    InputStream inputStream = connection.getInputStream();
                    String line;
                    StringBuffer buffer = new StringBuffer();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }
                    time = buffer.toString();
//                    Gson gson = new Gson();
                    JsonObject timeJson = new JsonParser().parse(time).getAsJsonObject();
                    String timeString = timeJson.get("data").getAsString();
                    TimeModel timeModel = new TimeModel(timeString);
                    Intent intent = new Intent("com.xu.test.timesysnc");
                    intent.putExtra("SyncTime", timeModel);
                    LocalBroadcastManager manager = LocalBroadcastManager.getInstance(TimeSyncService.this);
                    manager.sendBroadcast(intent);

//                    TimeSyncService.this.sendBroadcast(intent);

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }

            }
        }).start();
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long triggerTime = SystemClock.elapsedRealtime() + SPACE_SEC;
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(this, TimeSyncBroadCast.class), 0);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, pendingIntent);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
