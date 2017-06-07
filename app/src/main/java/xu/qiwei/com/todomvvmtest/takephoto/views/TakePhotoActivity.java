package xu.qiwei.com.todomvvmtest.takephoto.views;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.databinding.ActivityTakePhotoBinding;
import xu.qiwei.com.todomvvmtest.takephoto.iviews.ITakePhotoActvity;
import xu.qiwei.com.todomvvmtest.takephoto.utils.CameraUtils;
import xu.qiwei.com.todomvvmtest.takephoto.viewmodels.TakePhotoActvityViewModel;

public class TakePhotoActivity extends Activity implements ITakePhotoActvity {
    private static final int TAKE_PHOT = 5;
    private TakePhotoActvityViewModel takePhotoActvityViewModel;
    private static final String PHOTO_IMG_PATH = Environment.getExternalStorageDirectory() + File.separator + "photopic.jpg";
    private static final String PHOTO_IMG_ZIPED_PATH = Environment.getExternalStorageDirectory() + File.separator + "photopic_ziped.jpg";
    private static final int ZIPRATE = 4;
    private ActivityTakePhotoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding =
                DataBindingUtil.setContentView(this, R.layout.activity_take_photo);
        takePhotoActvityViewModel = new TakePhotoActvityViewModel(this);
        binding.setViewmodel(takePhotoActvityViewModel);

    }


    @Override
    public void startTakePhoto() {
//        android.media.action.IMAGE_CAPTURE
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(PHOTO_IMG_PATH)));
        intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(intent, TAKE_PHOT);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOT) {
            Bitmap bitmap = BitmapFactory.decodeFile(PHOTO_IMG_PATH);
            Drawable drawable = new BitmapDrawable(getResources(), bitmap);
            takePhotoActvityViewModel.setTakePhotoPic(drawable);
            int zipedWidth = bitmap.getWidth() / ZIPRATE;
            int zipedHeight = bitmap.getHeight() / ZIPRATE;
            Bitmap zipedBitmap = CameraUtils.getBitmapBySize(PHOTO_IMG_PATH, zipedWidth, zipedHeight);
            try {
                FileOutputStream outputStream = new FileOutputStream(new File(PHOTO_IMG_ZIPED_PATH));
                zipedBitmap.compress(Bitmap.CompressFormat.WEBP, 90, outputStream);
                outputStream.flush();
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
