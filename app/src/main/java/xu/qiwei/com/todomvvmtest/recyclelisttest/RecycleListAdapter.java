package xu.qiwei.com.todomvvmtest.recyclelisttest;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by xuqiwei on 17-6-1.
 */

public class RecycleListAdapter extends BaseAdapter {
    private List<View> views;

    public RecycleListAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public Object getItem(int position) {
        return views.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {

        }
        return null;
    }
}
