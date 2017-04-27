package xu.qiwei.com.todomvvmtest.blueprint.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import java.util.List;

import xu.qiwei.com.todomvvmtest.blueprint.models.BlueDivice;
import xu.qiwei.com.todomvvmtest.blueprint.views.PrintMainView;

/**
 * Created by xuqiwei on 17-4-26.
 */

public class BluePrintDiveceListViewModel {
    private PrintMainView printMainView;
    public BluePrintDiveceListViewModel(PrintMainView printMainView) {
        this.printMainView =printMainView;
    }

    public final ObservableList<BlueDivice> blueprintlist = new ObservableArrayList<>();
    ////////////////////事件/////////////////////
////////////////////事件/////////////////////

    public void setBlueDivices(List<BlueDivice> blueDivices) {
        blueprintlist.clear();
        if (blueDivices != null) {
            blueprintlist.addAll(blueDivices);
        }

    }
}
