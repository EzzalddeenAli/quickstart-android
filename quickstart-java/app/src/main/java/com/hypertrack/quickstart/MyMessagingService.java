package com.hypertrack.quickstart;


import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.hypertrack.sdk.HyperTrackMessagingService;

public class MyMessagingService extends HyperTrackMessagingService {
    private static final String TAG = "MyMessagingService";
    @Override
    public void onNewToken(String newToken) {
        super.onNewToken(newToken);
        Log.d(TAG, "Firebase token updated");
        // handle new token here
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (!super.onMessageReceived(remoteMessage.getData())) {
            Log.d(TAG, "New push notification received");
            // process your push here
        } else {
            Log.d(TAG, "HyperTrack's data message was received");
            // you aren't require to do anything, but can log it for
            // debugging or other purpose
        }
    }
}
