package xu.qiwei.com.todomvvmtest.mutiprocess;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import xu.qiwei.com.todomvvmtest.MessageReciver;
import xu.qiwei.com.todomvvmtest.MessageSender;

public class MessageService extends Service {
    private RemoteCallbackList<MessageReciver> reciverRemoteCallbackList = new RemoteCallbackList<>();
    public MessageService() {

    }

    IBinder messageSender = new MessageSender.Stub(){

        @Override
        public void sendMessage(MessageModel messageModel) throws RemoteException {
            Log.e("MessageService=","start send msg="+messageModel.toString());
        }

        @Override
        public void registerMessageReciver(MessageReciver messageReciver) throws RemoteException {
            reciverRemoteCallbackList.register(messageReciver);
        }

        @Override
        public void unregisterMessageReciver(MessageReciver messageReciver) throws RemoteException {
            reciverRemoteCallbackList.unregister(messageReciver);
        }

    };

    @Override
    public void onCreate() {
        super.onCreate();
//        new LongConnect().pos?.run();
//        模拟服务端推送信息
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                int listCount = reciverRemoteCallbackList.beginBroadcast();
                for (int i = 0; i < listCount; i++) {
                    MessageModel messageModel = new MessageModel();
                    messageModel.setContent("count"+i);
                    messageModel.setFrom("server"+i);
                    messageModel.setTo("client"+1);
                    MessageReciver messageReciver = reciverRemoteCallbackList.getBroadcastItem(i);
                    try {
                        messageReciver.onReciverMessage(messageModel);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                reciverRemoteCallbackList.finishBroadcast();
            }
        },5000);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return messageSender;
    }

}
