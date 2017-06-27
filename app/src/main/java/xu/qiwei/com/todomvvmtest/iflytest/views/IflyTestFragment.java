package xu.qiwei.com.todomvvmtest.iflytest.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xu.qiwei.com.iflyvoice.Dictation;
import xu.qiwei.com.todomvvmtest.databinding.FragmentIflyTestBinding;
import xu.qiwei.com.todomvvmtest.iflytest.iviews.IIflyTestFragmentView;
import xu.qiwei.com.todomvvmtest.iflytest.viewmodels.IflyTestViewModel;

public class IflyTestFragment extends Fragment implements IIflyTestFragmentView {
private IflyTestViewModel viewModel;
    public IflyTestFragment() {
        // Required empty public constructor
    }

    public static IflyTestFragment newInstance() {
        
        Bundle args = new Bundle();
        
        IflyTestFragment fragment = new IflyTestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentIflyTestBinding binding = FragmentIflyTestBinding.inflate(inflater,container,false);
        binding.setViewmodel(viewModel);
        return binding.getRoot();
    }

    public void setViewModel(IflyTestViewModel viewModel, Context context) {
        this.viewModel = viewModel;
        this.viewModel.setDiction(Dictation.getInstance().init(context));
    }
}
