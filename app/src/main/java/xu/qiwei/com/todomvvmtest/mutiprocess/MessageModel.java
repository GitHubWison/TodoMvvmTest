package xu.qiwei.com.todomvvmtest.mutiprocess;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xuqiwei on 17-6-26.
 */

public class MessageModel implements Parcelable {
    private String from;
    private String to;
    private String content;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.from);
        dest.writeString(this.to);
        dest.writeString(this.content);
    }

    public MessageModel() {
    }

    protected MessageModel(Parcel in) {
        this.from = in.readString();
        this.to = in.readString();
        this.content = in.readString();
    }
    

    public static final Parcelable.Creator<MessageModel> CREATOR = new Parcelable.Creator<MessageModel>() {
        public MessageModel createFromParcel(Parcel source) {
            return new MessageModel(source);
        }

        public MessageModel[] newArray(int size) {
            return new MessageModel[size];
        }
    };

    @Override
    public String toString() {

        return "from="+from+"**to="+to+"**content="+content;

    }
}
