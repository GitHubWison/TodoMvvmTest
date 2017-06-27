// MessageSender.aidl
package xu.qiwei.com.todomvvmtest;
import xu.qiwei.com.todomvvmtest.MessageReciver;
//import xu.qiwei.com.todomvvmtest.mutiprocess.MessageModel;
import xu.qiwei.com.todomvvmtest.mutiprocess.MessageModel;
interface MessageSender {
    void sendMessage(in MessageModel messageModel);
    void registerMessageReciver(MessageReciver messageReciver);
    void unregisterMessageReciver(MessageReciver messageReciver);
}
