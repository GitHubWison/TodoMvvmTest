package xu.qiwei.com.todomvvmtest.blueprint.listadapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import xu.qiwei.com.todomvvmtest.blueprint.interfaces.DiviceAdapterListener;
import xu.qiwei.com.todomvvmtest.blueprint.listadapter.viewmodels.DiviceAdapterViewModel;
import xu.qiwei.com.todomvvmtest.blueprint.models.BlueDivice;
import xu.qiwei.com.todomvvmtest.databinding.DeviceListItemBinding;

/**
 * Created by xuqiwei on 17-4-26.
 */

public class DiviceAdapter extends BaseAdapter{
    private List<BlueDivice> divices;
    private DiviceAdapterListener diviceAdapterListener;
    public DiviceAdapter(List<BlueDivice> divices, DiviceAdapterListener diviceAdapterListener) {
        this.divices = divices;
        this.diviceAdapterListener = diviceAdapterListener;
    }

    @Override
    public int getCount() {
        return divices.size();
    }

    @Override
    public Object getItem(int i) {
        return divices.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DeviceListItemBinding deviceListItemBinding = null;
        if (view==null) {
            deviceListItemBinding = DeviceListItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false);
        }else
        {
            deviceListItemBinding = DataBindingUtil.getBinding(view);
        }
        DiviceAdapterViewModel itemViewModel = new DiviceAdapterViewModel(diviceAdapterListener);
        deviceListItemBinding.setViewmodel(itemViewModel);
        itemViewModel.setDevice(divices.get(i));
        return deviceListItemBinding.getRoot();
    }

    public void replaceData(List<BlueDivice> divices) {
        this.divices = divices;
        notifyDataSetChanged();
    }

}
