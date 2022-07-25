package com.besheger.nu.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var number : Int by mutableStateOf(0)
        private set
    var stepCount : Float by mutableStateOf(0.0F)
        private set



    fun addNumber(counter:Int){
        number=counter
    }
    fun totalStep(step:Float){
       // stepCount=step
    }

}