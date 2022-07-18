package com.besheger.nu

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.besheger.nu.ui.theme.NuTheme
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity(),LocationListener, SensorEventListener {

    private var sensorManager: SensorManager? = null

    private var running = false
    private var totalSteps = 0f

    private var previousTotalSteps = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            setContent {
            NuTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainPoint("Android")
                }
            }
        }
    }

    override fun onLocationChanged(p0: Location) {
        TODO("Not yet implemented")
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        TODO("Not yet implemented")

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }

}



@Composable
private fun MapOpt(){
    val singapore=LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 17f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ){
        Marker(position =singapore,
        title = "Singapore",
        snippet = "Mark In singapore")
    }
}


@Composable
fun MainPoint(name: String) {
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()){
        MapOpt2()
    }
}
@Composable
fun MapOpt2(){
    val singapore = LatLng(1.356667, 103.878875)
    val sydney = LatLng(1.356667, 103.878874)




    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 17f)
    }

    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState
        ){
            cameraPositionState.move(CameraUpdateFactory.newLatLng(singapore))
            marker(locations=singapore)
            marker(locations=sydney)

        }
        Button(
            onClick = {
               cameraPositionState.move(CameraUpdateFactory.newLatLng(sydney))



            }
        ) {
            Text(text = "Animate camera to Sydney")
        }
    }
}
@Composable
 fun marker(locations:LatLng){
    Marker(position =locations,
        title = "Singapore",
        snippet = "Mark In Singapore")
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NuTheme {
        MainPoint("Android")
    }
}


