<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../login.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@800&amp;display=swap" />

<title>Login Page</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
	function verify() {
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
		if (password == "") {
			document.getElementById("passwordmsg").innerHTML = "Please Enter password!";
			return false;
		}

		var cap = document.getElementById("txtCompare").value;
		var txtcap = document.getElementById("txtCaptcha").value;
		var ncap = txtcap.split(' ').join('');

		if (cap == "") {
			document.getElementById("captchemsg").innerHTML = "Enter Captche!";
			return false;
		}
		if (cap != ncap) {
			document.getElementById("captchemsg").innerHTML = "Wrong Captche!";
			return false;
		}

		GenerateCaptcha();
	}
</script>
</head>
<body onload="GenerateCaptcha();">
	<h3
		style="text-align: center; color: red; font-weight: bold; margin-top: 35px;">${message}</h3>

	<form onsubmit="return verify()" action="../login" method="post">
		<div class="login-form">
			<div class="form-title">Login</div>
			<div class="form-input">
				<span id="emailmsg" style="color: red"> </span> <label for="email">Email</label>
				<input type="text" id="email" placeholder="abc@xyz.com" name="email">
			</div>
			<div class="form-input">
				<span id="passwordmsg" style="color: red"> </span> <label
					for="password">Password</label> <input type="password"
					id="password" placeholder="Enter Password" name="password">
			</div>
			<div class="captcha">
				<span id="captchemsg" style="color: red"> </span> <label
					for="captcha-input">Enter Captcha</label>
				<div id="preview">
					<input class="preview" type="text" id="txtCaptcha" name="captche" />
				</div>
				<div class="captcha-form">
					<input type="text" id="txtCompare" placeholder="Enter captcha text"
						name="txtCaptche" />
					<button class="captcha-refresh" onclick="GenerateCaptcha();">
						<i class="fa fa-refresh"></i>
					</button>
				</div>
			</div>
			<div class="form-input">
				<button id="login-btn">Login</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		/* Function to Generat Captcha */
		function GenerateCaptcha() {
			var chr1 = Math.ceil(Math.random() * 10) + '';
			var chr2 = Math.ceil(Math.random() * 10) + '';
			var chr3 = Math.ceil(Math.random() * 10) + '';

			var str = new Array(4).join().replace(
					/(.|$)/g,
					function() {
						return ((Math.random() * 36) | 0).toString(36)[Math
								.random() < .5 ? "toString" : "toUpperCase"]();
					});
			var captchaCode = str + chr1 + ' ' + chr2 + ' ' + chr3;
			document.getElementById("txtCaptcha").value = captchaCode;
			/* document.write(captchaCode); */
		}
	</script>

</body>
</html>