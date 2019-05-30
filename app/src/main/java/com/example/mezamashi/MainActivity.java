package com.example.mezamashi;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int hour;
    int min;
    public void next1(View v){
        TextView hourt=findViewById(R.id.hour);
        TextView mint=findViewById(R.id.min);
        String temp = hourt.getText()+":"+mint.getText();
        hour = Integer.parseInt(hourt.getText()+"");
        min = Integer.parseInt(mint.getText()+"");

        if(hour>=24||hour<0||min>60||min<0){
            midToast("input Error!!",1000);
        }else {
            midToast(temp, 1000);
            {//今の時間をゲット
                SimpleDateFormat hh = new SimpleDateFormat("HH");
                SimpleDateFormat mm = new SimpleDateFormat("MM");
                String hhh = hh.format(new Date(System.currentTimeMillis()));
                String mmm = mm.format(new Date(System.currentTimeMillis()));
                midToast("now===" + hhh + ":" + mmm, 1000);
            }
            {//確認メッセージ
                AlertDialog.Builder normalDialog = new AlertDialog.Builder(MainActivity.this);
                normalDialog.setTitle("最終確認").setMessage("今から００時００分でよろしですか？").setPositiveButton(
                        "いい",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //to--do
                                Toast.makeText(MainActivity.this, "設定成功しました！", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                normalDialog.setNegativeButton("キャンセル",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //to--do
                            }
                        });
                normalDialog.show();
            }
        }
        }

    void midToast(String str, int showTime)//Toastツール
    {
        Toast toast = Toast.makeText(MainActivity.this, str, showTime);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.BLACK);     //フォント色
        toast.show();
    }


}
