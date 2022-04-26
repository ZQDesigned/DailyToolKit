package UTSSG.ZQDesigned.Namecode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.litepal.crud.DataSupport;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void button_Onclick(View view) {
        // Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
        EditText editText1 = findViewById(R.id.username);
        EditText editText2 = findViewById(R.id.password);


        if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
            Toast.makeText(this, "用户名或密码为空!", Toast.LENGTH_SHORT).show();
        }else{
            //数据库查询操作，查询数据库中是否存在该用户，如果存在则跳转到主页，否则提示用户不存在
            List<User> users = DataSupport.where("username=? and password=?", editText1.getText().toString(), editText2.getText().toString()).find(User.class);
            if(users.size() == 1){
                //登陆成功后跳转到MainActivity界面
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "用户名或密码错误，请重新输入！", Toast.LENGTH_SHORT).show();
            }
        }

    }

    //这里是注册按钮的点击事件，点击后跳转到注册页面
    public void tv_Onclick(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

}
