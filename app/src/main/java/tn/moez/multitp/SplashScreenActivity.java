package tn.moez.multitp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
               Intent i = new Intent(getApplicationContext(),LoginActivity.class);
               startActivity(i);
               finish();
            }
        };

        new Handler().postDelayed(runnable,2000);

    }
}
