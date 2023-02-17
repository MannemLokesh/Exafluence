<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Dashboard Page</title>
<meta charset="UTF-8" lang="en" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />

<style>
.btn_group {
	justify-self: center;
	justify-content: space-between;
}

.body_bg {
	/* background-color: #09786f;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	backdrop-filter: blur(50px); */
	background: linear-gradient(70deg, #FD297A 0%, #9424F0 100%);
}

}
#second {
	margin-top: 80px;
}

.first {
	background-color: green;
}
</style>
</head>
<body class="body_bg">
	<div id="second">
		<h1 style="color: white; text-align: center;">Dashboard</h1>
		<p style="color: white; text-align: center; font-size: 30px;">welcome</p>
	</div>

	<div style="margin: 10px">
		<div class="card" style="background: none;">
			<div class="d-grid gap-25 d-md-flex justify-content-md-evenly m-2">
				<a href="../shipment">
					<button class="btn btn-primary me-md-2" type="button">
						Create Shipment</button>
				</a> <a href="#">
					<button class="btn btn-primary" type="button">DeviceData</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>
