package xu.qiwei.com.todomvvmtest.autolayouttest.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.autolayouttest.viewmodels.AutoLayoutViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AutoLayoutFragment extends Fragment {
private AutoLayoutViewModel viewModel;
    public static AutoLayoutFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AutoLayoutFragment fragment = new AutoLayoutFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public AutoLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ActivityUtils.addFragmentToActivity(getActivity().getSupportFragmentManager(),R.id.auto_main_framelayout,new AutoMainFragment());
        ActivityUtils.addFragmentToActivity(getActivity().getSupportFragmentManager(),R.id.auto_header_framelayout, new AutoHeaderFragment());
        return inflater.inflate(R.layout.fragment_auto_layout, container, false);
    }

    public void setViewModel(AutoLayoutViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
