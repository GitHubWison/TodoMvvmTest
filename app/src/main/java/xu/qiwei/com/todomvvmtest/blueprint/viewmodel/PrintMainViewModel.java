package xu.qiwei.com.todomvvmtest.blueprint.viewmodel;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.google.common.cache.LoadingCache;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import xu.qiwei.com.todomvvmtest.DemoApplication;
import xu.qiwei.com.todomvvmtest.blueprint.tools.PicPrintTool;
import xu.qiwei.com.todomvvmtest.blueprint.views.PrintMainView;
import xu.qiwei.com.todomvvmtest.utils.SharedPrefsUtils;

/**
 * Created by xuqiwei on 17-4-26.
 */

public class PrintMainViewModel {
    private PrintMainView printMainView;
    private OutputStream outputStream;
    private static final String BLUETOOTHADDRESSNAME = "blueToothAddressname";
    private LoadingCache<String, String> cachebuilder;
    public final ObservableField<String> buttext = new ObservableField<>("搜索蓝牙设备");
    public final ObservableField<Drawable> beforezoom = new ObservableField<>();
public final ObservableField<Drawable> afterzoom = new ObservableField<>();
    public final ObservableField<Drawable> afterzoom2 = new ObservableField<>();

    public PrintMainViewModel(PrintMainView printMainView)  {
        this.printMainView = printMainView;
        try {
            initData();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void initData() throws ExecutionException {
        String name = SharedPrefsUtils.getStringPreference(DemoApplication.getContext(),BLUETOOTHADDRESSNAME);
        buttext.set(name);
    }

    //    查找蓝牙设备
    public void searchBluePrinter(View view) {
//        弹出搜索框
        printMainView.showBlueDeviceDialog();
    }

    private Bitmap getBitmapPic(){
        String picPath = new StringBuffer().append(Environment.getExternalStorageDirectory().getPath())
                .append(File.separator)
                .append("testecg3.png").toString();
//        读取图片
        File mFile=new File(picPath);
        //若该文件存在
        if (mFile.exists()) {
            Bitmap bitmap= BitmapFactory.decodeFile(picPath);
            return bitmap;
        }else
        {
            return null;
        }
    }
    public void printMsg(View view) {
//        打印
/*        String picPath = new StringBuffer().append(Environment.getExternalStorageDirectory().getPath())
                .append(File.separator)
                .append("testecg3.png").toString();*/
//       Bitmap bitmap = PicPrintTool.compressPic(getBitmapPic());
/*        Bitmap convertBitmap =  PicPrintTool.zoomImg(PicPrintTool.adjustPhotoRotation(bitmap,90),600) ;
        beforezoom.set(new BitmapDrawable(DemoApplication.getContext().getResources(),bitmap));

        afterzoom.set(new BitmapDrawable(DemoApplication.getContext().getResources(),convertBitmap))*/;
        Bitmap allBitMap = PicPrintTool.adjustPhotoRotation(getBitmapPic(),90);
        int allBitMapWidth = allBitMap.getWidth();
        int allBitMapHeight = allBitMap.getHeight();
        Bitmap cutbitmap =  Bitmap.createBitmap(allBitMap,0,0,allBitMapWidth,allBitMapHeight/4);

/*                beforezoom.set(new BitmapDrawable(DemoApplication.getContext().getResources(),allBitMap));
        afterzoom.set(new BitmapDrawable(DemoApplication.getContext().getResources(), PicPrintTool.compressPic(getBitmapPic())));
        Bitmap zoom2bitmap = PicPrintTool.getSmallBitmap(picPath);
        Log.e("zoom2bitmapwidth",zoom2bitmap.getWidth()+"");
        Log.e("zoom2bitmapheight",zoom2bitmap.getHeight()+"");
        afterzoom2.set(new BitmapDrawable(DemoApplication.getContext().getResources(), cutbitmap));*/
//        Bitmap convertBitmap =PicPrintTool.adjustPhotoRotation(PicPrintTool.adjustPhotoRotation( PicPrintTool.adjustPhotoRotation(bitmap,90),90),90)  ;


//        beforezoom.set(new BitmapDrawable(DemoApplication.getContext().getResources(),allBitMap));
//        afterzoom2.set(new BitmapDrawable(DemoApplication.getContext().getResources(), allBitMap));
        byte[] data = PicPrintTool.draw2PxPoint(PicPrintTool.zoomImg(allBitMap,560));
        try {
            outputStream.write(data, 0, data.length);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void connectPrinter(View view) {
//        连接蓝牙设备
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        String bluetoothaddress = buttext.get();
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(bluetoothaddress);
        Log.e("bluuuuuu", bluetoothaddress);
        try {
            BluetoothSocket bluetoothSocket = device.createRfcommSocketToServiceRecord(UUID
                    .fromString("00001101-0000-1000-8000-00805F9B34FB"));
            bluetoothSocket.connect();
            outputStream = bluetoothSocket.getOutputStream();
            if (bluetoothAdapter.isDiscovering()) {
                bluetoothAdapter.isDiscovering();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("bluuuuuu", "连接失败");
        }
        Log.e("bluuuuuu", "连接成功");


    }

    public void setAddress(String diviceAddress) {
        buttext.set(diviceAddress);
        SharedPrefsUtils.setStringPreference(DemoApplication.getContext(),BLUETOOTHADDRESSNAME,diviceAddress);
    }
}
