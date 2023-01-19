package UTSSG.ZQDesigned.Characterscode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import UTSSG.ZQDesigned.Characterscode.Utils.FunctionsToolset;

public class MainActivity extends AppCompatActivity {

    private static final String appVersionname = BuildConfig.VERSION_NAME;
    private static final int appVersioncode = BuildConfig.VERSION_CODE;


    private long exitTime = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.main_text_version);
        textView.setText("版本号：" + appVersionname + "(" + appVersioncode + ")");
        //if (FunctionsToolset.isInstalled(this, "com.google.android.gms")) {}
        if (!FunctionsToolset.checkPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            FunctionsToolset.requestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE", 1);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2500) {
            Toast.makeText(getApplicationContext(), "再按一次返回退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    public void entrance_onClick(View v) {
        startActivity(new Intent(getApplicationContext(), MigrateActivity.class));
    }


    public void button1_Onclick(View view) {
        startActivity(new Intent(getApplicationContext(), DonateActivity.class));
    }

}