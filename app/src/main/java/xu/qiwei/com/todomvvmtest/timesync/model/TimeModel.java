package xu.qiwei.com.todomvvmtest.timesync.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xuqiwei on 17-2-28.
 */

public class TimeModel implements Parcelable{
    private String time;
//2017-02-28T08:44:30.4798729+08:00
    public TimeModel(String originalTime) {
        if (originalTime.contains(".")) {
            time = originalTime.split("[.]")[0];
        }

    }

    public TimeModel(Parcel parcel) {
        time = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(time);

    }

    public static final Parcelable.Creator<TimeModel>CREATOR = new Parcelable.Creator<TimeModel>(){

        @Override
        public TimeModel createFromParcel(Parcel parcel) {

            return new TimeModel(parcel);
        }

        @Override
        public TimeModel[] newArray(int i) {
            return new TimeModel[i];
        }
    };



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
