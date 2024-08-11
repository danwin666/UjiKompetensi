package com.example.ujikompetensi; // Replace with your package name

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailData extends AppCompatActivity {

    private EditText isianNamaDetailData, isianNumberDetailData, isianTanggalLahirDetailData, isianJenisKelaminDetailData, isianAlamatDetailData;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        // Initialize EditText references
        isianNamaDetailData = findViewById(R.id.isianNamaDetailData);
        isianNumberDetailData = findViewById(R.id.isianNumberDetailData);
        isianTanggalLahirDetailData = findViewById(R.id.isianTanggalLahirDetailData);
        isianJenisKelaminDetailData = findViewById(R.id.isianJenisKelaminDetailData);
        isianAlamatDetailData = findViewById(R.id.isianAlamatDetailData);

        // Initialize DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Implement functionality for saving data
        findViewById(R.id.btnSimpanDetailData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = isianNamaDetailData.getText().toString();
                String number = isianNumberDetailData.getText().toString();
                String dateOfBirth = isianTanggalLahirDetailData.getText().toString();
                String gender = isianJenisKelaminDetailData.getText().toString();
                String address = isianAlamatDetailData.getText().toString();

                // Consider adding data validation here

                // Insert data into database
                boolean success = dbHelper.insert(name, number); // Assuming number is email here

                if (success) {
                    Toast.makeText(DetailData.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
                    // Clear edit texts or perform other actions after successful insertion
                } else {
                    Toast.makeText(DetailData.this, "Failed to save data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
