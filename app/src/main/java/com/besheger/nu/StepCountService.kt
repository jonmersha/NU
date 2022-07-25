package com.besheger.nu

import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationListener
import android.os.IBinder
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.besheger.nu.viewmodel.MyViewModel

class StepCountService : Service(),SensorEventListener,LocationListener {

    override fun onBind(intent: Intent): IBinder? {
       return null

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if(sensor==null){
            Toast.makeText(this,"No Sensor Detected",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Sensors Detected",Toast.LENGTH_LONG).show()
            sensorManager?.registerListener(this,sensor,SensorManager.SENSOR_DELAY_UI)
        }
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onSensorChanged(event: SensorEvent) {
       // Toast.makeText(this, "sensor Change",Toast.LENGTH_LONG).show()
      //  model.totalStep(step=1.1F)

    }
    @Composable
    fun counterUpdate(){
       // model= viewModel<MyViewModel>()
    }
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onLocationChanged(p0: Location) {

    }
}