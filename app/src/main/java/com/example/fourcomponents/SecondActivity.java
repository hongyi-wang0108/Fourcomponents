package com.example.fourcomponents;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private Button btn_sec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_sec = findViewById(R.id.btn_sec);
        btn_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Bundle bundle = i.getBundleExtra("name");
                String s = bundle.getString("key");
                setResult(RESULT_OK,i);
                Log.d("sec", s.toString());
                finish();
                ////传递数据1---》2：
                /*Intent i = getIntent();
                String s = i.getStringExtra("chuangei2de");
                Toast.makeText(SecondActivity.this,s,Toast.LENGTH_SHORT).show();*/

                //传递数据1《---2：
//                Intent data = new Intent();
//                data.putExtra("2chuangei1","woshi2chuanlaide");
//                setResult(RESULT_OK,data);
//                finish();//第一次就忘记写了
            }
        });
    }

    @Override
    public void onBackPressed() {
        //传递数据1《---2：
        super.onBackPressed();
        Intent data = new Intent();
        data.putExtra("2chuangei1","woshi2chuanlaide");
        setResult(RESULT_OK,data);
        finish();//第一次就忘记写了
    }
}