package com.example.usabillaheader;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Application application;
    private static FeedbackManager feedbackManager;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        feedbackManager = new FeedbackManager();
    }

    public static Context getContext() {
        return application.getApplicationContext();
    }

    public static FeedbackManager getFeedbackManager() {
        return feedbackManager;
    }

}
