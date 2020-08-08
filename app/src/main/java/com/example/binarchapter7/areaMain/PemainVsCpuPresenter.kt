package com.example.binarchapter7.areaMain


class PemainVsCpuPresenter(private val listener: Listener) {

    fun showResult() {
        listener.showResult()
    }

    fun startNew() {
        listener.startNew()
    }

    fun setOverlay() {
        listener.setOverlay()
    }

    fun setCpuOverlay() {
        listener.setCpuOverlay()
    }

    interface Listener {
        fun startNew()
        fun setOverlay()
        fun showResult()
        fun setCpuOverlay()
    }
}