package com.csform.android.uiapptemplate;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String linkrec = "";
        if (remoteMessage.getData().size() > 0) {
            for (String key : remoteMessage.getData().keySet()) {
                Object value = remoteMessage.getData().get(key);
                if (key.equals("link")) {
                    linkrec = value.toString();

                }
            }
        }

        sendNotification(remoteMessage.getNotification().getBody(), linkrec);


    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private void sendNotification(String messageBody, String linkuri) {

        Intent resultIntent;
        if (linkuri.equals(""))
        {
            resultIntent = new Intent(this, MainActivity.class);
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        }
        else {
            resultIntent = new Intent(Intent.ACTION_VIEW);
            resultIntent.setData(Uri.parse(linkuri));

        }
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, resultIntent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("UIapp Message")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}
