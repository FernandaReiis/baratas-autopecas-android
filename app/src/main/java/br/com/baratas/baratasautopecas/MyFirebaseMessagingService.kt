package br.com.baratas.baratasautopecas

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Prefs.setString("FB_TOKEN", token!!)
        Log.d("firebase", token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        val notification = remoteMessage?.notification
        if (notification != null) {
            val title = notification.title ?: "titulo vazio"
            val body =  notification.body ?: "corpo vazio"
            Log.d("firebase", title)
            Log.d("firebase", body)
            showNotification(remoteMessage)
        }
    }

    private fun showNotification(remoteMessage: RemoteMessage?) {
        val intent = Intent(this, CustomersActivity::class.java)
        val messageNotification = remoteMessage?.notification
        val messageData = remoteMessage?.data ?: mapOf()
        if (messageNotification != null) {
            val title = messageNotification.title ?: "titulo vazio"
            val body =  messageNotification.body ?: "corpo vazio"
            NotificationUtil.create(1, intent, title, body)
        }

        if (messageData.isNotEmpty()) { //caso de notification com chave e valor
            val mapData = messageData["partId"]
            Log.d("firebase", "Dado: $mapData")
        }

    }

}