package app.tangkihan.com.mengenalbuah

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lv:ListView = findViewById(R.id.listview)
        val adapter = ListViewAdapter(this)
        lv.adapter = adapter

        lv.setOnItemClickListener{parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            val suara = ListViewAdapter(this@MainActivity).suaraBuah.get(position)
            putarSuara(suara)

            val nama = ListViewAdapter(this@MainActivity).listBuah.get(position)
            val gambar = ListViewAdapter(this@MainActivity).gmbrBuah.get(position)
            val intent = Intent(this@MainActivity, DetailBuah::class.java)
            intent.putExtra("namaBuah", nama)
            intent.putExtra("gambarBuah", gambar)
            startActivity(intent)
        }
    }

    private fun putarSuara(suara: Int) {
        val uri = Uri.parse("android.resource://$packageName/$suara")
        val player = MediaPlayer()
        player.setDataSource(this@MainActivity, uri)
        player.prepare()
        player.start()
    }
}

class ListViewAdapter(context: Context) : BaseAdapter() {

    val listBuah = arrayOf( "Alpukat", "Apel",  "Cerry", "Durian", "Jambu Air", "Manggis", "Strawberry" )
    var gmbrBuah = arrayOf(R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry)
    val suaraBuah = arrayOf( R.raw.alpukat, R.raw.apel,  R.raw.ceri, R.raw.durian,  R.raw.jambuair, R.raw.manggis, R.raw.strawberry )
    val mInflater : LayoutInflater
    init {
        this.mInflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        view = this.mInflater.inflate(R.layout.content_buah, parent, false)

        val buah = listBuah.get(position)
        val txtNmBuah = view.findViewById<TextView>(R.id.namaBuah)
        txtNmBuah.text = buah

        val imgBuah = gmbrBuah.get(position)
        val gambar = view.findViewById<ImageView>(R.id.img)
        gambar.setImageResource(imgBuah)

        return view
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return listBuah.size
    }

}