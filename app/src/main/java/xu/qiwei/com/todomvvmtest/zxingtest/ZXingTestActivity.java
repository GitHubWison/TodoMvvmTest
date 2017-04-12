package xu.qiwei.com.todomvvmtest.zxingtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import xu.qiwei.com.todomvvmtest.PermissionAdapter;
import xu.qiwei.com.todomvvmtest.PermissionVerifyCallBack;
import xu.qiwei.com.todomvvmtest.R;

public class ZXingTestActivity extends AppCompatActivity {
private Button zxing_button;
    private static final int REQUEST_CODE = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing_test);
        initViews();
        initEventes();
    }

    private void initEventes() {
        zxing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionAdapter.getInstance().camera(ZXingTestActivity.this, new PermissionVerifyCallBack() {
                    @Override
                    public void onGet() {
                        Intent intent = new Intent(ZXingTestActivity.this, CaptureCusActivity.class);
                        startActivityForResult(intent, REQUEST_CODE);
                    }

                    @Override
                    public void onLost() {

                    }
                });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(ZXingTestActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void initViews() {
        zxing_button = (Button)findViewById(R.id.zxing_button);
    }
}
