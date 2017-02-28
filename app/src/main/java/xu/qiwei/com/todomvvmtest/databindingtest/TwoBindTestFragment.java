package xu.qiwei.com.todomvvmtest.databindingtest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xu.qiwei.com.todomvvmtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoBindTestFragment extends Fragment {


    public TwoBindTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two_bind_test, container, false);
    }

}
