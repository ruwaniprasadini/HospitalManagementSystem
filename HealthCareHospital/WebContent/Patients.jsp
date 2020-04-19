<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Patient Management</h1>
	<form method="post" action="Patients.jsp">
		Patient NIC:<input name="patientNIC" type="text"><br>
		Patient Name:<input name="patientName" type="text"><br>
		Patient Gender:<input name="patientGender" type="text"><br>
		Patient MobileNo:<input name="patientMobileNo" type="text"><br>
		Patient Address:<input name="patientAddress" type="text"><br>
		<input name="btnSubmit" type="submit" value="save">
	</form>
	<br>
	
	<table border="1">
		<tr>
			<th>NIC</th>
			<th>Full Name</th>
			<th>Gender</th>
			<th>MobileNo</th>
			<th>Address</th>
			<th>Update</th>
			<th>Remove</th>
		</tr>
		<tr>
			<td><%out.print(session.getAttribute("patientNIC")); %></td>
			<td><%out.print(session.getAttribute("patientName")); %></td>
			<td><%out.print(session.getAttribute("patientGender")); %></td>
			<td><%out.print(session.getAttribute("patientMobileNo")); %></td>
			<td><%out.print(session.getAttribute("patientAddress")); %></td>
 			<td><input name="btnUpdate" type="button" value="Update"></td>
 			<td><input name="btnRemove" type="button" value="Remove"></td>
	
	</table>

</body>
</html>