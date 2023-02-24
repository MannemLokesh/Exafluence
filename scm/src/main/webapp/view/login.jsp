<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../login.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
	<title>Login Page</title>
    <script>
        function verify()
        {
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
            if (password == "") 
            {
                alert("Please Enter password!");
                return false;
            }
            const usr_input = document.getElementById("submit").value;
	
	        // Check whether the input is equal
	        if (usr_input != captcha.innerHTML)
            {
                alert("Captha Not Matched!");
                generate();
                return false;
	        }
        }
        var captcha;
        function generate()
        {
	        // Clear old input
	        document.getElementById("submit").value = "";

	        // Access the element to store
	        // the generated captcha
	        captcha = document.getElementById("image");
	        var uniquechar = "";

	        const randomchar ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	        // Generate captcha for length of
	        // 5 with random character
	        for (let i = 1; i < 7; i++)
            {
		        uniquechar += randomchar.charAt(Math.random() * randomchar.length)
	        }

	        // Store generated input
	        captcha.innerHTML = uniquechar;
        }
    </script>
</head>

<body onload="generate()">
    <main>
        <h3 style="text-align: center; color: #ebdd34; font-weight: bold; margin-top: 25px;">${message}</h3>
        <section>
            <form action="../login" method="post">
                <fieldset>
                    <legend>Login</legend>
				    <div class="input-group">
					    <label for="email" class="label">Email</label>
					    <input id="email" type="text" class="input" autocomplete placeholder="Email Address" name="email">
					</div>

                    <div class="input-group">
					    <label for="password" class="label">Password</label>
					    <input id="password" type="password" class="input" placeholder="" name="password">
				    </div>

                    <div class="input-group">
                        <div id="image"  class="input" style="text-align: center;"></div>
                    </div>

                    <div class="input-group">
                        <i class="input" onclick="generate();" style="text-align: center;">Refresh</i>
                    </div>

                    <div class="input-group">
					    <input id="submit"  class="input" placeholder="Enter Captcha">	
				    </div>
                </fieldset>
            <input type="submit" value="Login" onclick="return verify()">
        
            </form>
        </section>
    </main>
</body>

</html>
    