package com.ppb.modul5_recyclerview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mahasiswa(
    val fotoMhs: Int = 0,
    val namaMhs: String,
    val nimMhs: String,
    val telpMhs: String
): Parcelable
