package xu.qiwei.com.todomvvmtest.testttr.bindadapter;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.ViewGroup;

import xu.qiwei.com.todomvvmtest.testttr.interfacess.ViewWithViewModel;

/**
 * Created by xuqiwei on 17-6-1.
 */

public class ViewAdapter {
    @BindingAdapter(requireAll = false ,value = "viewmodel")
    public static final void setViewModel(ViewGroup viewGroup,Object viewModel)
    {
        if (viewGroup instanceof ViewWithViewModel) {
            ViewWithViewModel viewWithViewModel = (ViewWithViewModel)viewGroup;
            viewWithViewModel.setViewModel(viewModel);
            Log.e("tttttttt","viewWithViewModel setted");
        }else
        {
            Log.e("tttttttt","viewWithViewModel not setted");
        }
    }
}
/* @BindingAdapter("items")
    public static final void setDiviceAdapterItems(ListView listView, List<BlueDivice> divices)
    {
        DiviceAdapter adapter = (DiviceAdapter)listView.getAdapter();
        if (adapter!=null) {
            adapter.replaceData(divices);
        }
    }*/