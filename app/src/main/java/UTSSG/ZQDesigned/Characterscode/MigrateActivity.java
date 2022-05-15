package UTSSG.ZQDesigned.Characterscode;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MigrateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_migrate);
    }

    public void MReturn_OnClick(View view) {
        this.finish();
    }
}