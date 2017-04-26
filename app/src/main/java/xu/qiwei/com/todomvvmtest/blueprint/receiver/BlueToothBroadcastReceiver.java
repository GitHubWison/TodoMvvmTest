package xu.qiwei.com.todomvvmtest.blueprint.receiver;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import xu.qiwei.com.todomvvmtest.blueprint.interfaces.BlueToothListener;
import xu.qiwei.com.todomvvmtest.blueprint.models.BlueDivice;

/**
 * Created by xuqiwei on 17-4-26.
 */

public class BlueToothBroadcastReceiver extends BroadcastReceiver {
    private BlueToothListener listener;

    private List<BlueDivice> blueDivices;

    public BlueToothBroadcastReceiver(BlueToothListener listener) {
        this.listener = listener;

        blueDivices = new ArrayList<>();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            Log.e("bluuuuuu","找到蓝牙");
//            搜索蓝牙设备并添加
            BluetoothDevice device = intent
                    .getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            boolean isBinded = device.getBondState() == BluetoothDevice.BOND_BONDED;
            BlueDivice blueDivice = new BlueDivice(device.getName(), device.getAddress(), isBinded);
            blueDivices.add(blueDivice);
        } else if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
//正在搜索蓝牙设备
            Log.e("bluuuuuu","正在搜索蓝牙设备");
        } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED
                .equals(action)) {
            Log.e("bluuuuuu","设备搜索完毕");
//            设备搜索完毕
//            添加已经绑定和未绑定的设备
            listener.devicesListCallBack(blueDivices);

        }
    }
}
