package com.example.usabillaheader;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BaseUsabillaActivity extends AppCompatActivity implements FeedbackManager.FragmentCallback {
    protected TextView tvTitle;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_usabilla);

        tvTitle = findViewById(R.id.tv_title);
        progressBar = findViewById(R.id.pb_loading);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyApplication.getFeedbackManager().loadForm(this);
    }

    @Override
    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void closeFragment() {
        finish();
    }
}
