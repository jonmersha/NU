package com.besheger.nu


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.besheger.nu.model.nu_action
import com.besheger.nu.ui.widjet.BottomContainer
import com.besheger.nu.ui.widjet.RightSideColumn
import com.besheger.nu.viewmodel.MyViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

class MapActivity(val model: MyViewModel,val activity:MainActivity) {
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @Composable
    fun MainPoint(name: String) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            MapOpt2()
        }
    }

    @Composable
    fun MapOpt2() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)

        val singapore = LatLng(1.356667, 103.878875)
        val sydney = LatLng(1.356667, 103.878874)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(singapore, 17f)
        }
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Box(Modifier.fillMaxSize().weight(1f)) {
                GoogleMap(
                    modifier = Modifier.matchParentSize(),
                    cameraPositionState = cameraPositionState
                ) {
                    cameraPositionState.move(CameraUpdateFactory.newLatLng(singapore))
                    marker(locations = singapore)
                    marker(locations = sydney)

                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Step: ${model.number}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black,
                        fontSize = 70.sp
                    )
                    Column(modifier = Modifier.align(Alignment.End)) {
                        RightSideColumn(
                            symbol = "Add",
                            modifier = Modifier
                                .clip(CircleShape)
                                .width(100.dp),
                            onAction = nu_action.Contact
                        )

                        RightSideColumn(
                            symbol = "USer",
                            modifier = Modifier.clip(CircleShape),
                            onAction = nu_action.Contact
                        )
                    }


                }

            }
           // Spacer(modifier = Modifier.weight(1f))

            BottomContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            )


        }


    }

    @Composable
    fun marker(locations: LatLng) {
        Marker(
            position = locations,
            title = "Singapore",
            snippet = "Mark In Singapore"
        )
    }

    fun counter(counter: Int) {
        model.addNumber(counter = counter)
    }




}