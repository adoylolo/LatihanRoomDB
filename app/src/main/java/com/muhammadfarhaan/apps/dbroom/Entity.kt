package com.muhammadfarhaan.apps.dbroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Entity {

    @PrimaryKey(autoGenerate = true)
    private var idAktivis: Int = 0
    @ColumnInfo(name = "Nama")
    private var namaAktivis: String? = null
    @ColumnInfo(name = "Email")
    private var emailAktivis: String? = null
    @ColumnInfo(name = "ZonaTugas")
    private var zonaTugas: String? = null

    fun getIdAktivis(): Int {
        return idAktivis
    }

    fun setIdAktivis(idAktivis: Int) {
        this.idAktivis = idAktivis
    }

    fun getNamaAktivis(): String?{
        return namaAktivis
    }

    fun setNamaAktivis(namaAktivis: String) {
        this.namaAktivis = namaAktivis
    }

    fun getEmailAktivis(): String? {
        return emailAktivis
    }

    fun setEmailAktivis(emailAktivis: String) {
        this.emailAktivis = emailAktivis
    }

    fun getZonaTugas(): String? {
        return zonaTugas
    }

    fun setZonaTugas(zonaTugas: String) {
        this.zonaTugas = zonaTugas
    }
}