package xu.qiwei.com.todomvvmtest.testpy.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xu.qiwei.com.todomvvmtest.databinding.FragmentTestOneBinding;
import xu.qiwei.com.todomvvmtest.testpy.iviews.ITestOneFragmentView;
import xu.qiwei.com.todomvvmtest.testpy.viewmodels.TestOneViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestOneFragment extends Fragment implements ITestOneFragmentView {
    
private TestOneViewModel viewModel;
    public TestOneFragment() {
        // Required empty public constructor
    }

    public static TestOneFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TestOneFragment fragment = new TestOneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentTestOneBinding binding = FragmentTestOneBinding.inflate(inflater,container,false);
        binding.setViewmodel(viewModel);
        return binding.getRoot();
    }

    public void setViewModel(TestOneViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
