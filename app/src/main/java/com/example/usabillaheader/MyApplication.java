package com.example.usabillaheader;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Context context;
    private static FeedbackManager feedbackManager;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        feedbackManager = new FeedbackManager();
    }

    public static Context getContext() {
        return context;
    }

    public static FeedbackManager getFeedbackManager() {
        return feedbackManager;
    }

}
