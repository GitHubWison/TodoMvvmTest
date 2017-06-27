package xu.qiwei.com.todomvvmtest.mutiprocess;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import xu.qiwei.com.todomvvmtest.MessageReciver;
import xu.qiwei.com.todomvvmtest.MessageSender;
import xu.qiwei.com.todomvvmtest.R;

public class ProcessActivity extends AppCompatActivity {
    private MessageSender messageSender;
//    private IBinder mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        setService();
    }

    private void setService() {
        Intent serviceIntent = new Intent(this,MessageService.class);
        bindService(serviceIntent,serviceConnection,BIND_AUTO_CREATE);
        startService(serviceIntent);

    }
//    消息监听回调
MessageReciver messageReciver = new MessageReciver.Stub(){

    @Override
    public void onReciverMessage(MessageModel messageModel) throws RemoteException {
        Log.e("ServiceConnection","onReciverMessage="+messageModel.toString());
    }
};
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("ServiceConnection","onServiceConnected");
            messageSender=MessageSender.Stub.asInterface(service);
            MessageModel messageModel = new MessageModel();
            messageModel.setFrom("client user id");
            messageModel.setTo("reciver user id");
            messageModel.setContent("this is a message");
            try {
                messageSender.sendMessage(messageModel);
                messageSender.registerMessageReciver(messageReciver);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("ServiceConnection","onServiceDisconnected");

        }
    };
    public void sendMsg(View view)
    {


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            messageSender.unregisterMessageReciver(messageReciver);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        unbindService(serviceConnection);
    }
}
