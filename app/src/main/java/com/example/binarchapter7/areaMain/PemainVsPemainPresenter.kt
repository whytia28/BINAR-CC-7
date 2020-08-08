package com.example.binarchapter7.areaMain

class PemainVsPemainPresenter(val listener: Listener) {

    fun showResult() {
        listener.showResult()
    }

    fun startNew() {
        listener.startNew()
    }

    fun setOverlay() {
        listener.setOverlay()
    }


    interface Listener {
        fun startNew()
        fun showResult()
        fun setOverlay()
    }
}