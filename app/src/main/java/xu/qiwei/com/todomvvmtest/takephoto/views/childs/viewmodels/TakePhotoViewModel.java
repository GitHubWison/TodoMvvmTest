package xu.qiwei.com.todomvvmtest.takephoto.views.childs.viewmodels;

import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;

import xu.qiwei.com.todomvvmtest.takephoto.iviews.ITakePhotoActvity;

/**
 * Created by xuqiwei on 17-6-6.
 */

public class TakePhotoViewModel  {
    private ITakePhotoActvity iTakePhotoActvity;
    public ObservableField<Drawable> photoimg = new ObservableField<>();

    public TakePhotoViewModel(ITakePhotoActvity iTakePhotoActvity) {
        this.iTakePhotoActvity = iTakePhotoActvity;
    }

    public void takePhoto(){
        iTakePhotoActvity.startTakePhoto();
    }

}
