package xu.qiwei.com.todomvvmtest.blueprint.views;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xu.qiwei.com.todomvvmtest.blueprint.interfaces.BlueToothListener;
import xu.qiwei.com.todomvvmtest.blueprint.interfaces.DiviceAdapterListener;
import xu.qiwei.com.todomvvmtest.blueprint.listadapter.DiviceAdapter;
import xu.qiwei.com.todomvvmtest.blueprint.models.BlueDivice;
import xu.qiwei.com.todomvvmtest.blueprint.receiver.BlueToothBroadcastReceiver;
import xu.qiwei.com.todomvvmtest.blueprint.viewmodel.BluePrintDiveceListViewModel;
import xu.qiwei.com.todomvvmtest.databinding.DialogBlueprintdiviceBinding;

/**
 * Created by xuqiwei on 17-4-26.
 */

public class BluePrintDiviceListDialog extends DialogFragment implements BlueToothListener, DiviceAdapterListener {
    private BluePrintDiveceListViewModel viewModel;
    private DialogBlueprintdiviceBinding binding;
    private BluetoothAdapter bluetoothAdapter;
    private BlueToothBroadcastReceiver blueToothBroadcastReceiver;
    private PrintMainView printMainView;


    public static BluePrintDiviceListDialog newInstance() {
        Bundle args = new Bundle();
        BluePrintDiviceListDialog fragment = new BluePrintDiviceListDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogBlueprintdiviceBinding.inflate(inflater, container, false);
        binding.setViewmodel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setAdapter();
        //        设置蓝牙接收,注册蓝牙
        setBlueToothReceive();
//        检测蓝牙
        searchBluetooth();
//
    }

    private void setBlueToothReceive() {
        if (blueToothBroadcastReceiver == null) {
            blueToothBroadcastReceiver = new BlueToothBroadcastReceiver(this);
        }
        // 设置广播信息过滤
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        // 注册广播接收器，接收并处理搜索结果
        getContext().registerReceiver(blueToothBroadcastReceiver, intentFilter);
    }

    private void searchBluetooth() {
        if (bluetoothAdapter == null) {
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        bluetoothAdapter.startDiscovery();
    }

    private void setAdapter() {
        binding.diviceListview.setAdapter(new DiviceAdapter(new ArrayList<BlueDivice>(0),this));
    }

    public void setViewModel(BluePrintDiveceListViewModel viewModel,PrintMainView printMainView) {
        this.viewModel = viewModel;
        this.printMainView = printMainView;
    }

    @Override
    public void devicesListCallBack(List<BlueDivice> blueDivices) {
        if (viewModel != null) {
            viewModel.setBlueDivices(blueDivices);
        }
        if (blueToothBroadcastReceiver != null) {
            getContext().unregisterReceiver(blueToothBroadcastReceiver);
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (blueToothBroadcastReceiver != null) {
            getContext().unregisterReceiver(blueToothBroadcastReceiver);
        }
    }

    @Override
    public void onDiviceClick(BlueDivice blueDivice) {
//
        printMainView.setAddress(blueDivice.getDiviceAddress());
    }
}
