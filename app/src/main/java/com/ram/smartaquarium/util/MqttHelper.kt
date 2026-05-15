package com.ram.smartaquarium.util

import android.content.Context
import android.provider.Settings
import android.util.Log
import info.mqtt.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage

class MqttHelper(context: Context) {

    private val serverURI = "tcp://broker.hivemq.com:1883"
    private val clientId = "AndroidClient_" + Settings.Secure.getString(
        context.contentResolver,
        android.provider.Settings.Secure.ANDROID_ID
    ).toString()


    private val mqttClient = MqttAndroidClient(context, serverURI, clientId)

    private val topicCallbacks = mutableMapOf<String, (String) -> Unit>()

    init {
        // One global callback for *all* topics
        mqttClient.setCallback(object : MqttCallback {
            override fun messageArrived(topic: String?, message: MqttMessage?) {
                val payload = message?.toString() ?: return
                topic?.let {
                    topicCallbacks[topic]?.invoke(payload)
                    Log.d("MQPROT", "topic $topic subscription successfull :  ")
                }
            }

            override fun connectionLost(cause: Throwable?) {
                Log.d("MQPROT", "subscribeToTopics connection lost : ${cause?.message}")
            }
            override fun deliveryComplete(token: IMqttDeliveryToken?) {
                Log.d("MQPROT", "${token?.client}subscribeToTopics connection lost : $token")
            }
        })
    }

    fun connect(onConnected: () -> Unit) {
        val options = MqttConnectOptions().apply {
            isAutomaticReconnect = true
            isCleanSession = true
            connectionTimeout = 10
            keepAliveInterval = 20
        }

        mqttClient.connect(options, null, object : IMqttActionListener {
            override fun onSuccess(asyncActionToken: IMqttToken?) {
                onConnected()
                Log.d("MQPROT", "onSuccess: success : ${asyncActionToken?.client}")
            }
            override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                Log.d("MQPROT", "onFailure: reason : ${exception?.message} ${exception?.localizedMessage}")
            }
        })
    }

    fun subscribe(topic: String, callback: (String) -> Unit) {
        topicCallbacks[topic] = callback
        mqttClient.subscribe(topic, 0)
    }

    fun publish(topic: String, message: String, canRetain: Boolean) {
        mqttClient.publish(topic, message.toByteArray(), 1, canRetain)
    }
}