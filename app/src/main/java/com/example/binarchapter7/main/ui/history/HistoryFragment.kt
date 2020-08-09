package com.example.binarchapter7.main.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binarchapter7.R
import com.example.binarchapter7.adapter.AdapterHistory
import com.example.binarchapter7.database.Battle
import com.example.binarchapter7.database.BattleDatabase
import com.example.binarchapter7.main.MenuActivity
import com.example.binarchapter7.pojo.PostLoginResponse
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HistoryFragment : Fragment(), HistoryPresenter.Listener {

    private lateinit var historyViewModel: HistoryViewModel
    private lateinit var presenter: HistoryPresenter
    private var battleDb : BattleDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historyViewModel =
            ViewModelProvider(this).get(HistoryViewModel::class.java)
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context  = view.context as MenuActivity


        context.supportActionBar?.title = getString(R.string.history)
        presenter = HistoryPresenter(this)
        battleDb = BattleDatabase.getInstance(context)



        rv_history_battle.layoutManager = LinearLayoutManager(context)
        rv_history_battle.setHasFixedSize(true)
        presenter.showAllHistory()
    }

    override fun showAllHistory() {

        GlobalScope.launch {
           val listHistory = battleDb?.battleDao()?.getAllBattle()
            activity?.runOnUiThread {
               listHistory?.let {
                   val adapter = AdapterHistory(it)
                   rv_history_battle.adapter = adapter
//                   tv_history_empty.visibility = View.GONE
               }
            }
        }
    }

    override fun setupUi() {

    }


}