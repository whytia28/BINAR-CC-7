package com.example.binarchapter7.areaMain

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.binarchapter7.R
import com.example.binarchapter7.logic.Controler
import com.example.binarchapter7.main.MenuActivity
import kotlinx.android.synthetic.main.activity_pemain_vs_cpu.*
import kotlinx.android.synthetic.main.custom_alert_dialog.*
import kotlinx.android.synthetic.main.custom_alert_dialog.view.*


class PemainVsCpu : AppCompatActivity(), PemainVsCpuPresenter.Listener {

    private var pilihanSatu: String = ""
    private var username = MenuActivity.username

    private lateinit var presenter: PemainVsCpuPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemain_vs_cpu)

        presenter = PemainVsCpuPresenter(this)
        pemain1.text = username

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

        iv_restart.setOnClickListener {
            presenter.startNew()
        }
    }

    override fun showResult() {
        val pemenang: String
        if (pilihanSatu != "") {
            val control = Controler()
            val hasilMain = control.caraMainCpu(pilihanSatu)
            pemenang = when (hasilMain) {
                "pemain 1 menang" -> {
                    getString(R.string.selamat_kamu_menang, username)
                }
                "CPU 2 menang" -> {
                    getString(R.string.cpu_menang)
                }
                else -> {
                    getString(R.string.hasil_draw)
                }
            }
            presenter.setCpuOverlay()

            val builder = AlertDialog.Builder(this)
            val dialog = layoutInflater.inflate(R.layout.custom_alert_dialog, null)
            builder.setView(dialog)
            builder.setCustomTitle(hasil)
            dialog.selamat.text = pemenang
            val dialogMessage = builder.create()
            val handler = Handler()
            handler.postDelayed({
                kotlin.run {
                    dialogMessage.show()
                }
            }, 1000)
            dialog.btn_exit.setOnClickListener {
                dialogMessage.dismiss()
            }
        }
    }

    override fun setCpuOverlay() {
        when (Controler.pilihanCpu) {
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
        batu1.foreground = null
        batu2.foreground = null
        kertas1.foreground = null
        kertas2.foreground = null
        gunting1.foreground = null
        gunting2.foreground = null
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
    }

}
