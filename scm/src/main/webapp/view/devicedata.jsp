<%@page import="com.exfscm.model.Devices"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Device Data</title>
    <style>
    
    table{
    
    margin-left:auto;
    margin-right:auto;
    border:none;
    }
    tr:nth-child(even) {
  	background-color: #7fcbeb;
	}
	tr:nth-child(odd) {
 	 background-color: #1b90b1;
	}
    th{
    font-family:Verdana;
    border:none;
    background-color:#06284c;
    font-size:20px;
    color:white;
    text-align:center;
    padding:30px 73px;
    
    }
    td{
    font-family:Verdana;
    border:none;
    text-align:center;
    padding:20px;
    color:white;
    font-size:20px;
    }
    </style>
</head>
<body>
<h1 style="color:blue; text-align:center; font-family:Verdana;">Device Data</h1>
    <table cellspacing="0" cellpadding="0">
        <tr>
        <th>Device Id</th>
        <th>Battery Level</th>
        <th>First Sensor temperature</th>
        <th>Route From</th>
        <th>Route To</th>
        </tr>
        
        <% List<Devices> devices= (List<Devices>)request.getAttribute("devicedata");
        	for(Devices device:devices)
        	{
        		%> 
        	<tr>
        	<td><%=device.getDevice_Id() %></td>
        	<td><%= device.getBattery_Level() %></td>
        	<td><%=device.getFirst_Sensor_temperature()%></td>
        	<td><%=device.getRoute_From() %></td>
        	<td><%=device.getRoute_To() %></td>
        	</tr>
        	<%} %>
        
    </table>
</body>
</html>