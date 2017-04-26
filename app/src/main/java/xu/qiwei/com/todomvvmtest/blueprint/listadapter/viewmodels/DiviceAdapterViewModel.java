package xu.qiwei.com.todomvvmtest.blueprint.listadapter.viewmodels;

import android.databinding.Observable;
import android.databinding.ObservableField;
import android.view.View;

import xu.qiwei.com.todomvvmtest.blueprint.interfaces.DiviceAdapterListener;
import xu.qiwei.com.todomvvmtest.blueprint.models.BlueDivice;

/**
 * Created by xuqiwei on 17-4-26.
 */

public class DiviceAdapterViewModel {
    private DiviceAdapterListener diviceAdapterListener;
    public final ObservableField<String> bluetoothname = new ObservableField<>();
    public final ObservableField<String> bluetoothaddr = new ObservableField<>();
    public final ObservableField<String> bluetoothbinded = new ObservableField<>();

    public final ObservableField<BlueDivice> bluedivice = new ObservableField<>();


    public DiviceAdapterViewModel(DiviceAdapterListener diviceAdapterListener) {
        this.diviceAdapterListener= diviceAdapterListener;
        bluedivice.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                bluetoothaddr.set(bluedivice.get().getDiviceAddress());
                bluetoothname.set(bluedivice.get().getDiviceName());
                bluetoothbinded.set(bluedivice.get().isBind()?"已绑定":"未绑定");
            }
        });
    }

    public void setDevice(BlueDivice blueDivice) {
        bluedivice.set(blueDivice);
    }
    public void onAdapterItemClick(View view)
    {
        diviceAdapterListener.onDiviceClick(bluedivice.get());
    }
}
