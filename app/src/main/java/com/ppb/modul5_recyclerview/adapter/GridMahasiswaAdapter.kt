package com.ppb.modul5_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ppb.modul5_recyclerview.R
import com.ppb.modul5_recyclerview.model.Mahasiswa

class GridMahasiswaAdapter(private val mahasiswaList: List<Mahasiswa>): RecyclerView.Adapter<GridMahasiswaAdapter.GridViewHolder>() {

    class GridViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val fotoMhs: ImageView = view.findViewById(R.id.id_grid)

        fun bindView(mhs: Mahasiswa) {
            fotoMhs.setImageResource(mhs.fotoMhs)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.grid_mahasiswa_layout, parent, false)

        return GridViewHolder(view)
    }

    override fun getItemCount() : Int = mahasiswaList.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bindView(mahasiswaList[position])
    }
}