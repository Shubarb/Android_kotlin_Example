package com.example.AndroidAssignment.Assignment10

import androidx.fragment.app.Fragment

class NumberObserver :Number{
    var number: Int = 0
    val observerList: ArrayList<Observer> = ArrayList()

    override fun registerObserver(observer: Observer) {
        observerList.add(observer)
    }

    override fun unRegisterObserver(observer: Observer) {
        observerList.remove(observer)
    }

    override fun notifyObserver() {
        val it : Iterator<Observer> = observerList.iterator()
        while (it.hasNext()){
            val observer = it.next()
            observer.update(number)
        }
    }

    override fun stopObserver() {
        val it : Iterator<Observer> = observerList.iterator()
        while (it.hasNext()){
            val observer = it.next()
            observer.stop()
        }
    }

    fun changeData(num: Int){
        number = num
        notifyObserver()
    }

    fun stop(){
        stopObserver()
    }

}