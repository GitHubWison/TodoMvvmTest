package xu.qiwei.com.todomvvmtest.adapter;

import android.databinding.BindingAdapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import xu.qiwei.com.todomvvmtest.blueprint.listadapter.DiviceAdapter;
import xu.qiwei.com.todomvvmtest.blueprint.models.BlueDivice;

/**
 * Created by xuqiwei on 17-2-16.
 */

public class PersonListBindingAdapter {
    @BindingAdapter("items")
    public static final void setItems(ListView listView, List<PopWindowListAdapter.Person> persons)
    {
        PopWindowListAdapter adapter = (PopWindowListAdapter)listView.getAdapter();
        if (adapter!=null) {
            adapter.replaceData(persons);
        }
    }
    @BindingAdapter("items")
    public static final void setDiviceAdapterItems(ListView listView, List<BlueDivice> divices)
    {
        DiviceAdapter adapter = (DiviceAdapter)listView.getAdapter();
        if (adapter!=null) {
            adapter.replaceData(divices);
        }
    }
    @BindingAdapter("itemCheckCommand")
    public static final void setItemCheckCommand(ListView listView, AdapterView.OnItemSelectedListener listener)
    {
        listView.setOnItemSelectedListener(listener);
    }
}
