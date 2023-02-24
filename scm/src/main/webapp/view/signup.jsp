<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" >
	<head>
		<meta charset="UTF-8">
  		<title>CodePen - Sign Up</title>
  		<meta name="viewport" content="width=device-width, initial-scale=1">
 		<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/sanitize.css/2.0.0/sanitize.min.css'>
		<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/modern-normalize/1.1.0/modern-normalize.min.css'>
		<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/inter-ui/3.19.3/inter.css'>
		<link rel="stylesheet" href="./style.css">
		
		<script>
			function verify() 
			{
			//storing the username input in the username variable  
			var username = document.getElementById("username").value;
		
			if (username == "") 
			{
				alert("Please Enter Username!");
				return false;
			}
		
			//storing the email input in the email variable
			var email = document.getElementById("email").value;
			if (email == "") 
			{
				alert("Please Enter email!");
				return false;
			}
			else if (email.includes(" "))
			{
				alert("Please Enter email Properly!");
				return false;
			} 
			else if (!email.includes("@")) 
			{
				alert("Please Enter email Properly!");
				return false;
			}

			//storing the password input in the password variable
			var password = document.getElementById("password").value;
			//storing the re enter password input in the repassword variable
			var repassword = document.getElementById("password_confirmation").value;
		
			if (password == "") 
			{
				alert("Please Enter password!");
				return false;
			}
			if (repassword == "") 
			{
				alert("Please ReEnter password!");
				return false;
			}
			if (password != repassword) 
			{
				alert("Password Not Matched!");
				return false;
			}
		}
	</script>
</head>

<body>
	<main>
	<h4 style="font-family:Georgia; text-align: center; color: #eb3440; font-weight: bold;">${message}</h4>
		<section>
			
			<form onsubmit="return verify()" action="signup" class="form" method="post">
				<fieldset>
					<legend>Sign up</legend>
					<div class="input-group">
						<label for="username" class="label">Username</label>
						<input id="username" placeholder="Username" type="text" class="input" name="userName">
					</div>
	
					<div class="input-group">
						<label for="email" class="label">Email</label>
						<input id="email" type="email" class="input" autocomplete placeholder="Email Address" name="email">
					</div>
	
					<div class="input-group">
						<label for="password" class="label">Password</label>
						<input id="password" type="password" class="input" placeholder="" name="password">
					</div>
	
					<div class="input-group">
						<label for="password_confirmation" class="label">Password Confirmation</label>
						<input id="password_confirmation" type="password" class="input" placeholder="">
					</div>
				</fieldset>
				
				<input type="submit" value="Submit">
				
				<footer>
					<p>Already have an account? <a href="view/login.jsp">Login here</a></p>
				</footer>
			</form>
		</section>
	</main>
</body>
</html>
    