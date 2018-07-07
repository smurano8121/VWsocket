package com.example.smura.virtualwindowcontroller;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private  boolean flag = false;
    private Socketconect sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sc = new Socketconect();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.change);
        textView.setText(R.string.Change);
        // ボタン設定
        Button imagebutton = (Button) findViewById(R.id.Image);
        imagebutton.setText(R.string.Image);
        Button videobutton = (Button) findViewById(R.id.Video);
        videobutton.setText(R.string.Video);

        // リスナーをボタンに登録
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // flagがtrueの時
                if (flag) {
                    textView.setText(R.string.Change);
                    flag = false;
                    //sc.doInBackground("Image");
                    sc.execute("IMAGE");
                }
                // flagがfalseの時
                else {
                    textView.setText(R.string.World);
                    //sc.doInBackground("Image");
                    flag = true;
                    sc.execute("IMAGE");
                }
            }
        });

        videobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // flagがtrueの時
                if (flag) {
                    textView.setText(R.string.Change);
                    flag = false;
                    sc.connect("VIDEO");
                }
                // flagがfalseの時
                else {
                    textView.setText(R.string.World);
                    flag = true;
                    sc.connect("VIDEO");
                }
            }
        });
    }
}
