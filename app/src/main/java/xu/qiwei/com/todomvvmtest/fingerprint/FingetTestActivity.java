package xu.qiwei.com.todomvvmtest.fingerprint;

import android.os.Bundle;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import xu.qiwei.com.todomvvmtest.R;

public class FingetTestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finget_test);
//        FingerprintManager fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
        FingerprintManagerCompat fingerprintManager = FingerprintManagerCompat.from(this);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
//            Toast.makeText(this, "no permission", Toast.LENGTH_SHORT).show();
//            return;
//        }

        if (fingerprintManager.isHardwareDetected()) {
            Toast.makeText(this, "hardwear success", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "hardwear failure", Toast.LENGTH_SHORT).show();
        }
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            boolean hasFingetprinterMod = fingerprintManager.hasEnrolledFingerprints();
//            Log.e("hasFingetprinterMod",hasFingetprinterMod?"true":"false");
//            return;
//        }

    }
}
