package com.example.einzelbeispielse2;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.nio.charset.Charset;

public class Netzwerkaufruf extends AsyncTask<String, Integer, String> {

    private String message;
    private String outputNachricht;
    private String ip;
    private int port;

    public Netzwerkaufruf(String message, String ip, int port) {
        this.message = message;
        this.ip = ip;
        this.port = port;
    }

    public String getOutputNachricht() {
        return outputNachricht;
    }

    public void setOutputNachricht(String outputNachricht) {
        this.outputNachricht = outputNachricht;
    }

    @SuppressLint("WrongThread")
    @Override
    protected String doInBackground(String... params) {
        try {
            //String message = strings[0];
            //String ip = strings[1];

            BufferedReader inFromUser = new BufferedReader(new StringReader(message));

            Socket clientSocket = new Socket(ip,port);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            message = inFromUser.readLine();

            outToServer.writeBytes(message +  "\n");

            outputNachricht = inFromServer.readLine();



            Log.d("Message", outputNachricht);

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Fehler", "Exception");
        }
        return outputNachricht;
    }
}
