package com.ppb.modul5_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ppb.modul5_recyclerview.adapter.GridMahasiswaAdapter
import com.ppb.modul5_recyclerview.adapter.ListMahasiswaAdapter
import com.ppb.modul5_recyclerview.model.DataMahasiswa
import com.ppb.modul5_recyclerview.model.Mahasiswa

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val dataMahasiswa: List<Mahasiswa> = DataMahasiswa.dataMahasiswa
    private val dataDuplikat: List<Mahasiswa> = dataMahasiswa + dataMahasiswa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.RV_Mahasiswa)
        recyclerView.setHasFixedSize(true)

        //List Mode
//        showListMahasiswa()

        //Grid Mode
        showGridMahasiswa()
    }

    private fun showListMahasiswa() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListMahasiswaAdapter(this, dataMahasiswa)
    }

    private fun showGridMahasiswa() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = GridMahasiswaAdapter(dataDuplikat)
    }
}