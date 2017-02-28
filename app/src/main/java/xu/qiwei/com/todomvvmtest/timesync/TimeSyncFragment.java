package xu.qiwei.com.todomvvmtest.timesync;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xu.qiwei.com.todomvvmtest.databinding.FragmentTimeSyncBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeSyncFragment extends Fragment {
private TimeSyncViewModel viewModel;

    public static TimeSyncFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TimeSyncFragment fragment = new TimeSyncFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public TimeSyncFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTimeSyncBinding binding = FragmentTimeSyncBinding.inflate(inflater,container,false);
        binding.setViewmodel(viewModel);
        return binding.getRoot();
    }

    public void setViewModel(TimeSyncViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
