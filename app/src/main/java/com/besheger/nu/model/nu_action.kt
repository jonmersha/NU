package com.besheger.nu.model

sealed class nu_action {
    data class Nu_Actions(val number:Int):nu_action()
    object Contact:nu_action(){
    }

}