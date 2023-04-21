package com.michaelvelazquez.despertador

import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val i = Intent(context, DestinationActivity::class.java )
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivities(context, 0, arrayOf(i),0)

        val builder = NotificationCompat.Builder(context!!, "MICHAEL")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("ALARMA DESPERTADORA")
            .setContentText("ES HORA DE IR A ALA UNIVERSIDAD")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)

        val notificationManager =  NotificationManagerCompat.from(context)
        notificationManager.notify(123,builder.build())


    }
}