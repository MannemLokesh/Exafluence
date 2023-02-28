<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Shipment Page</title>
<meta charset="UTF-8" lang="en" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>

<style>
section{
margin:auto;
}
body {
	background-image:
		url(../createshipment.gif);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}

h6 {
	color: white;
}
</style>
<script>
	function verify() {
		if (document.getElementById("Shipmentinvoice").value == ""
				|| document.getElementById("Containernumber").value == ""
				|| document.getElementById("Shipmentdescription").value == ""
				|| document.getElementById("Routedetails").value == ""
				|| document.getElementById("Goodtypes").value == ""
				|| document.getElementById("device").value == ""
				|| document.getElementById("exepectedDelivery").value == ""
				|| document.getElementById("ponumber").value == ""
				|| document.getElementById("delivarynumber").value == ""
				|| document.getElementById("ndcnumber").value == ""
				|| document.getElementById("batchNumber").value == ""
				|| document.getElementById("slno").value == "") {
			document.getElementById("msg").innerHTML = "Please Fill All The Details!";
			return false;
		}
	}
</script>
<body>
<div class="section">
	<h3 style="text-align: center; color: white; font-weight: bold; margin-top: 35px;">${message}</h3>
	<form onsubmit="return verify()" method="post" action="createShipment">
		<h3 id="msg" style="color: white; text-align: center;"></h3>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="Shipmentinvoice">Shipment invoicenumber</h6>
			</div>
			<div class="col-md-4">
				<input placeholder="Shipment/invoice Number" style="width: 50%"
					name="shipmentInvoiceNumber" id="Shipmentinvoice" type="number" />
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="Containernumber">Container Number</h6>
			</div>
			<div class="col-md-4">
				<input placeholder="Container Number" style="width: 50%"
					name="containerNumber" id="Containernumber" type="number" />
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="Shipmentdescription">Shipment Description</h6>
			</div>
			<div class="col-md-4">
				<textarea pattern="[a-zA-Z0-9 ]+" class="form-control" rows="3"
					placeholder="Shipment Description" style="width: 50%"
					name="shipmentDescription" id="Shipmentdescription"></textarea>
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="Routedetails">Route Details</h6>
			</div>
			<div class="col-md-4">
				<select class="form-select" aria-label="Default select example"
					style="width: 50%" name="routeDetails" id="Routedetails">
					<option value="Chennai">Chennai to Banglore</option>
					<option value="Hyderabad">Hyderabad to Chennai</option>
					<option value="Banglore">Banglore to Rajastan</option>
					<option value="Rajastan">Rajastan to Dubai</option>
					<option value="Dubai">Dubai to Chennai</option>
				</select>
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="Goodtypes">Goods Type</h6>
			</div>
			<div class="col-md-4">
				<select class="form-select" aria-label="Default select example"
					style="width: 50%" name="goodsType" id="Goodtypes">
					<option value="" disabled selected>Goods Type</option>
					<option value="cosmetics">Cosmetics</option>
					<option value="pharmacy">Pharmacy</option>
					<option value="food">Food</option>
				</select>
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="Device">Device</h6>
			</div>
			<div class="col-md-4">
				<select class="form-select" aria-label="Default select example"
					style="width: 50%" id="device" name="device">
					<option value="67857">67857</option>
					<option value="73456">73456</option>
					<option value="52896">52896</option>
				</select>
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="Expecteddelivery">Expected Delivary Date</h6>
			</div>
			<div class="col-md-4">
				<input placeholder="Expected Delivery Date" style="width: 50%"
					type="date" name="expectedDelivaryDate" id="exepectedDelivery" />
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="POnumber">PO Number</h6>
			</div>
			<div class="col-md-4">
				<input placeholder="PO Number" style="width: 50%" name="poNumber"
					type="number" id="ponumber" />
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="Delivarynumber">Delivary Number</h6>
			</div>
			<div class="col-md-4">
				<input placeholder="Delivery Number" style="width: 50%"
					name="delivaryNumber" type="number" id="delivaryNumber" />
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="NDCnumber">NDC Number</h6>
			</div>
			<div class="col-md-4">
				<input placeholder="NDC Number" style="width: 50%" name="ndcNumber"
					type="number" id="ndcnumber" />
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="BatchId">Batch ID:</h6>
			</div>
			<div class="col-md-4">
				<input placeholder="Batch Id" style="width: 50%" name="batchId"
					type="number" id="batchNumber" />
			</div>
		</div>
		<div class="row justify-content-center m-auto p-2">
			<div class="col-md-2">
				<h6 for="Serialnumber">Serial Number of Goods</h6>
			</div>
			<div class="col-md-4">
				<input placeholder="Serial Number of goods" style="width: 50%"
					name="serialNumberOfGoods" type="number" id="slno" />
			</div>
		</div>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center m-5">
			<input class="btn btn-secondary me-md-2" type="reset" type="reset" value="Cancel Shipment">
				
			<button class="btn btn-primary" type="submit" value="Click">

				Create Shipment</button>

		</div>
	</form>
	</div>
</body>

</html>