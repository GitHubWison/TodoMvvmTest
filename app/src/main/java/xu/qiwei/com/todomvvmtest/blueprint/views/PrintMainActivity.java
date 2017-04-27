package xu.qiwei.com.todomvvmtest.blueprint.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import xu.qiwei.com.todomvvmtest.ActivityUtils.ActivityUtils;
import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.ViewHolder;
import xu.qiwei.com.todomvvmtest.blueprint.viewmodel.BluePrintDiveceListViewModel;
import xu.qiwei.com.todomvvmtest.blueprint.viewmodel.PrintMainViewModel;
import xu.qiwei.com.todomvvmtest.databinding.ActivityPrintMainBinding;

public class PrintMainActivity extends AppCompatActivity implements PrintMainView {
    private static final String  BLUEPRINTDIVICELISTDIALOG = "BluePrintDiviceListDialog";
    private PrintMainViewModel printMainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPrintMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_print_main);
         printMainViewModel = new PrintMainViewModel(this);
        binding.setViewmodel(printMainViewModel);

    }


    @SuppressWarnings("unchecked")
    private BluePrintDiveceListViewModel findOrCreateBluePrintDiveceListVM() {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        ViewHolder<BluePrintDiveceListViewModel> viewModelViewHolder =
                (ViewHolder<BluePrintDiveceListViewModel>)fragmentManager.findFragmentByTag(BLUEPRINTDIVICELISTDIALOG);
        if (viewModelViewHolder!=null&&viewModelViewHolder.getViewModel()!=null) {

            return viewModelViewHolder.getViewModel();
        }else
        {
            BluePrintDiveceListViewModel bluePrintDiveceListViewModel =  new BluePrintDiveceListViewModel(this);
            ActivityUtils.addFragmentToActivity(fragmentManager,
                    ViewHolder.createViewModelContiner(bluePrintDiveceListViewModel),
                    BLUEPRINTDIVICELISTDIALOG);
            return bluePrintDiveceListViewModel;
        }
    }

    @Override
    public void showBlueDeviceDialog() {
        BluePrintDiviceListDialog  printDialog = BluePrintDiviceListDialog.newInstance();
        BluePrintDiveceListViewModel bluePrintDiveceListViewModel = findOrCreateBluePrintDiveceListVM();
        printDialog.setViewModel(bluePrintDiveceListViewModel,this);
            printDialog.show(getSupportFragmentManager(),"");
    }

    @Override
    public void setAddress(String diviceAddress) {
        printMainViewModel.setAddress(diviceAddress);
    }

}
