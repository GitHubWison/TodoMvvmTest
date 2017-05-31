package xu.qiwei.com.todomvvmtest.blueprintv2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.databinding.ActivityBluePrinterV2Binding;

public class BluePrinterV2Activity extends AppCompatActivity implements BluePrinterV2View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBluePrinterV2Binding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_blue_printer_v2);
        binding.setViewmodel(new BluePrinterV2ViewModel(this));
    }

    @Override
    public BluePrinterV2Activity getActivity() {
        return this;
    }
}
