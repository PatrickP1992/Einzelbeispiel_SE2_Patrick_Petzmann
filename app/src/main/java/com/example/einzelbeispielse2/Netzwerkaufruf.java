package com.example.einzelbeispielse2;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.nio.charset.Charset;

public class Netzwerkaufruf extends AsyncTask {

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

    @Override
    protected Object doInBackground(Object[] objects) {
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
        return null;
    }
}
