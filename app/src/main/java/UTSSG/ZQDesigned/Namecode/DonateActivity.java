package UTSSG.ZQDesigned.Namecode;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class DonateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
    }

    public void Wechatpay_OnClick(View v) {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.wechatpay);
    }

    public void Alipay_OnClick(View v) {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.alipay);
    }

}
