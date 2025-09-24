package edu.zsk.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.PendingIntent;
import android.widget.Button;
import android.app.NotificationManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID_HIGH = "high_priority_channel";
    private static final String CHANNEL_ID_LOW = "low_priority_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createNotificationChannels();

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(v -> {
            showHighPriorityNotification();
        });

        btn2.setOnClickListener(v -> {
            showLowPriorityNotification();
        });
    }

    private void showHighPriorityNotification() {
        Intent intent = new Intent(this, Activity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        Notification notification = new Notification.Builder(this, CHANNEL_ID_HIGH)
                .setContentTitle("High Priority ")
                .setContentText("kliknij")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    private void showLowPriorityNotification() {
        Intent intent = new Intent(this, Activity3.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        Notification notification = new Notification.Builder(this, CHANNEL_ID_LOW)
                .setContentTitle("Low Priority ")
                .setContentText("klilknij")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(Notification.PRIORITY_LOW)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(2, notification);
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence highPriorityName = "High Priority ";
            String highPriorityDescription = "tu jest High Priority";
            int highPriorityImportance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel highPriorityChannel = new NotificationChannel(CHANNEL_ID_HIGH, highPriorityName, highPriorityImportance);
            highPriorityChannel.setDescription(highPriorityDescription);

            CharSequence lowPriorityName = "Low Priority ";
            String lowPriorityDescription = "tu jest Low Priority";
            int lowPriorityImportance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel lowPriorityChannel = new NotificationChannel(CHANNEL_ID_LOW, lowPriorityName, lowPriorityImportance);
            lowPriorityChannel.setDescription(lowPriorityDescription);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(highPriorityChannel);
            notificationManager.createNotificationChannel(lowPriorityChannel);
        }
    }
}
