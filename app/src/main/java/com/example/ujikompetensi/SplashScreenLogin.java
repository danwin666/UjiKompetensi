package com.example.ujikompetensi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent; import android.os.Bundle; import android.os.Handler;
public class SplashScreenLogin extends AppCompatActivity {
    public static int SPLASH_TIMER = 2000; @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_splash_screen_login);
        new Handler().postDelayed(new Runnable() { @Override
        public void run() {
            Intent intent = new Intent(SplashScreenLogin.this, Dashboard.class);
            startActivity(intent); finish();
        }
        }, SPLASH_TIMER);
    }
}
