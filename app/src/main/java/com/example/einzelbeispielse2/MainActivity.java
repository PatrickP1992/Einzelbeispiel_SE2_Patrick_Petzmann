package com.example.einzelbeispielse2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private String matrikelnummer;
    private EditText eingabe;
    private TextView antwort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eingabe = findViewById(R.id.editText_Matrikelnummer);
        antwort = findViewById(R.id.textView_Antwort);
        matrikelnummer = eingabe.getText().toString();
    }

    public void abschicken(View view)
    {
        String ip = "143.205.174.165";
        int port = 53212;
        matrikelnummer = eingabe.getText().toString();
        Netzwerkaufruf netzwerkaufruf = new Netzwerkaufruf(matrikelnummer, ip, port);

        try {
            antwort.setText(netzwerkaufruf.execute().get());
        } catch (ExecutionException e) {
            e.printStackTrace();
            Log.e("Fehler", "ExecutionException");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("Fehler", "InteruptedException");
        }

    }
}
