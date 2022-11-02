package com.example.usabillaheader;

public class NeverActivity extends BaseUsabillaActivity {
    @Override
    protected void onStart() {
        super.onStart();
        tvTitle.setText("never");
    }
}