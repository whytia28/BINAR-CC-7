package com.example.binarchapter7.areaMain


import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.binarchapter7.R
import com.example.binarchapter7.logic.Controler
import com.example.binarchapter7.main.MenuActivity
import kotlinx.android.synthetic.main.activity_pemain_vs_pemain.*
import kotlinx.android.synthetic.main.custom_alert_dialog.*
import kotlinx.android.synthetic.main.custom_alert_dialog.view.*

class PemainVsPemain : AppCompatActivity(), PemainVsPemainPresenter.Listener {

    private var pilihanSatu: String = ""
    private var pilihanDua: String = ""
    private var username = MenuActivity.username

    private lateinit var presenter: PemainVsPemainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemain_vs_pemain)

        pemain1.text = username
        presenter = PemainVsPemainPresenter(this)

        batu1.setOnClickListener {
            pilihanSatu = Controler.pilihanGame[0]
            presenter.setOverlay()
            presenter.showResult()
        }
        kertas1.setOnClickListener {
            pilihanSatu = Controler.pilihanGame[1]
            presenter.setOverlay()
            presenter.showResult()
        }
        gunting1.setOnClickListener {
            pilihanSatu = Controler.pilihanGame[2]
            presenter.setOverlay()
            presenter.showResult()
        }
        batu2.setOnClickListener {
            pilihanDua = Controler.pilihanGame[0]
            presenter.showResult()
            presenter.setOverlay()
        }
        kertas2.setOnClickListener {
            pilihanDua = Controler.pilihanGame[1]
            presenter.showResult()
            presenter.setOverlay()
        }
        gunting2.setOnClickListener {
            pilihanDua = Controler.pilihanGame[2]
            presenter.showResult()
            presenter.setOverlay()
        }
        iv_restart.setOnClickListener {
            presenter.startNew()
        }
    }

    override fun showResult() {
        val pemenang: String
        if (pilihanSatu != "" && pilihanDua != "") {
            val control = Controler()
            val hasilMain = control.caraMain(pilihanSatu, pilihanDua)
            pemenang = when (hasilMain) {
                "pemain 1 menang" -> {
                    getString(R.string.selamat_kamu_menang, username)
                }
                "pemain 2 menang" -> {
                    getString(R.string.selamat_pemain_2_menang)
                }
                else -> {
                    getString(R.string.hasil_draw)
                }
            }
            val builder = AlertDialog.Builder(this)
            val dialog = layoutInflater.inflate(R.layout.custom_alert_dialog, null)
            builder.setView(dialog)
            builder.setCustomTitle(hasil)
            dialog.selamat.text = pemenang
            val dialogMessage = builder.create()
            dialogMessage.show()
            dialog.btn_exit.setOnClickListener {
                dialogMessage.dismiss()
            }
        }

    }

    override fun setOverlay() {

        when (pilihanSatu) {
            Controler.pilihanGame[0] -> {
                batu1.foreground = resources.getDrawable(R.drawable.overlay, null)
            }
            Controler.pilihanGame[1] -> {
                kertas1.foreground = resources.getDrawable(R.drawable.overlay, null)
            }
            Controler.pilihanGame[2] -> {
                gunting1.foreground = resources.getDrawable(R.drawable.overlay, null)
            }
        }
        when (pilihanDua) {
            Controler.pilihanGame[0] -> {
                batu2.foreground = resources.getDrawable(R.drawable.overlay, null)
            }
            Controler.pilihanGame[1] -> {
                kertas2.foreground = resources.getDrawable(R.drawable.overlay, null)
            }
            Controler.pilihanGame[2] -> {
                gunting2.foreground = resources.getDrawable(R.drawable.overlay, null)
            }
        }
    }

    override fun startNew() {
        pilihanSatu = ""
        pilihanDua = ""
        batu1.foreground = null
        batu2.foreground = null
        kertas1.foreground = null
        kertas2.foreground = null
        gunting1.foreground = null
        gunting2.foreground = null
    }

}
