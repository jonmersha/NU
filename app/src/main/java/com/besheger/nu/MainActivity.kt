package com.besheger.nu

import android.Manifest
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.lifecycle.viewmodel.compose.viewModel
import com.besheger.nu.ui.theme.NuTheme
import com.besheger.nu.viewmodel.MyViewModel
import java.lang.Exception

class MainActivity : ComponentActivity(),SensorEventListener{
    var model: MyViewModel? =null
    var activity:MapActivity?=null
    private var totalSteps=0f
    private var previousTotalSteps=0f



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    // Precise location access granted.
                }
                permissions.getOrDefault(Manifest.permission.ACTIVITY_RECOGNITION,false)->{}
                permissions.getOrDefault(Manifest.permission.SEND_RESPOND_VIA_MESSAGE,false)->{}
                permissions.getOrDefault(Manifest.permission.READ_CONTACTS,false)->{}
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {} else -> {

            }
            }
        }

        locationPermissionRequest.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACTIVITY_RECOGNITION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.SEND_RESPOND_VIA_MESSAGE
            ),

        )


        setContent {
            NuTheme {
              model = viewModel<MyViewModel>()
                activity= MapActivity(model= model!!, activity = this)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    activity!!.MainPoint("Android")
                }
            }
        }

        }

    override fun onResume() {
        super.onResume()

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if(sensor==null){
            Toast.makeText(this,"No Sensor Detected", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Sensors Detected", Toast.LENGTH_LONG).show()
            sensorManager?.registerListener(this,sensor, SensorManager.SENSOR_DELAY_UI)
        }

    }
    override fun onSensorChanged(event: SensorEvent?) {
        totalSteps=event!!.values[0]
        val currentStep =totalSteps.toInt()-previousTotalSteps.toInt()

        activity?.counter(currentStep)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }


}


//    @Preview(showBackground = true)
//    @Composable
//    fun DefaultPreview() {
//        NuTheme {
//            MainPoint("Android",m)
//        }
//    }





