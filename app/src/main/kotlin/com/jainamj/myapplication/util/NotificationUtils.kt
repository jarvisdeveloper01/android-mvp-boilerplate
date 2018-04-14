package com.jainamj.myapplication.util


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import com.jainamj.myapplication.R
import com.jainamj.myapplication.ui.splash.view.SplashActivity
import timber.log.Timber
import java.util.*

private const val CHANNEL_MESSAGES = "Messages"

class NotificationUtils(context: Context) : ContextWrapper(context) {

    companion object {
        var instance: NotificationUtils? = null
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            Timber.e("NotificationUtils: " + manager.getNotificationChannel(CHANNEL_MESSAGES))

            if (manager.getNotificationChannel(CHANNEL_MESSAGES) == null) {
                createChannel(CHANNEL_MESSAGES)
            }
        }
        instance = this
    }

    private var mManager: NotificationManager? = null

    /**
     * This method returns a unique id for each notification according to the timestamp
     *
     * @return int: unique id for each notification
     */
    private val uniqueIdForNotification: Int
        get() {
            val tmpStr = Date().time.toString()
            val last4Str = tmpStr.substring(tmpStr.length - 5)
            return Integer.valueOf(last4Str)
        }

    /**
     * get notification manager
     *
     * @return NotificationManager
     */
    private val manager: NotificationManager
        get() {
            if (mManager == null) {
                mManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            }
            return mManager as NotificationManager
        }

    /**
     * create channels according to passed channel names
     *
     * @param channelName name of channel to be created
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun createChannel(channelName: String) {
        // create android channel
        val androidChannel = NotificationChannel(getChannelId(channelName),
                channelName, NotificationManager.IMPORTANCE_DEFAULT)
        // Sets whether notifications posted to this channel should display notification lights
        androidChannel.enableLights(true)
        // Sets whether notification posted to this channel should vibrate.
        androidChannel.enableVibration(true)
        // Sets the notification light color for notifications posted to this channel
        androidChannel.lightColor = Color.BLUE
        // Sets whether notifications posted to this channel appear on the lockscreen or not
        androidChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC

        manager.createNotificationChannel(androidChannel)
    }

    /**
     * return channel id from channel name by appending package path to channel name
     *
     * @param channelName Sring
     * @return channel id from channel name
     */
    private fun getChannelId(channelName: String): String = "$packageName.$channelName"

    /**
     * This method creates notification for delivery note as per passed title and body text
     *
     * @param title Title String for notification
     * @param body  Body string for notification
     */
    fun postNotification(title: String, body: String) {

        val notification: Notification
        val contentIntent: PendingIntent
        val channelName: String = CHANNEL_MESSAGES

        val intent = Intent(this, SplashActivity::class.java) // todo: change splash activity to dashboard activity
        contentIntent = PendingIntent.getActivity(this, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = Notification.Builder(this, getChannelId(channelName))
                    .setContentTitle(title)
                    .setContentText(body)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setGroup(getChannelId(channelName))
                    .setGroupSummary(true)
                    .setContentIntent(contentIntent)
                    .setAutoCancel(true)
                    .build()
        } else {
            notification = NotificationCompat.Builder(applicationContext, getChannelId(channelName))
                    .setContentTitle(title)
                    .setContentText(body)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setGroup(getChannelId(channelName))
                    .setGroupSummary(true)
                    .setContentIntent(contentIntent)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setAutoCancel(true)
                    .build()
        }

        manager.notify(channelName, uniqueIdForNotification, notification)

    }

}

