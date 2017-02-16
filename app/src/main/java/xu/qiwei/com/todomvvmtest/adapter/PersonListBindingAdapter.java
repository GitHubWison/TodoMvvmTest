package xu.qiwei.com.todomvvmtest.adapter;

import android.databinding.BindingAdapter;
import android.widget.ListView;

import java.util.List;

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
}
