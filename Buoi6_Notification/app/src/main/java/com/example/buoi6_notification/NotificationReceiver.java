package com.example.buoi6_notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//lang nghe Broadcast tu he thong
public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("NOTIFICATION");
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
