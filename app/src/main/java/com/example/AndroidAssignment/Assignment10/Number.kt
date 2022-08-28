package com.example.AndroidAssignment.Assignment10

import androidx.fragment.app.Fragment

interface Number {
    fun registerObserver(observer: Observer)
    fun unRegisterObserver(observer: Observer)
    fun notifyObserver()
    fun stopObserver()
}