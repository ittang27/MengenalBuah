package app.tangkihan.com.mengenalbuah

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detailbuah.*


/**
 * Created by Ittang#27 on 28/01/2018.
 */
class DetailBuah : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailbuah)

        val namaBuah = intent.getStringExtra("namaBuah")
        val gambarBuah = intent.getIntExtra("gambarBuah", 0)

        txtDetail.text = namaBuah
        imgGambar.setImageResource(gambarBuah)

    }


}