package com.example.binarchapter7.profil

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binarchapter7.R
import com.example.binarchapter7.database.BattleDatabase
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private var battleDb: BattleDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        showProfile()
        fetchMemo()
        btn_back.setOnClickListener(this)
        fab_add.setOnClickListener(this)

        battleDb = BattleDatabase.getInstance(this)

        rv_memo.layoutManager = LinearLayoutManager(this)
        rv_memo.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        fetchMemo()
    }

    private fun showProfile() {
        val sharedPreferences = getSharedPreferences("suitGame", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "Email")
        val name = sharedPreferences.getString("name", "Name")

        et_email.setText(email)
        et_password.setText(name)
    }

    private fun fetchMemo() {

        GlobalScope.launch {
            val listMemo = battleDb?.battleDao()?.getAllBattle()
            runOnUiThread {
                listMemo?.let {
//                    val adapter =
//                        AdapterMemo(it)
//                    rv_memo.adapter = adapter
                }
            }
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_back -> {
                onBackPressed()
            }
            R.id.fab_add -> {
//                val pop = MemoFragment()
//                    .newInstance()
//                val fragmentManager = supportFragmentManager
//                pop.show(fragmentManager, "fragment_dialog")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        BattleDatabase.destroyInstance()
    }
}