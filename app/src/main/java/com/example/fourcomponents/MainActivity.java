package com.example.fourcomponents;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int GO_SECOND = 1;
    private Button btn_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 /*       if (savedInstanceState != null){
            String s = savedInstanceState.getString("key");
            Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
        }*/
        btn_main = findViewById(R.id.btn_main);
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                Bundle extra = new Bundle();
                extra.putString("key","value");
                i.putExtra("name",extra);
                startActivityForResult(i,GO_SECOND);
                //显:没别的了，就这一句，意图极其明显
               // Intent i = new Intent(MainActivity.this,SecondActivity.class);

                //隐: 1.自定义action，manifest那要改
                    //<action android:name="com.example.fourcomponents.secondactivity"/>
                //Intent i = new Intent("com.example.fourcomponents.secondactivity");

                //隐: 2.自定义category.匹配action可以匹配上之后，如果add这个匹配不上就报错了
//                <action android:name="com.example.fourcomponents.secondactivity"/>
//                <category android:name="android.intent.category.DEFAULT"/>
//                <category android:name="com.example.fourcomponents"/>
                /*Intent i = new Intent("com.example.fourcomponents.secondactivity");
                i.addCategory("com.example.fourcomponents");
                startActivity(i);*/

                //隐:3. android的action，重点setData
                // new Intent里面是大动作，ps上网，打电话，setdata是去哪个页面，打什么号码
//                Intent i = new Intent(Intent.ACTION_DIAL);
//                i.setData(Uri.parse("tel:10086"));

                //隐:4. android的action，重点setData，manifest里面写data,data必须符合setdata才能正常运行
                //<data android:scheme="http"/>
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse("http://www.baidu.com"));

                //传递数据act1---》act2：
                /*Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("chuangei2de","woshi1111");//key，value
                */

                //传递数据act1《---act2：
                /*Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(i,GO_SECOND);*/
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case GO_SECOND:{
                if(resultCode == RESULT_OK){
                    //String s = data.getStringExtra("key");
                    Bundle bundle = data.getBundleExtra("name");
                    String s = bundle.getString("key");
                    Log.d("first", s.toString());
                }
                break;
            }
            default:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key","value");
    }
}