package UTSSG.ZQDesigned.Characterscode;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;

import UTSSG.ZQDesigned.Characterscode.Utils.FunctionsToolset;

public class MigrateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_migrate);
    }

    public void MReturn_OnClick(View view) {
        this.finish();
    }

    @SuppressLint("SetTextI18n")
    public void migrate_Onclick(View view) throws UnsupportedEncodingException {
        EditText name = findViewById(R.id.characters_input);
        String chractersStr = name.getText().toString();

        if(TextUtils.isEmpty(chractersStr)) {//判断
            Toast.makeText(this, "请输入内容！", Toast.LENGTH_SHORT).show();
            FunctionsToolset.showDialog(this, "提示","请输入内容！","返回",android.R.drawable.ic_dialog_alert,false);
            return;
        }

        TextView result = findViewById(R.id.output);
        EditText result_long = findViewById(R.id.output_long);
        byte[] codeBit = chractersStr.getBytes("gb2312");// 获取汉字的字节数组
        if(codeBit.length%2==0) {//判断
            StringBuilder sb = new StringBuilder();
            for (byte codeBit_tmp:codeBit) {
                codeBit_tmp -= 160;

                if (codeBit_tmp < 0) {
                    Toast.makeText(this, "您输入的内容不合法！", Toast.LENGTH_SHORT).show();
                    FunctionsToolset.showDialog(this,"提示","您输入的内容不合法！","返回",android.R.drawable.ic_dialog_alert,false);
                    return;
                } else if (codeBit_tmp <= 10) {
                    sb.append(0);
                }
                sb.append(codeBit_tmp);
            }
            Toast.makeText(this, "正在查询......", Toast.LENGTH_SHORT).show();
            result.setText(sb.toString().replaceAll(".{4}", "$0 "));
            result_long.setText(sb.toString().replaceAll(".{4}", "$0 "));
        }else{
            Toast.makeText(this, "您输入的内容不合法！", Toast.LENGTH_SHORT).show();
            FunctionsToolset.showDialog(this,"提示","您输入的内容不合法！","返回",android.R.drawable.ic_dialog_alert,false);
        }

    }
}