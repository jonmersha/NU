package com.besheger.nu.ui.widjet

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.besheger.nu.model.nu_action


    @Composable
    fun BottomContainer(modifier:Modifier) {

        Row(modifier = modifier) {
            MyButton(
                symbol = "AC",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(70.dp)
                    .width(70.dp),
                onAction= {nu_action.Contact} )
            MyButton(
                symbol = "AC",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(70.dp)
                    .width(70.dp),
                onAction= {nu_action.Contact} )
            MyButton(
                symbol = "AC",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(70.dp)
                    .width(70.dp),
                onAction= {nu_action.Contact} )
            MyButton(
                symbol = "AC",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(70.dp)
                    .width(70.dp),
                onAction= {nu_action.Contact} )

        }

    }
