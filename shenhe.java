package com.example.administrator.dianming;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/11/2 0002.
 */

public class shenhe extends AppCompatActivity {

    private Button bt4;
    private EditText cdT;
    private EditText kkT;
    private EditText qjT;

    private int id;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shenhe);

        kkT= (EditText) findViewById(R.id.editText2);//旷课次数
        cdT= (EditText) findViewById(R.id.editText5);//迟到次数
        qjT= (EditText) findViewById(R.id.editText10);//请假次数

        kkT.setEnabled(false);
        cdT.setEnabled(false);
        qjT.setEnabled(false);

        db=openOrCreateDatabase("student.db",MODE_PRIVATE,null);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        id=bundle.getInt("id");

        Cursor cursor= db.rawQuery("select Nlate,Nabsent,Nleave from studenttb where _id = ?",new String[]{id+""});

        while(cursor.moveToNext()){
            kkT.setText(cursor.getInt(cursor.getColumnIndex("Nabsent"))+"");
            cdT.setText(cursor.getInt(cursor.getColumnIndex("Nlate"))+"");
            qjT.setText(cursor.getInt(cursor.getColumnIndex("Nleave"))+"");
        }


        cursor.close();

    }
}
