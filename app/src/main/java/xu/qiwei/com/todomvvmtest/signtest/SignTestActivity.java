package xu.qiwei.com.todomvvmtest.signtest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import xu.qiwei.com.todomvvmtest.R;

public class SignTestActivity extends AppCompatActivity {
    private Button savesign_button;
    private Button clearsign_button;
    private SignatureView signatureview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_test);
        initView();
        initEvent();
    }

    private void initView() {
        savesign_button = (Button)findViewById(R.id.savesign_button);
        signatureview = (SignatureView)findViewById(R.id.signatureview);
        clearsign_button = (Button)findViewById(R.id.clearsign_button);
    }

    private void initEvent() {
        savesign_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (signatureview.getTouched()) {
                    try {
                        File path = Environment.getExternalStorageDirectory();
                        Toast.makeText(SignTestActivity.this,path.getPath(),Toast.LENGTH_LONG).show();
                        signatureview.save(path.getPath()+"/qm.png", true, 10);
                        setResult(100);
                        finish();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(SignTestActivity.this, "您没有签名~", Toast.LENGTH_SHORT).show();
                }
            }
        });
        clearsign_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signatureview.clear();
            }
        });
    }

}
