package com.example.binarchapter7.main.ui.history



class HistoryPresenter (private val listener: Listener) {

    fun showAllHistory() {
       listener.showAllHistory()
    }

    interface Listener {
        fun showAllHistory()
        fun setupUi()
    }
}