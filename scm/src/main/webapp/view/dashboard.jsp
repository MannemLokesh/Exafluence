<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
        h1{
            text-align: center;
            color:  #16365a ;
            font-size: 40px;
        }
        p{
            font-size: 30px;
            text-align: center;
            color: #152554;
        }
        body{
            font-family: "Inter", sans-serif;
            background-image: url(../5.gif);
            background-repeat: no-repeat;
            background-size: cover;
            background-size: fill;
            height: 750px;
        }
        
        a{
            background-color: #0d6efd;;
            color: white;
            padding: 10px 20px;
            border-radius: 10px;
            margin-left: 400px;
        }
    </style>
</head>
<body>
    <h1>Dashboard</h1>
    <p>Welcome ${name}</p>
    <br><br>
    <nav><a href="../shipment">Create Shipment</a><a href="../devicesData">Device Data</a></nav>
</body>
</html>
