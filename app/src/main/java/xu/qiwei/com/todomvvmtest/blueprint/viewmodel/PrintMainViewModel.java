package xu.qiwei.com.todomvvmtest.blueprint.viewmodel;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import xu.qiwei.com.todomvvmtest.blueprint.tools.PicPrintTool;
import xu.qiwei.com.todomvvmtest.blueprint.views.PrintMainView;

/**
 * Created by xuqiwei on 17-4-26.
 */

public class PrintMainViewModel {
    private PrintMainView printMainView;
    private OutputStream outputStream;

    final byte[][] byteCommands = { { 0x1b, 0x40 },// 复位打印机
            { 0x1b, 0x4d, 0x00 },// 标准ASCII字体
            { 0x1b, 0x4d, 0x01 },// 压缩ASCII字体
            { 0x1d, 0x21, 0x00 },// 字体不放大
            { 0x1d, 0x21, 0x11 },// 宽高加倍
            { 0x1b, 0x45, 0x00 },// 取消加粗模式
            { 0x1b, 0x45, 0x01 },// 选择加粗模式
            { 0x1b, 0x7b, 0x00 },// 取消倒置打印
            { 0x1b, 0x7b, 0x01 },// 选择倒置打印
            { 0x1d, 0x42, 0x00 },// 取消黑白反显
            { 0x1d, 0x42, 0x01 },// 选择黑白反显
            { 0x1b, 0x56, 0x00 },// 取消顺时针旋转90°
            { 0x1b, 0x56, 0x01 },// 选择顺时针旋转90°
    };
    public final ObservableField<String> buttext = new ObservableField<>("搜索蓝牙设备");

    public PrintMainViewModel(PrintMainView printMainView) {
        this.printMainView = printMainView;
    }

    //    查找蓝牙设备
    public void searchBluePrinter(View view) {
//        弹出搜索框
        printMainView.showBlueDeviceDialog();
    }

    private Bitmap getBitmapPic(){
        String picPath = new StringBuffer().append(Environment.getExternalStorageDirectory().getPath())
                .append(File.separator)
                .append("testecg.png").toString();
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
/*    public static byte[] Bitmap2Bytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }*/
    public void printMsg(View view) {
//        打印

       Bitmap bitmap = PicPrintTool.compressPic(getBitmapPic());
        Bitmap convertBitmap = PicPrintTool.adjustPhotoRotation(bitmap,90);
        byte[] data = PicPrintTool.draw2PxPoint(convertBitmap);
        try {
            outputStream.write(data, 0, data.length);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static InputStream Bitmap2IS(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        InputStream sbs = new ByteArrayInputStream(baos.toByteArray());
        return sbs;
    }
    private byte[] getBytes(InputStream is) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = 0;

        while ((len = is.read(b, 0, 1024)) != -1)
        {
            baos.write(b, 0, len);
            baos.flush();
        }
        byte[] bytes = baos.toByteArray();
        return bytes;
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
    }
}
