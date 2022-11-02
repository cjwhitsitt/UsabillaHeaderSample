package com.example.usabillaheader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.usabilla.sdk.ubform.UbConstants;
import com.usabilla.sdk.ubform.Usabilla;
import com.usabilla.sdk.ubform.UsabillaFormCallback;
import com.usabilla.sdk.ubform.UsabillaReadyCallback;
import com.usabilla.sdk.ubform.sdk.form.FormClient;

public class FeedbackManager {

    static String formId = "6362f6aae87aef1117371742";

    private Usabilla usabilla = Usabilla.INSTANCE;
    private ReadyCallback readyCallback = new ReadyCallback();
    private FormCallback formCallback = new FormCallback();
    private BroadcastReceiver broadcastReceiver;

    private FragmentCallback fragmentCallback;

    FeedbackManager() {
        Context context = MyApplication.getContext();

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (UbConstants.INTENT_CLOSE_FORM.equals(intent.getAction()) && fragmentCallback != null) {
                    fragmentCallback.closeFragment();
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(UbConstants.INTENT_CLOSE_FORM);
        LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, filter);

        usabilla.setDefaultNavigationButtonsVisibility(false);
        Usabilla.INSTANCE.initialize(context, null, null, readyCallback);
    }

    public void loadForm(FragmentCallback callback) {
        fragmentCallback = callback;
        usabilla.loadFeedbackForm(formId, formCallback);
    }

    interface FragmentCallback {
        void loadFragment(Fragment fragment);
        void closeFragment();
    }

    private class ReadyCallback implements UsabillaReadyCallback {
        @Override
        public void onUsabillaInitialized() {}
    }

    private class FormCallback implements UsabillaFormCallback {
        @Override
        public void formLoadFail() {}

        @Override
        public void formLoadSuccess(@NonNull FormClient formClient) {
            if (fragmentCallback != null) {
                fragmentCallback.loadFragment(formClient.getFragment());
            }
        }

        @Override
        public void mainButtonTextUpdated(@NonNull String s) {}
    }

}
