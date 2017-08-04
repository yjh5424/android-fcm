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
        Log.d(TAG,"From: "+remoteMessage.getFrom());

        if(remoteMessage.getData().size()>0){
            Log.d(TAG,"Message data payload "+remoteMessage.getData());
        }

        if(remoteMessage.getNotification() != null){
            Log.d(TAG,"Message Notification Body "+remoteMessage.getNotification().getBody());
        }

        msg=remoteMessage.getNotification().getBody();

        Intent intent=new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent conPendingIntent=PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
              .setContentTitle("FCM")
                .setAutoCancel(true)
                .setContentText(msg)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setVibrate(new long[]{1, 1000});


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, mBuilder.build());


        mBuilder.setContentIntent(conPendingIntent);



    }



}
