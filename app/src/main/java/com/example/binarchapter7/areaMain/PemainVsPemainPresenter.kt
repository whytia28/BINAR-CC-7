package com.example.binarchapter7.areaMain




import java.text.SimpleDateFormat
import java.util.*

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


    fun saveHistory() {
        listener.saveHistory()
    }

    fun getCurrentDate() : String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date = Date()

        return dateFormat.format(date)
    }


    interface Listener {
        fun startNew()
        fun showResult()
        fun setOverlay()
        fun saveHistory()
    }
}