package xu.qiwei.com.todomvvmtest;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

import xu.qiwei.com.todomvvmtest.tasks.TasksListViewModel;

/**
 * Created by xuqiwei on 17-2-10.
 */

public class SwipeRefreshLayoutAdapter {
    @BindingAdapter("onRefresh")
    public static final void setOnRefreshListener(SwipeRefreshLayout swipeRefreshLayout, final TasksListViewModel tasksListViewModel)
    {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tasksListViewModel.onpageRefresh();
            }
        });
    }
    @BindingAdapter("refreshing")
    public static final void setIsRefreshing(SwipeRefreshLayout swipeRefreshLayout,boolean isRefresh){
        swipeRefreshLayout.setRefreshing(isRefresh);
    }
}
