package com.ppb.modul5_recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ppb.modul5_recyclerview.CardViewDetailActivity
import com.ppb.modul5_recyclerview.R
import com.ppb.modul5_recyclerview.model.Mahasiswa

class ListMahasiswaAdapter(
    private val context: Context,
    private val mahasiswaList: List<Mahasiswa>,
    private val listener: (Mahasiswa) -> Unit
): RecyclerView.Adapter<ListMahasiswaAdapter.ListViewHolder>() {

    inner class ListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val cardView: CardView = view.findViewById(R.id.list_view)
        private val fotoMhs: ImageView = view.findViewById(R.id.img_item_photo)
        private val namaMhs: TextView = view.findViewById(R.id.nama_mahasiswa)
        private val nimMhs: TextView = view.findViewById(R.id.nim_mahasiswa)
        private val telp: TextView = view.findViewById(R.id.telp_mahasiswa)

        fun bindView(mhs: Mahasiswa, listener: (Mahasiswa) -> Unit) {

            cardView.setOnClickListener {
                listener(mhs)
                val intent = Intent(context, CardViewDetailActivity::class.java)
                intent.putExtra("nama_mhs", mhs.namaMhs)
                intent.putExtra("nim_mhs", mhs.nimMhs)
                intent.putExtra("telp_mhs", mhs.telpMhs)
                context.startActivity(intent)
            }

            fotoMhs.setImageResource(mhs.fotoMhs)
            namaMhs.text = mhs.namaMhs
            nimMhs.text = mhs.nimMhs
            telp.text = mhs.telpMhs
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_mahasiswa_layout, parent, false)
        )
    }

    override fun getItemCount() : Int = mahasiswaList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindView(mahasiswaList[position], listener)
    }
}