package com.example.einzelbeispielse2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BerechnenActivity extends AppCompatActivity {

    private TextView eingabe;
    private TextView ausgabe;
    String matrikelnummer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berechnen);
        Intent myIntent = getIntent();
        matrikelnummer = myIntent.getStringExtra("MATRIKELNUMMER");
        eingabe = findViewById(R.id.textView_EingabeWert);
        ausgabe = findViewById(R.id.textView_AusgabeWert);

        if (matrikelnummer.isEmpty())
        {
            eingabe.setText("Fehler in der Übertragung");
        }
        else
        {
            eingabe.setText(matrikelnummer);


        }
    }
}
