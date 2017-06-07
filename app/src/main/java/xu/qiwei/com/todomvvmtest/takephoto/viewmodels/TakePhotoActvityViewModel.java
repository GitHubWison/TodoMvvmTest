package xu.qiwei.com.todomvvmtest.takephoto.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.view.View;

import xu.qiwei.com.todomvvmtest.BR;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.takephoto.iviews.ITakePhotoActvity;
import xu.qiwei.com.todomvvmtest.takephoto.views.childs.viewmodels.SignNameViewModel;
import xu.qiwei.com.todomvvmtest.takephoto.views.childs.viewmodels.TakePhotoViewModel;

/**
 * Created by xuqiwei on 17-6-6.
 */

public class TakePhotoActvityViewModel extends BaseObservable {


    private ITakePhotoActvity iTakePhotoActvity;
    public final ObservableField<TakePhotoViewModel> viewmodel = new ObservableField<>();
    public final ObservableField<SignNameViewModel> signnamevm = new ObservableField<>();
    public final ObservableInt signvis = new ObservableInt(View.VISIBLE);
    public final ObservableInt takephotovis = new ObservableInt(View.GONE);
    private int checkmod = R.id.sign_radiobutton;

    @Bindable
    public int getCheckmod() {
        return checkmod;
    }

    public void setCheckmod(int checkmod) {
        this.checkmod = checkmod;
        notifyPropertyChanged(BR.checkmod);
        if (checkmod == R.id.sign_radiobutton) {
            showSign();
        }
        if (checkmod == R.id.photo_radiobutton) {
            showTakePhoto();
        }

    }

    public TakePhotoActvityViewModel(ITakePhotoActvity iTakePhotoActvity) {
        this.iTakePhotoActvity = iTakePhotoActvity;
        initDatas();
        initChildViews();
    }

    public ObservableField<TakePhotoViewModel> getTakePhotoViewmodel() {
        return viewmodel;
    }

    public ObservableField<SignNameViewModel> getSignnamevm() {
        return signnamevm;
    }

    private void initDatas() {

    }

    private void initChildViews() {
        viewmodel.set(new TakePhotoViewModel(iTakePhotoActvity));
        signnamevm.set(new SignNameViewModel(iTakePhotoActvity));
    }

    public void setTakePhotoPic(Drawable drawable) {
        viewmodel.get().photoimg.set(drawable);
    }

    public void showSign() {
        signvis.set(View.VISIBLE);
        takephotovis.set(View.GONE);
    }

    public void showTakePhoto() {
        takephotovis.set(View.VISIBLE);
        signvis.set(View.GONE);
    }
}
