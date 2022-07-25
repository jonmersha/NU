package com.besheger.nu.ui.widjet

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.besheger.nu.model.nu_action



@Composable
fun RightSideColumn(symbol:String,modifier:Modifier,onAction:nu_action){
            MyButton(
                symbol = symbol,
                modifier =modifier,
                onAction = {onAction} )




}