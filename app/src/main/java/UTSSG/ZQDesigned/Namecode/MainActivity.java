package UTSSG.ZQDesigned.Namecode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void button2_Onclick(View view) throws UnsupportedEncodingException {
        EditText name = findViewById(R.id.name);
        TextView result = findViewById(R.id.output);
        String nameStr = name.getText().toString();
        byte[] codeBit = nameStr.getBytes("gb2312");// 获取汉字的字节数组
        if(codeBit.length>2) {//判断
            Toast.makeText(this, "禁止转换多个字！", Toast.LENGTH_SHORT).show();
            return;
        }else if(codeBit.length<2){//判断
            Toast.makeText(this, "您输入的不是汉字！", Toast.LENGTH_SHORT).show();
            //弹出对话框
            return;
        }else {
            codeBit[0]-=160;//提取区位码
            codeBit[1]-=160;
        }
        if(codeBit[0]<0|codeBit[1]<0){
            Toast.makeText(this, "您输入的不是汉字！", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "正在查询......", Toast.LENGTH_SHORT).show();
            if (codeBit[0] < 10 && codeBit[1] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + "0" + (codeBit[1]));
            } else if (codeBit[0] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + (codeBit[1]));
            } else if (codeBit[1] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + "0" + (codeBit[1]));
            } else {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]));
            }
        }
        }
        public void button1_Onclick(View view) {
            Intent intent=new Intent(MainActivity.this,DonateActivity.class);
            startActivity(intent);
        }
    }