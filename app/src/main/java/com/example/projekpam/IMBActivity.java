package com.example.projekpam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class IMBActivity extends AppCompatActivity {
    EditText edbb, edtinggi, edimt, edket;
    Button bthitung;
    Double vbb, vtinggi, vimt ;
    String vket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imb_counter);
        edbb = (EditText)findViewById(R.id.edbb);
        edtinggi = (EditText)findViewById(R.id.edtinggi);
        edimt = (EditText)findViewById(R.id.edimt);
        edket = (EditText)findViewById(R.id.edket);
        bthitung = (Button) findViewById(R.id.bthitung);
    }

    public void hitung(View view) {
        vbb = Double.parseDouble(edbb.getText().toString());
        vtinggi = Double.parseDouble(edtinggi.getText().toString());

        vimt = vbb / ((vtinggi/100)*(vtinggi/100));

        if (vimt < 18.5){
            vket = "Berat Badan Kurang";
        }
        else if (vimt >= 18.5 && vimt <25){
            vket = "Berat Badan Ideal";
        }
        else if (vimt >= 25 && vimt <30){
            vket = "Berat Badan Berlebih";
        }
        else {
            vket = "Sangat Gemuk, Anda Harus Diet";
        }
        edimt.setText(""+vimt);
        edket.setText(""+vket);
    }
}