package com.hypertrack.quickstart

import android.util.Log
import com.google.firebase.messaging.RemoteMessage
import com.hypertrack.sdk.HyperTrackMessagingService

class MyMessagingService : HyperTrackMessagingService() {
    override fun onNewToken(newToken: String) {
        super.onNewToken(newToken)
        Log.d(TAG, "Firebase token has changed")
        // handle token update
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (!super.onMessageReceived(remoteMessage.data)) {
            // process notification
            Log.d(TAG, "Non-hypertrack push notification received")
        } else {
            Log.d(TAG, "hypertrack data message received")
            // that notification was processed by hypertrack sdk
            // You aren't required to do anything with it, as it was already processedd in
            // `super.onMessageReceived()`but you can log it for debugging or other purpose
        }

    }

    companion object {
        private const val TAG = "MyMessagingService"
    }
}