package xu.qiwei.com.todomvvmtest.autolayouttest.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xu.qiwei.com.todomvvmtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AutoHeaderFragment extends Fragment {


    public AutoHeaderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auto_header, container, false);
    }

}
