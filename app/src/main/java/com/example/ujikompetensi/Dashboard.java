package com.example.ujikompetensi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    private Button btnInputData, btnLihatData, btnInformasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize button elements
        btnInputData = findViewById(R.id.btnInputData);
        btnLihatData = findViewById(R.id.btnLihatData);
        btnInformasi = findViewById(R.id.btnInformasi);

        // Set click listeners for buttons (handle button clicks here)
        btnInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement functionality for "INPUT DATA" button click
            }
        });

        btnLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, LihatData.class);
                startActivity(intent);
            }
        });

        btnInformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement functionality for "INFORMASI" button click
            }
        });
    }
}
