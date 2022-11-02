package com.example.usabillaheader;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button shortEdgesButton;
    private Button neverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shortEdgesButton = findViewById(R.id.bt_shortedges);
        shortEdgesButton.setOnClickListener(view -> startActivity(ShortEdgesActivity.class));

        neverButton = findViewById(R.id.bt_never);
        neverButton.setOnClickListener(view -> startActivity(NeverActivity.class));
    }

    private void startActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

}