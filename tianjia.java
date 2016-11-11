package com.example.administrator.dianming;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.transition.SidePropagation;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/2 0002.
 */

public class tianjia extends AppCompatActivity {

    private Button bt5;
    private Button bt4;

    private EditText sidT2;
    private EditText nameT2;
    private EditText classT2;

    private CheckBox cb4;
    private CheckBox cb5;
    private int cflag4=0,cflag5=0;
    private String sex;

    private SQLiteDatabase db;
    public  String filePath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianjia);

        bt5= (Button) findViewById(R.id.button5);//确定
        bt4= (Button) findViewById(R.id.button4);//选择图片

        cb4= (CheckBox) findViewById(R.id.checkBox4);//男
        cb5= (CheckBox) findViewById(R.id.checkBox5);//女

        sidT2= (EditText) findViewById(R.id.editText6);//学号
        nameT2= (EditText) findViewById(R.id.editText7);//姓名
        classT2= (EditText) findViewById(R.id.editText9);//班级

        db=openOrCreateDatabase("student.db",MODE_PRIVATE,null);

        filePath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/a.png";

        /*
         *选择图片事件
         */
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /*
         *确定按钮事件
         */
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag=0;
                ContentValues values=new ContentValues();
                while(flag==0){
                    if
                    values.put("Sid",sidT2.getText().toString());
                    values.put("Sname",nameT2.getText().toString());
                    values.put("class",classT2.getText().toString());
                    values.put("Ssex",sex);
                    try{
                        db.insert("studenttb",null,values);
                        flag=1;
                    }catch (Exception e){
                        Toast.makeText(tianjia.this,"学号输入有误，请重新输入",Toast.LENGTH_LONG).show();
                        values.clear();
                        sidT2.setText("");
                        nameT2.setText("");
                        classT2.setText("");
                        cb4.setChecked(false);
                        cb5.setChecked(false);
                    }
                }
                values.clear();
                sidT2.setText("");
                nameT2.setText("");
                classT2.setText("");
                cb4.setChecked(false);
                cb5.setChecked(false);
            }
        });

        /*
         *checkbox事件
         */

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb5.isChecked()==false){
                    cflag4=1;
                    sex="男";
                }
            }
        });

        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb4.isChecked()==false){
                    sex="女";
                }
            }
        });
        //db.close();
    }
}
