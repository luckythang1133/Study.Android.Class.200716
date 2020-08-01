package com.example.buoi6_notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.buoi6_notification.App.CHANNEL_1;
import static com.example.buoi6_notification.App.CHANNEL_2;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;
    private EditText edt1, edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addViews();
        notificationManagerCompat = NotificationManagerCompat.from(this);
    }

    private void addViews() {
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
    }

    public void sendOnChannel1(View view) {
        Intent activiIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, activiIntent, 0);

        Intent broadcastReceiver = new Intent(this, NotificationReceiver.class);
        broadcastReceiver.putExtra("NOTIFICATION", edt2.getText().toString());
        PendingIntent actioIntent = PendingIntent.getBroadcast(this, 0, broadcastReceiver, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1)
                .setSmallIcon(R.drawable.ic_baseline_looks_one_24)
                .setContentTitle(edt1.getText().toString())
                .setContentText(edt2.getText().toString())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setColor(Color.GREEN)
                .addAction(R.mipmap.ic_launcher, "Show", actioIntent)
                .build();
        notificationManagerCompat.notify(1, notification);
    }

    public void sendOnChannel2(View view) {
        Notification notification = new Notification.Builder(this, CHANNEL_2)
                .setSmallIcon(R.drawable.ic_baseline_looks_one_24)
                .setContentTitle(edt1.getText().toString())
                .setContentText(edt2.getText().toString())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1, notification);
    }
}