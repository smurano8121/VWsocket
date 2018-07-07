package com.example.smura.virtualwindowcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private  boolean flag = false;
    private Socketconect sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ボタン設定
        Button imagebutton = (Button) findViewById(R.id.Image);
        imagebutton.setText(R.string.Image);
        Button videobutton = (Button) findViewById(R.id.Video);
        videobutton.setText(R.string.Video);

        // リスナーをボタンに登録
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc = new Socketconect();
                sc.execute("IMAGE");
                }
        });

        videobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc = new Socketconect();
                sc.execute("VIDEO");
            }
        });
    }
}
