package xu.qiwei.com.todomvvmtest.flowlayout.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuqiwei on 17-4-14.
 */

public class FlowLayoutTestViewModel {
    public final ObservableList<String> items = new ObservableArrayList<>();

    public FlowLayoutTestViewModel() {
        initDatas();
    }

    private void initDatas() {
        items.clear();
        List<String> testdata = new ArrayList<>();
        testdata.add("1111111111111111111111");
        testdata.add("2222222222");
        testdata.add("33333333333333333333333333333333");
        testdata.add("44444444444444444444444444444444444444444444444");
        testdata.add("555");
        items.addAll(testdata);
    }
}
