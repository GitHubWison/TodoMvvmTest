// MessageReciver.aidl
package xu.qiwei.com.todomvvmtest;
import xu.qiwei.com.todomvvmtest.mutiprocess.MessageModel;
interface MessageReciver {
    void onReciverMessage( in MessageModel messageModel);
}
