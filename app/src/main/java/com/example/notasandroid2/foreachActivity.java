package com.example.notasandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class foreachActivity extends AppCompatActivity {

    protected TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreach);

        textView = findViewById(R.id.textView);

        String[] arraycito = {};
        String arraycitoS = "";

        for (int i = 0; i < arraycito.length; i++) {
            arraycitoS += arraycito[i] + "\n ----------------------- \n";
        }

        textView.setText(arraycitoS);
    }
}