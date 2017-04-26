package xu.qiwei.com.todomvvmtest.fragmentdialogtest.views;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import xu.qiwei.com.todomvvmtest.databinding.FragmentTestFragmentDialogBinding;
import xu.qiwei.com.todomvvmtest.fragmentdialogtest.viewmodel.TestDialogViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragmentDialog extends DialogFragment {
    private TestDialogViewModel viewModel;
    public static TestFragmentDialog newInstance() {
        
        Bundle args = new Bundle();
        
        TestFragmentDialog fragment = new TestFragmentDialog();
        fragment.setArguments(args);
        return fragment;
    }
    public TestFragmentDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentTestFragmentDialogBinding binding = FragmentTestFragmentDialogBinding.inflate(inflater,container,false);
        binding.setViewmodel(viewModel);
        this.getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getDialog().setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void setViewModel(TestDialogViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
