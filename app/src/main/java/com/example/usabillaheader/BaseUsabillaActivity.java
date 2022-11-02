package com.example.usabillaheader;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BaseUsabillaActivity extends AppCompatActivity implements FeedbackManager.FragmentCallback {
    protected ContentFragment contentFragment = new ContentFragment();
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_usabilla);

        progressBar = findViewById(R.id.pb_loading);
    }

    @Override
    protected void onStart() {
        super.onStart();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.overlay_content, contentFragment)
                .commitNow();

        MyApplication.getFeedbackManager().loadForm(this);
    }

    @Override
    public void loadFragment(Fragment fragment) {
        contentFragment.loadFragment(fragment);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void closeFragment() {
        finish();
    }
}
