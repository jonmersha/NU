package com.besheger.nu.ui.widjet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.besheger.nu.model.nu_action

@Composable
fun MyButton(
    symbol:String,
    modifier: Modifier,
    onAction:(nu_action)->Unit

){
    Box(
        contentAlignment = Alignment.Center,

        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Gray)
            .width(60.dp)
            .height(60.dp)
            .padding(all=5.dp)
            .clickable {onAction }
            .then(modifier)
    ){
        Text(
            text = symbol,
            fontSize = 26.sp,
            color=Color.White)
    }
}