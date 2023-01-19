package UTSSG.ZQDesigned.MorseCode

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
        val sp = getSharedPreferences("MorseCode", MODE_PRIVATE)
        if (sp.getString("A", null) == null) {
            Toast.makeText(this, "首次运行，正在初始化存储......", Toast.LENGTH_SHORT).show()
            sp.lazySp {
                //向SharedPreferences写入所有字母和数字对应的摩斯电码
                putString("A", ".-")
                putString("B", "-...")
                putString("C", "-.-.")
                putString("D", "-..")
                putString("E", ".")
                putString("F", "..-.")
                putString("G", "--.")
                putString("H", "....")
                putString("I", "..")
                putString("J", ".---")
                putString("K", "-.-")
                putString("L", ".-..")
                putString("M", "--")
                putString("N", "-.")
                putString("O", "---")
                putString("P", ".--.")
                putString("Q", "--.-")
                putString("R", ".-.")
                putString("S", "...")
                putString("T", "-")
                putString("U", "..-")
                putString("V", "...-")
                putString("W", ".--")
                putString("X", "-..-")
                putString("Y", "-.--")
                putString("Z", "--..")
                putString("1", ".----")
                putString("2", "..---")
                putString("3", "...--")
                putString("4", "....-")
                putString("5", ".....")
                putString("6", "-....")
                putString("7", "--...")
                putString("8", "---..")
                putString("9", "----.")
                putString("0", "-----")
                putString(" ", " ")
            }
            Toast.makeText(this, "初始化完成！", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClick(v: View) {
        val originaltext = findViewById<EditText>(R.id.originaltext)
        val input = originaltext.text.toString()
        //判断输入是否为空
        if (input.isEmpty()) {
            Toast.makeText(this, "请输入内容！", Toast.LENGTH_SHORT).show()
            return
        }
        //判断输入是否为纯英文或纯中文（忽略数字），如果不是则返回
        if (!input.isEnglish()) {
            Toast.makeText(this, "请输入纯英文或纯中文！", Toast.LENGTH_SHORT).show()
            return
        }
        //将输入的内容逐字拆分并写入数组
        val inputArray = input.toCharArray()
        //将数组内全部小写字母转换为大写字母
        for (i in inputArray.indices) {
            if (inputArray[i] in 'a'..'z') {
                inputArray[i] = inputArray[i].uppercaseChar()
            }
        }
        //从SharedPreferences中读取摩斯电码
        val sp = getSharedPreferences("MorseCode", MODE_PRIVATE)
        //将摩斯电码写入数组
        val morseArray = Array(inputArray.size) { sp.getString(inputArray[it].toString(), null) }
        //将摩斯电码数组转换为字符串
        val morseString = morseArray.joinToString(" ")
        //将摩斯电码字符串写入Result
        val result: TextView = findViewById(R.id.result)
        result.text = morseString
    }

    private inline fun SharedPreferences.lazySp(crossinline block: SharedPreferences.Editor.() -> Unit) {
        Thread {
            Looper.prepare()
            this.edit().apply {
                block()
            }.apply()
        }.start()
    }

    /**
     * 判断给定内容是否为纯英文(忽略数字)
     *
     * @return true为纯英文，false为非纯英文
     */
    private fun String.isEnglish(): Boolean {
        val inputArray = this.toCharArray()
        for (i in inputArray.indices) {
            if (inputArray[i] !in 'a'..'z' && inputArray[i] !in 'A'..'Z' && inputArray[i] !in '0'..'9' && inputArray[i] != ' ') {
                return false
            }
        }
        return true
    }

}