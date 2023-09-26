<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Forms / Layouts - NiceAdmin Bootstrap Template</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="${url }/assets/img/favicon.png" rel="icon">
<link href="${url }/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">
<c:url var="url" value="/Views/Admin"></c:url>
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
</head>

<body>
	<!-- header -->
	<%@include file="Layout/header.jsp"%>
	<!-- sidebar -->
	<%@include file="Layout/sidebar.jsp"%>

	<main id="main" class="main">
		<!-- header -->
		<%@include file="Layout/header.jsp"%>
		<!-- sidebar -->
		<%@include file="Layout/sidebar.jsp"%>
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Thêm công việc</h5>

				<!-- Multi Columns Form -->
				<form class="row g-3" action="/HumanResourceManagement/updateassignedwork"
					method="post">
					<c:set var="wk" value="${requestScope.assignedWork }"></c:set>
					<div class="col-md-12">
						<label class="form-label">Mã công việc</label> <input type="text"
							class="form-control" name="jobid" readonly="readonly" value="${assignedWork.jobid }">
					</div>
					<div class="col-md-6">
							<label class="form-label">Ngày giao</label> <input type="date"
								class="form-control" name="deliverydate" value="${assignedWork.deliverydate }">
					</div>
					<div class="col-md-6">
						<label class="form-label">Hạn hoàn thành</label> <input
							type="date" class="form-control" name="deadline" value="${assignedWork.deadline }">
					</div>
					<div class="col-12">
						<label class="form-label">Mô tả</label> <input type="text"
							class="form-control" name="descriptions" value="${assignedWork.descriptions }">
					</div>

					<div class="col-12">
						<label class="form-label">Tiến độ</label> <input type="text"
							class="form-control" name="workrogress" value="${assignedWork.workrogress }">
						<span style="font-size: 12px; color: #999;">Nhập "Hoàn thành" hoặc "Chưa hoàn thành"</span>
					</div>
					<div class="col-12">
						<label class="form-label">Mã nhân viên</label> <input type="text"
							class="form-control" name="employeeid" value="${assignedWork.employeeid }">
					</div>
					<!--<div class="col-md-4">
						<label  class="form-label">State</label> <select
							name="employeeid" class="form-select">
							<c:forEach items="${requestScope.assignedWorks}" var="wk">
								<option value="${wk.employeeid}">${wk.employeeid}</option>
							</c:forEach>
						</select>
					</div>  -->
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Cập nhật</button>
					</div>
				</form>
				<!-- End Multi Columns Form -->

			</div>
		</div>

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