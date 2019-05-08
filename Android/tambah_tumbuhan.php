<?php

 

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$kode_tumbuhan = $_POST['kode_tumbuhan'];
		$nama_tumbuhan = $_POST['nama_tumbuhan'];
		$jenis_tumbuhan = $_POST['jenis_tumbuhan'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tbl_tumbuhan (kode_tumbuhan,nama_tumbuhan,jenis_tumbuhan) VALUES ('$kode_tumbuhan','$nama_tumbuhan','$jenis_tumbuhan')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Tumbuhan';
		}else{
			echo 'Gagal Menambahkan Tumbuhan';
		}
		
		mysqli_close($con);
	}
?>