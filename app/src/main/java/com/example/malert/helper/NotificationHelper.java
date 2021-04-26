package com.example.malert.helper;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.malert.R;

/**
 * Wrapper class to help create the notification objects
 */
public class NotificationHelper extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";

    private NotificationManager mManager;

    /**
     * Helps create a notification channel with constructor
     */
    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    /**
     * Helps create a notification channel
     */
    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
    }

    /**
     * Helps create a notification manager
     */
    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return mManager;
    }

    /**
     * Helps create a notification channel builder
     */
    public NotificationCompat.Builder getChannelNotification(String name) {
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("Medication time")
                .setContentText("Take 1 Pill of " + name + " with water.")
                .setSmallIcon(R.drawable.ic_launcher_background);

    }
}