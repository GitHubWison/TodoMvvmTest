package xu.qiwei.com.todomvvmtest.blueprintv2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xu.qiwei.com.todomvvmtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BluePrinterV2Fragment extends Fragment {


    public BluePrinterV2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blue_printer_v2, container, false);
    }

}
