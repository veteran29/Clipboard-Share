/**
 ** @author veteran29
 **/
package com.veteran29.clipboardshare;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

public class Main extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Context ctx = this.getApplicationContext();
         
        Intent notificationIntent = new Intent(ctx, Share.class);
        
        PendingIntent contentIntent = PendingIntent.getActivity(ctx,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager nm = (NotificationManager) ctx
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Resources res = ctx.getResources();
        Notification.Builder builder = new Notification.Builder(ctx);

        builder.setContentIntent(contentIntent)
                    .setSmallIcon(android.R.drawable.ic_menu_share)
                    .setShowWhen(false)
                    .setPriority(Notification.PRIORITY_MIN)
                    .setOngoing(true)
                    .setContentTitle( res.getText(R.string.notif_title) )
                    .setContentText( res.getText(R.string.notif_text) );
        Notification n = builder.build();

        nm.notify(01, n);
        this.finish();
    }
}