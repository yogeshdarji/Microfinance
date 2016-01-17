<?php

	$con = mysql_connect("local","my_user","my_password","my_db");


	$password = $_POST["password"];
	$username = $_POST["username"];


	$statement = mysql_prepare($con,"SELECT * FROM User WHERE username = ? AND password = ?);
	mysqli_stmt_bind_param($statement, "ss", $username, $password);

	mysqli_stmt_excute($statement);
	mysqli_stmt_store_result($statement, $userID, $name, $age, $ssn, $email, $username , $password);

	$user = array();

	while(mysqli_stmt_fetch($statement)){


      $user[name] = $name;
      $user[age] = $age;
      $user[ssn] = $ssn;
       $user[username] = $username;
        $user[password] = $password;

}

	echo json_encode($user)

	mysqli_stmt_close($statement);



mysql_close($con);

?>
