<?php 

	
	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	$kode_tumbuhan = $_GET['kode_tumbuhan'];
	
	//Importing database
	require_once('koneksi.php');
	
	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT * FROM tbl_tumbuhan WHERE kode_tumbuhan=$kode_tumbuhan";
	
	//Mendapatkan Hasil 
	$r = mysqli_query($con,$sql);
	
	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"kode_tumbuhan"=>$row['kode_tumbuhan'],
			"nama_tumbuhan"=>$row['nama_tumbuhan'],
			"jenis_tumbuhan"=>$row['jenis_tumbuhan']
		));

	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>