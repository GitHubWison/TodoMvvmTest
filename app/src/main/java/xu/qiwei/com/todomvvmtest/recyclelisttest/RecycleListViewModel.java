package xu.qiwei.com.todomvvmtest.recyclelisttest;

import android.databinding.ObservableField;

import xu.qiwei.com.todomvvmtest.recyclelisttest.childs.viewmodels.RecycleViewModel1;
import xu.qiwei.com.todomvvmtest.recyclelisttest.childs.viewmodels.RecycleViewModel2;
import xu.qiwei.com.todomvvmtest.recyclelisttest.childs.viewmodels.RecycleViewModel3;

/**
 * Created by xuqiwei on 17-6-1.
 */

public class RecycleListViewModel {
    private RecycleListMainView recycleListMainView;
    public final ObservableField<RecycleViewModel1> recyclevmone = new ObservableField<>();
    public final ObservableField<RecycleViewModel2> recyclevmtwo = new ObservableField<>();
    public final ObservableField<RecycleViewModel3> recyclevmthree = new ObservableField<>();

    public RecycleListViewModel(RecycleListMainView recycleListMainView) {
        this.recycleListMainView = recycleListMainView;
        initChildViewModels(recycleListMainView);
    }

    private void initChildViewModels(RecycleListMainView recycleListMainView) {
        recyclevmone.set(new RecycleViewModel1(recycleListMainView));
        recyclevmtwo.set(new RecycleViewModel2(recycleListMainView));
        recyclevmthree.set(new RecycleViewModel3(recycleListMainView));
    }
}
