package yjh.test.android_fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by dsm2016 on 2017-08-03.
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    private static final String TAG = "FirebaseMsgService";
    private String msg;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
  

    }



}
