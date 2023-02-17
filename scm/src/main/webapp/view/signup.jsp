<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Sign Up Page</title>
<link rel="stylesheet" href="signup.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
	rel="stylesheet" />
<script>
	function verify() {
		//storing the username input in the username variable  
		var username = document.getElementById("username").value;
		if (username == "") {
			document.getElementById("unamemsg").innerHTML = "Please Enter Username!";
			return false;
		}
		//storing the email input in the email variable
		var email = document.getElementById("email").value;
		if (email == "") {
			document.getElementById("emailmsg").innerHTML = "Please Enter email!";
			return false;
		} else if (email.includes(" ")) {
			document.getElementById("emailmsg").innerHTML = "Please Enter email Properly!";
			return false;
		} else if (!email.includes("@")) {
			document.getElementById("emailmsg").innerHTML = "Please Enter email Properly!";
			return false;
		}

		//storing the password input in the password variable
		var password = document.getElementById("password").value;
		//storing the re enter password input in the repassword variable
		var repassword = document.getElementById("repassword").value;
		if (password == "") {
			document.getElementById("passwordmsg").innerHTML = "Please Enter password!";
			return false;
		}
		if (repassword == "") {
			document.getElementById("repasswordmsg").innerHTML = "Please Enter password!";
			return false;
		}
		if (password != repassword) {
			document.getElementById("passwordmsg").innerHTML = "Password Not Matched!";
			return false;
		}
	}
</script>
</head>
<body>
	<h3 style="text-align: center; color: red; font-weight: bold;">${message}</h3>

	<div class="signup-box">
		<h1>Sign Up</h1>
		<h4>It's free and only takes a minute</h4>
		<form onsubmit="return verify()" action="signup" method="post">
			<span id="unamemsg" style="color: red"> </span> <label>Username</label>
			<input type="text" placeholder="Enter Username" id="username"
				name="userName" /> <span id="emailmsg" style="color: red"> </span>
			<label>Email</label> <input type="text" placeholder="abc@xyz.com"
				id="email" name="email" /> <span id="passwordmsg"
				style="color: red"> </span> <label>Password</label> <input
				type="password" placeholder="Enter the Password" id="password"
				name="password" /> <span id="repasswordmsg" style="color: red">
			</span> <label>Confirm Password</label> <input type="password"
				placeholder="ReEnter the Password" id="repassword" /> <input
				type="submit" value="Sign Up" />
			<closeform></closeform>
		</form>
		<p>
			By clicking the Sign Up button,you agree to our <br /> <a href="#">Terms
				and Condition</a> and <a href="#">Policy Privacy</a>
		</p>
	</div>
	<p class="para-2">
		Already have an account? <a href="view/login.jsp">Login here</a>
	</p>
</body>
</html>

