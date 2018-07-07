package com.example.smura.virtualwindowcontroller;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Socketconect extends AsyncTask<String,Void,Void>{

    private static final String IP_ADDRESS = "192.168.0.18";
    private static final int PORT_NUMBER = 50005;
    String receivemessage = null;
    String sendmessage = null;

    protected Void doInBackground (String... params){
       try {
           //ソケット確立
           sendmessage = params[0];
           Socket socket = new Socket();
           SocketAddress address = new InetSocketAddress(IP_ADDRESS, PORT_NUMBER);
           socket.connect(address, 4000);

           //サーバからのメッセージ受信用
           BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           //サーバからのメッセージ送信用
           BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

           //サーバにメッセージ送信
           writer.write(sendmessage + "\n");
           writer.flush();

           //サーバからのメッセージ
           receivemessage = reader.readLine();

           //サーバからのメッセージ表示
           Log.v("テスト", "["+sendmessage+"]これは送ったメッセージです終わり");
           Log.v("テスト", "["+receivemessage+"]これはメッセージです終わり");
           socket.close();
           return null;
       } catch (IOException e) { //例外処理
           e.printStackTrace();
           return null;
        }
    }
}
