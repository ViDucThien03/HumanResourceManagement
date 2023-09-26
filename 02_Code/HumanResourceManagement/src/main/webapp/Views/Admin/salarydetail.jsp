<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Tables / General - NiceAdmin Bootstrap Template</title>
<meta content="" name="description">
<meta content="" name="keywords">
<c:url var="url" value="/Views/Admin"></c:url>
<!-- Favicons -->
<link href="${url }/assets/img/favicon.png" rel="icon">
<link href="${url }/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${url }/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${url }/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="${url }/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="${url }/assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="${url }/assets/vendor/quill/quill.bubble.css"
	rel="stylesheet">
<link href="${url }/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link href="${url }/assets/vendor/simple-datatables/style.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${url }/assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: NiceAdmin - v2.4.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<style>
td {
	padding: 10px;
}

.content td {
	text-align: center;
}

th {
	padding: 10px;
}
</style>
</head>

<body>

	<%@include file="Layout/header.jsp"%>

	<%@include file="Layout/sidebar.jsp"%>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>General Tables</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item">Tables</li>
					<li class="breadcrumb-item active">General</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="col-lg-12"></div>

			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Table with stripped rows</h5>

					<!-- Table with stripped rows -->
					<table border="1" cellspacing="0" cellpadding="0" align="center">
						<c:set var="sl" value="${requestScope.salary }"></c:set>
						<tr>
							<td colspan="6" style="font-size: large;">Tên công ty: CÔNG
								TY ABC</td>
						</tr>
						<tr>
							<td colspan="6" font-size:large;>Địa chỉ công ty:</td>
						</tr>
						<tr>
							<td colspan="6"
								style="background-color: rgb(37, 118, 181); color: white;">PHIẾU
								LƯƠNG</td>
						</tr>
						<tr>
							<%
        						java.util.Calendar calendar = java.util.Calendar.getInstance();
        						int currentMonth = calendar.get(java.util.Calendar.MONTH) + 1;
    						%>
							<td colspan="1">Tháng:</td>
							<td colspan="5"><%= currentMonth%></td>
						</tr>
						<tr>
							<td colspan="1"
								style="background-color: yellow; font-size: large;" >Mã nhân
								viên:</td>
							<td colspan="5" style="background-color: yellow; font-size: large;">${sl.employeeid }</td>
						</tr>
						<tr>
							<td colspan="1">Tên nhân viên:</td>
							<td colspan="5">${sl.employeename }</td>
						</tr>
						<tr>
							<td colspan="1">Chức vụ:</td>
							<td colspan="5">${sl.positionname }</td>
						</tr>
						<tr>
							<th>Mã lương</th>
							<th>Bậc lương</th>
							<th>Lương cơ bản</th>
							<th>Hệ số lương</th>
							<th>Số ngày làm việc trong tháng</th>
							<th>Thuế TNCN</th>
						</tr>
						<tr class="content">
							<td>${sl.salaryid }</td>
							<td>${sl.salarygrade }</td>
							<td>${sl.salarybasic }</td>
							<td>${sl.salaryfactor }</td>
							<td>${sl.workday }</td>
							<td>${sl.pit }</td>
						</tr>
						<tr>
							<td colspan="1" style="font-size: large; font-weight: bold;">Tổng
								lương:</td>
							<td colspan="5">${sl.totalsalary }</td>
						</tr>
						<tr>
							<td colspan="1"
								style="font-size: large; font-weight: bold; background-color: red; color: white;">Thực
								lĩnh:</td>
							<td colspan="5" style="font-size: large; font-weight: bold; background-color: red; color: white;">${sl.actualsalary }</td>
						</tr>
					</table>
					
					<!-- End Table with stripped rows -->

				</div>
			</div>

		</section>

	</main>
	<!-- End #main -->

	<%@include file="Layout/footer.jsp"%>

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="${url }/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script
		src="${url }/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${url }/assets/vendor/chart.js/chart.min.js"></script>
	<script src="${url }/assets/vendor/echarts/echarts.min.js"></script>
	<script src="${url }/assets/vendor/quill/quill.min.js"></script>
	<script
		src="${url }/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="${url }/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="${url }/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="${url }/assets/js/main.js"></script>

</body>

</html>