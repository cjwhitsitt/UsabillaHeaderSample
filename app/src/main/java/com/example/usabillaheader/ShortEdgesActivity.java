package com.example.usabillaheader;

import android.os.Bundle;

public class ShortEdgesActivity extends BaseUsabillaActivity {
    @Override
    protected void onStart() {
        super.onStart();
        contentFragment.tvTitle.setText("shortEdges");
    }
}