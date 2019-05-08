package com.example.mactum;

public class Konfigurasi {
    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD = "http://192.168.118.1/Android/tambah_tumbuhan.php";
    public static final String URL_GET_ALL = "http://192.168.118.1/Android/tampil_tumbuhan.php";
    public static final String URL_GET_EMP = "http://192.168.118.1/Android/tampil2_tumbuhan.php?kode_tumbuhan=";


    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "kode_tumbuhan";
    public static final String KEY_EMP_NAMA = "nama_tumbuhan";
    public static final String KEY_EMP_JENIS = "jenis_tumbuhan";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "kode_tumbuhan";
    public static final String TAG_NAMA = "nama_tumbuhan";
    public static final String TAG_JENIS = "jenis_tumbuhan";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}
