package com.project.android.legend.DataClass

data class Question (val textResId: String, val answer: Boolean, var completed: Boolean = false, var cheat : Boolean= false){
}