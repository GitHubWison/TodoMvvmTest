package xu.qiwei.com.todomvvmtest.takephoto.views.childs.viewmodels;

import android.databinding.ObservableField;
import android.view.animation.Animation;

import xu.qiwei.com.todomvvmtest.takephoto.iviews.ITakePhotoActvity;

/**
 * Created by xuqiwei on 17-6-6.
 */

public class SignNameViewModel {
    private ITakePhotoActvity takePhotoActvity;
    public final ObservableField<Animation> animation = new ObservableField<>();


    public SignNameViewModel(ITakePhotoActvity takePhotoActvity) {
        this.takePhotoActvity = takePhotoActvity;
    }
}
