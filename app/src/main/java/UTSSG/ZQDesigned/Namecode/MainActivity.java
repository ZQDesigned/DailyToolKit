package UTSSG.ZQDesigned.Namecode;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
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
        if(codeBit.length==0) {//判断
            Toast.makeText(this, "请输入内容！", Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(MainActivity.this).setTitle("提示")//设置对话框标题
                    .setMessage("请输入内容！")//设置显示的内容
                    .setNegativeButton("返回", (dialog, which) -> {
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)//设置图标
                    .show();//在按键响应事件中显示此对话框
        } else if(codeBit.length==2) {//判断
            codeBit[0] -=160;//提取区位码
            codeBit[1] -=160;
            if(codeBit[0]<0|codeBit[1]<0){
                Toast.makeText(this, "您输入的不是汉字！", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(MainActivity.this).setTitle("提示")//设置对话框标题
                        .setMessage("您输入的不是汉字！")//设置显示的内容
                        .setNegativeButton("返回", (dialog, which) -> {
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)//设置图标
                        .show();//在按键响应事件中显示此对话框
            } else {
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
        }else if(codeBit.length==4) {//判断
            codeBit[0] -= 160;//提取区位码
            codeBit[1] -= 160;
            codeBit[2] -= 160;
            codeBit[3] -= 160;
            if(codeBit[0]<0|codeBit[1]<0|codeBit[2]<0|codeBit[3]<0){
                Toast.makeText(this, "您输入的不是纯汉字！", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(MainActivity.this).setTitle("提示")//设置对话框标题
                        .setMessage("您输入的不是纯汉字！")//设置显示的内容
                        .setNegativeButton("返回", (dialog, which) -> {
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)//设置对话框图标
                        .show();//在按键响应事件中显示此对话框
            } else if (codeBit[0] < 10 && codeBit[1] < 10 && codeBit[2] < 10 && codeBit[3] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]));
            } else if (codeBit[0] < 10 && codeBit[1] < 10 && codeBit[2] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + (codeBit[3]));
            } else if (codeBit[0] < 10 && codeBit[1] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + "0" + (codeBit[1]) + (codeBit[2]) + (codeBit[3]));
            } else if (codeBit[0] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + (codeBit[3]));
            } else if (codeBit[1] < 10 && codeBit[2] < 10 && codeBit[3] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]));
            } else if (codeBit[1] < 10 && codeBit[2] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + (codeBit[3]));
            } else if (codeBit[1] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + "0" + (codeBit[1]) + (codeBit[2]) + (codeBit[3]));
            } else if (codeBit[2] < 10 && codeBit[3] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]));
            } else if (codeBit[2] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + "0" + (codeBit[2]) + (codeBit[3]));
            } else if (codeBit[3] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + "0" + (codeBit[3]));
            } else {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + (codeBit[3]));
            }
        }else if(codeBit.length==6) {//判断
            codeBit[0] -= 160;//提取区位码
            codeBit[1] -= 160;
            codeBit[2] -= 160;
            codeBit[3] -= 160;
            codeBit[4] -= 160;
            codeBit[5] -= 160;
            if(codeBit[0]<0|codeBit[1]<0|codeBit[2]<0|codeBit[3]<0|codeBit[4]<0|codeBit[5]<0){
                Toast.makeText(this, "您输入的不是纯汉字！", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(MainActivity.this).setTitle("提示")//设置对话框标题
                        .setMessage("您输入的不是纯汉字！")//设置显示的内容
                        .setNegativeButton("返回", (dialog, which) -> {
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)//设置对话框图标
                        .show();//在按键响应事件中显示此对话框
            } else if (codeBit[0] < 10 && codeBit[1] < 10 && codeBit[2] < 10 && codeBit[3] < 10 && codeBit[4] < 10 && codeBit[5] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]) + "0" + (codeBit[4]) + "0" + (codeBit[5]));
            } else if (codeBit[0] < 10 && codeBit[1] < 10 && codeBit[2] < 10 && codeBit[3] < 10 && codeBit[4] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]) + "0" + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[0] < 10 && codeBit[1] < 10 && codeBit[2] < 10 && codeBit[3] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[0] < 10 && codeBit[1] < 10 && codeBit[2] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[0] < 10 && codeBit[1] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + "0" + (codeBit[1]) + (codeBit[2]) + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[0] < 10) {
                result.setText(nameStr + "--转换结果-->" + "0" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[1] < 10 && codeBit[2] < 10 && codeBit[3] < 10 && codeBit[4] < 10 && codeBit[5] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]) + "0" + (codeBit[4]) + "0" + (codeBit[5]));
            } else if (codeBit[1] < 10 && codeBit[2] < 10 && codeBit[3] < 10 && codeBit[4] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]) + "0" + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[1] < 10 && codeBit[2] < 10 && codeBit[3] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[1] < 10 && codeBit[2] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + "0" + (codeBit[1]) + "0" + (codeBit[2]) + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[1] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + "0" + (codeBit[1]) + (codeBit[2]) + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[2] < 10 && codeBit[3] < 10 && codeBit[4] < 10 && codeBit[5] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]) + "0" + (codeBit[4]) + "0" + (codeBit[5]));
            } else if (codeBit[2] < 10 && codeBit[3] < 10 && codeBit[4] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]) + "0" + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[2] < 10 && codeBit[3] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + "0" + (codeBit[2]) + "0" + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[2] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + "0" + (codeBit[2]) + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[3] < 10 && codeBit[4] < 10 && codeBit[5] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + "0" + (codeBit[3]) + "0" + (codeBit[4]) + "0" + (codeBit[5]));
            } else if (codeBit[3] < 10 && codeBit[4] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + "0" + (codeBit[3]) + "0" + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[3] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + "0" + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[4] < 10 && codeBit[5] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + (codeBit[3]) + "0" + (codeBit[4]) + "0" + (codeBit[5]));
            } else if (codeBit[4] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + (codeBit[3]) + "0" + (codeBit[4]) + (codeBit[5]));
            } else if (codeBit[5] < 10) {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + (codeBit[3]) + (codeBit[4]) + "0" + (codeBit[5]));
            } else {
                result.setText(nameStr + "--转换结果-->" + (codeBit[0]) + (codeBit[1]) + (codeBit[2]) + (codeBit[3]) + (codeBit[4]) + (codeBit[5]));
            }
        }else{
            Toast.makeText(this, "您输入的不是汉字！", Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(MainActivity.this).setTitle("提示")//设置对话框标题
                    .setMessage("您输入的不是汉字！")//设置显示的内容
                    .setNegativeButton("返回", (dialog, which) -> {
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)//设置对话框图标
                    .show();//在按键响应事件中显示此对话框
        }

        }
        public void button1_Onclick(View view) {
            Intent intent=new Intent(MainActivity.this,DonateActivity.class);
            startActivity(intent);
        }
    }