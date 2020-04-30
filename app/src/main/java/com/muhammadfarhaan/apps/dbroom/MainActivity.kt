package com.muhammadfarhaan.apps.dbroom

import androidx.room.Room
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.ArrayList
import android.widget.Toast

/*
* Tanggal Pengerjaan  : 30-April-2020
* Deskripsi Pekerjaan : Mengimpleentasi room database ke gradle package.
*                       Membuat class Entity, interface Dao, class abstract Database, dan activity MainActivity.
*                       Membuat deklarasi kolom info yaitu Id, Nama, Email, dan ZonaTugas serta membuat getter-setter nya
*                       di class Entity.
*                       Membuat fungsi tambahAktivis, hapusAktivis, tampilSeluruhAktivis, dan findByZone pada interface
*                       Dao.
*                       Membuat fungsi aktivisDao pada class abstract Database untuk menghubungkan fungsi-fungsi
*                       di interface Dao dengan Database.
*                       Membuat fungsi-fungsi pada MainActivity untuk :
*                           - Tambah Data
*                           - Tampil Seluruh Data
*                           - Tampil Data Berdasarkan Zona
* NIM                 : 10117145
* Nama                : Muhammad Farhaan
* Kelas               : IF-4
* */

class MainActivity : AppCompatActivity() {

    private lateinit var db: Database
    private lateinit var aktivisEntity: Entity

    //Atribut untuk mendisplay hasil data
    internal var aktivisEntities: List<Entity> = ArrayList<Entity>()
    internal var aktivisEntityListByZone: List<Entity> = ArrayList<Entity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            Database::class.java, "aktivis"
        )
            .allowMainThreadQueries().build()

        //TAMBAH DATA
        aktivisEntity = Entity()
        aktivisEntity.setNamaAktivis("Muhammad Farhaan")
        aktivisEntity.setEmailAktivis("adoysuaan@mahasiswa.unikom.ac.id")
        aktivisEntity.setZonaTugas("Bandung Barat")

        Log.d("TAMBAH", "Tambah Data Aktivis")
        Log.d("TAMBAH", "===================")
        Log.d("TAMBAH", "Nama : " + aktivisEntity.getNamaAktivis())
        Log.d("TAMBAH", "Email : " + aktivisEntity.getEmailAktivis())
        Log.d("TAMBAH", "Zona : " + aktivisEntity.getZonaTugas())

        db.aktivisDao().tambahAktivis(aktivisEntity)
        Toast.makeText(this, "Data Sudah Tersimpan di Database", Toast.LENGTH_SHORT).show()

        //TAMPIL SELURUH DATA
        Log.d("TAMPIL", "Tampil seluruh data aktivis")
        Log.d("TAMPIL", "===========================")

        aktivisEntities = db.aktivisDao().tampilSeluruhAktivis()

        for (i in aktivisEntities.indices) {

            Log.d("TAMPIL", "Data Ke-" + (i + 1))
            Log.d("TAMPIL", "Nama : " + aktivisEntities[i].getNamaAktivis())
            Log.d("TAMPIL", "Email : " + aktivisEntities[i].getEmailAktivis())
            Log.d("TAMPIL", "Zona : " + aktivisEntities[i].getZonaTugas())
            Log.d("TAMPIL", "========================")
        }

        //TAMPIL BERDASARKAN ZONA
        Log.e("ZONE", "Data Aktivis berdasarkan Zona")
        Log.e("ZONE", "===================")
        aktivisEntityListByZone = db.aktivisDao().findByZone("Bandung Barat")
        for (i in aktivisEntityListByZone.indices) {
            Log.e("ZONE", "Data Aktivis Ke-" + (i + 1))
            Log.e("ZONE", aktivisEntityListByZone[i].getNamaAktivis())
            Log.e("ZONE", aktivisEntityListByZone[i].getEmailAktivis())
            Log.e("ZONE", aktivisEntityListByZone[i].getZonaTugas())
            Log.e("ZONE", "===================")

        }
    }
}
