package com.example.ujikompetensi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent; import android.os.Bundle; import android.os.Handler;
public class Home extends AppCompatActivity {
    public static int SPLASH_TIMER = 2000; @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_home);
        new Handler().postDelayed(new Runnable() { @Override
        public void run() {
            Intent intent = new Intent(Home.this, Login.class);
            startActivity(intent); finish();
        }
        }, SPLASH_TIMER);
    }
}
