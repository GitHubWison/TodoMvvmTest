package xu.qiwei.com.todomvvmtest.blueprintv2;

import android.bluetooth.BluetoothDevice;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.example.lpc.bluetoothsdk.BluetoothSdkManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuqiwei on 17-5-11.
 */

public class BluePrinterV2ViewModel {
    private BluetoothSdkManager manager;
    private BluePrinterV2View bluePrinterV2View;
    private static final String BLUETOOTHLOGTAG = "bluetoothlogtag";
    private List<BluetoothDevice> devices;
    public BluePrinterV2ViewModel(BluePrinterV2View bluePrinterV2View) {
        this.bluePrinterV2View=bluePrinterV2View;
        devices = new ArrayList<>();
        manager = new BluetoothSdkManager(bluePrinterV2View.getActivity());
    }

    public void connectPrinter(){
        if (manager.isDiscoverying()) {
            manager.cancelDiscovery();
        }else
        {
   /*         manager.setDiscoveryDeviceListener(new DiscoveryDevicesListener() {
                @Override
                public void startDiscovery() {
                    Log.e(BLUETOOTHLOGTAG,"开始搜索蓝牙设备...");
                }

                @Override
                public void discoveryNew(BluetoothDevice device) {
//                    Toast.makeText(MainActivity.this, "发现新的蓝牙设备...", Toast.LENGTH_SHORT).show();
//                    mListDevices.add(device);
                    Log.e(BLUETOOTHLOGTAG,"发现新的蓝牙设备...");
                }

                @Override
                public void discoveryFinish(List<BluetoothDevice> list) {
                    Log.e(BLUETOOTHLOGTAG,"扫描完成..."+list.size());
                }
            });*/
            Log.e(BLUETOOTHLOGTAG,"链接打印机");
            manager.setupService();
            manager.connect("8C:DE:52:43:8C:49");
        }


    }
    public void printTxt(){
        manager.printText("可以正常打印出这句话吗？\n");
    }
    public void printPic(){
        String picPath = new StringBuffer().append(Environment.getExternalStorageDirectory().getPath())
                .append(File.separator)
                .append("imagett.png").toString();
//        读取图片
        File mFile=new File(picPath);
        //若该文件存在
        if (mFile.exists()) {
            Bitmap bitmap= BitmapFactory.decodeFile(picPath);
           manager.printImage(bitmap);
        }
    }
}
