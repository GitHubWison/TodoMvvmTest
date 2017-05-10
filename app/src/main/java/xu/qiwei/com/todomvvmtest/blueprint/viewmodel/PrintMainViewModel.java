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

    /**
     * 复位打印机
     */
    public static final byte[] RESET = {0x1b, 0x40};

    /**
     * 左对齐
     */
    public static final byte[] ALIGN_LEFT = {0x1b, 0x61, 0x00};

    /**
     * 中间对齐
     */
    public static final byte[] ALIGN_CENTER = {0x1b, 0x61, 0x01};

    /**
     * 右对齐
     */
    public static final byte[] ALIGN_RIGHT = {0x1b, 0x61, 0x02};

    /**
     * 选择加粗模式
     */
    public static final byte[] BOLD = {0x1b, 0x45, 0x01};

    /**
     * 取消加粗模式
     */
    public static final byte[] BOLD_CANCEL = {0x1b, 0x45, 0x00};

    /**
     * 宽高加倍0x21
     */
    public static final byte[] DOUBLE_HEIGHT_WIDTH = {0x1d, 0x21, 0x11};
    /**
     * 取消宽高加倍
     */
    public static final byte[] CANCEL_DOUBLE_HEIGHT_WIDTH = {0x1d, 0x21, 0x00};

    /**
     * 宽加倍
     */
    public static final byte[] DOUBLE_WIDTH = {0x1d, 0x21, 0x10};

    /**
     * 高加倍
     */
    public static final byte[] DOUBLE_HEIGHT = {0x1d, 0x21, 0x01};

    /**
     * 字体不放大
     */
    public static final byte[] NORMAL = {0x1d, 0x21, 0x00};

    /**
     * 设置默认行间距
     */
    public static final byte[] LINE_SPACING_DEFAULT = {0x1b, 0x32};

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
    public void printTxtMsg(){
/*        selectCommand(BOLD);
        printText("加粗后的文字加粗后的文字加粗后的文字加粗后的文字加粗后的文字");
        selectCommand(BOLD_CANCEL);
        printText("没加粗的文字没加粗的文字没加粗的文字没加粗的文字没加粗的文字");*/
        selectCommand(DOUBLE_HEIGHT_WIDTH);


        printText("宽高加倍宽高加倍宽高加倍又加粗宽高加倍宽高加倍宽高加倍又加粗宽高加倍宽高加倍宽高加倍又加粗宽高加倍宽高加倍宽高加倍又加粗");
        selectCommand(CANCEL_DOUBLE_HEIGHT_WIDTH);
        selectCommand(BOLD_CANCEL);
        printText("取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消取消");
    }

    /**
     * 打印文字
     *
     * @param text 要打印的文字
     */
    public  void printText(String text) {
        try {
            byte[] data = text.getBytes("gbk");
            outputStream.write(data, 0, data.length);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void selectCommand(byte[] command) {
        try {
            outputStream.write(command);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
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
