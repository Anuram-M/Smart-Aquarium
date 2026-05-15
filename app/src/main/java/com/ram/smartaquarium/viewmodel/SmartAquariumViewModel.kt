package com.ram.smartaquarium.viewmodel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.ram.smartaquarium.util.MqttHelper
import com.ram.smartaquarium.util.MqttTopics
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SmartAquariumViewModel(application: Application) : AndroidViewModel(application) {

    val mqttHelper = MqttHelper(application)

    private val _mqttLightState = MutableStateFlow("0")
    val mqttLightState = _mqttLightState.asStateFlow()

    private val _mqttFilterState = MutableStateFlow("0")
    val mqttFilterState = _mqttFilterState.asStateFlow()

    private val _mqttPweerState = MutableStateFlow("0")
    val mqttPowerState = _mqttPweerState.asStateFlow()

    val _lightValue = mutableStateOf(false)
    val lightValueChanged = _lightValue.value
    val _filterValue = mutableStateOf(false)
    val filterValueChanged = _filterValue.value
    init {
        mqttHelper.connect {
            Log.d("MQPROT", "onconnected callback : ")
            subscribeToTopics()
        }
    }

    private fun subscribeToTopics() {
        Log.d("MQPROT", "subscribeToTopics: before calling the topics")
        mqttHelper.subscribe(MqttTopics.LIGHT) { value ->
            _lightValue.value = true
            Log.d("MQPROT", "subscribeToTopics light: got value ")
            if (!value.isNullOrEmpty()) {
                _mqttLightState.value = value
//                Toast.makeText(application, "Light value $value", Toast.LENGTH_SHORT).show()
                Log.d("MQPROT", "subscribeToTopics light: got a valid value : $value ")
            }
        }

        mqttHelper.subscribe(MqttTopics.FILTER) { value ->
            _filterValue.value = true
            Log.d("MQPROT", "subscribeToTopics filter: got value ")
            if (!value.isNullOrEmpty()) {
                _mqttFilterState.value = value
                Log.d("MQPROT", "subscribeToTopics filter: got a valid value : $value")
            }
        }

        mqttHelper.subscribe(MqttTopics.POWER) { value ->
            if(!value.isNullOrEmpty()) {
                _mqttPweerState.value = value
                Log.d("MQPROT", "subscribeToTopics power: got a valid value : $value ")
            }

        }

    }

    fun updateLight(newValue: String) {
        mqttHelper.publish(MqttTopics.LIGHT, newValue, true)
    }

    fun updateFilter(newValue: String) {
        mqttHelper.publish(MqttTopics.FILTER, newValue, true)
    }

    fun updatePower(newValue: String) {
        mqttHelper.publish(MqttTopics.POWER, newValue, true)
    }
}

//class MqttViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val mqtt = MqttHelper(application)
//
//    private val _lightState = MutableStateFlow("0")
//    val lightState = _lightState.asStateFlow()
//
//    private val _filterState = MutableStateFlow("0")
//    val filterState = _filterState.asStateFlow()
//
//    init {
//        mqtt.connect {
//            subscribeToTopics()
//        }
//    }
//
//    private fun subscribeToTopics() {
//        mqtt.subscribe("myAquarium/relay/light") { value ->
//            _lightState.value = value
//        }
//
//        mqtt.subscribe("myAquarium/relay/filter") { value ->
//            _filterState.value = value
//        }
//    }
//
//    fun toggleLight(newValue: String) {
//        mqtt.publish("myAquarium/relay/light", newValue)
//    }
//
//    fun toggleFilter(newValue: String) {
//        mqtt.publish("myAquarium/relay/filter", newValue)
//    }
//}