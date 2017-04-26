package xu.qiwei.com.todomvvmtest.blueprint.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import xu.qiwei.com.todomvvmtest.blueprint.listadapter.DiviceAdapter;
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
    public final AdapterView.OnItemSelectedListener listSelectListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            DiviceAdapter adapter = (DiviceAdapter)adapterView.getAdapter();
            BlueDivice divice = (BlueDivice)adapter.getItem(i);
            printMainView.setAddress(divice.getDiviceAddress());

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
////////////////////事件/////////////////////

    public void setBlueDivices(List<BlueDivice> blueDivices) {
        blueprintlist.clear();
        if (blueDivices != null) {
            blueprintlist.addAll(blueDivices);
        }

    }
}
