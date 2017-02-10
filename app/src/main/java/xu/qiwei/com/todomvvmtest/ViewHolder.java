package xu.qiwei.com.todomvvmtest;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Created by xuqiwei on 17-2-10.
 */

public class ViewHolder<VM> extends Fragment{
    private VM viewModel;
    public static <VM> ViewHolder createViewModelContiner(@NonNull VM viewModel){
        ViewHolder<VM> viewHolder = new ViewHolder<>();
        viewHolder.setViewModel(viewModel);
        return viewHolder;
    }

    public VM getViewModel() {
        return viewModel;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
    }
}
