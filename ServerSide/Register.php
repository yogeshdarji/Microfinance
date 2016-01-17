<?php

	$con = mysql_connect("local","my_user","my_password","my_db");

	$name = $_POST["name"];
	$age  = $_POST["age"];
	$ssn  = $_POST["ssn"];
	$email = $_POST["email"];
	$password = $_POST["password"];
	$username = $_POST["username"];


	$statement = mysql_prepare($con,"INSERT INTO User (name, age,ssn, email, username, password) VALUES (?, ?, ?, ?, ?, ?)");
	mysqli_stmt_bind_param($statement, "sissss",$name,$age,$ssn,$email,$password,$username );
	
	mysqli_stmt_excute($statement);

	mysqli_stmt_close($statement);



	mysql_close($con);

	?>
