package xu.qiwei.com.todomvvmtest.flowlayout.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xu.qiwei.com.todomvvmtest.databinding.FragmentFlowLayoutTestBinding;
import xu.qiwei.com.todomvvmtest.flowlayout.viewmodel.FlowLayoutTestViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlowLayoutTestFragment extends Fragment {
    private FlowLayoutTestViewModel viewModel;
    private   FragmentFlowLayoutTestBinding binding;
    public static FlowLayoutTestFragment newInstance() {
        
        Bundle args = new Bundle();
        
        FlowLayoutTestFragment fragment = new FlowLayoutTestFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public FlowLayoutTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         binding = FragmentFlowLayoutTestBinding.inflate(inflater,container,false);
        binding.setViewmodel(viewModel);

        return binding.getRoot();
    }


    public void setViewModel(FlowLayoutTestViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
