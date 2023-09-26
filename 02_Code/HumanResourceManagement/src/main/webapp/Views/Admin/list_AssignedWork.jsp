<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Quản lý nhân sự</title>
<meta content="" name="description">
<meta content="" name="keywords">
<c:url var="url" value="/Views/Admin"></c:url>
<!-- Favicons -->
<link href="${url}/assets/img/favicon.png" rel="icon">
<link href="${url}/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${url}/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="${url}/assets/vendor/quill/quill.bubble.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/simple-datatables/style.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${url}/assets/css/style.css" rel="stylesheet">

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

		<div class="pagetitle">
			<h1>Công việc</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Trang chủ</a></li>
					<li class="breadcrumb-item active">Công việc</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">

				<!-- Left side columns -->
				<div class="col-lg-12">
					<div class="row">

						<!-- Sales Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card sales-card">
								<div class="card-body">
									<h5 class="card-title">Công việc hôm nay</h5>
									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-clipboard-check"></i>
										</div>
										<div class="ps-3">
											<c:set var="count" value="${requestScope.count }"></c:set>
											<h6>${count}</h6>
											<span class="text-success small pt-1 fw-bold">12%</span> <span
												class="text-muted small pt-2 ps-1">increase</span>

										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End Sales Card -->

						<!-- Revenue Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card revenue-card">
								<div class="card-body">
									<h5 class="card-title">Công việc đã hoàn thành</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-clock-fill"></i>
										</div>
										<div class="ps-3">
										<c:set var="countjd" value="${requestScope.countjd }"></c:set>
											<h6>${countjd }</h6>
											<span class="text-success small pt-1 fw-bold">8%</span> <span
												class="text-muted small pt-2 ps-1">increase</span>
										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End Revenue Card -->

						<!-- Customers Card -->
						<div class="col-xxl-4 col-xl-12">
							<div class="card info-card customers-card">


								<div class="card-body">
									<h5 class="card-title">Tỉ lệ hoàn thành công việc</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-percent"></i>
										</div>
										<div class="ps-3">
											<c:set var="percent" value="${requestScope.percent }"></c:set>
											<h6>${percent }%</h6>
											<span class="text-danger small pt-1 fw-bold">12%</span> <span
												class="text-muted small pt-2 ps-1">decrease</span>

										</div>
									</div>

								</div>
							</div>

						</div>
						<!-- End Customers Card -->



						<!-- Recent Sales -->
						<div class="col-12">
							<div class="card recent-sales overflow-auto">

								<div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>

										<li><a class="dropdown-item" href="#">Today</a></li>
										<li><a class="dropdown-item" href="#">This Month</a></li>
										<li><a class="dropdown-item" href="#">This Year</a></li>
									</ul>
								</div>

								<div class="card-body">
									<h5 class="card-title">
										Công việc cần hoàn thành<span>| Today</span>
									</h5>
									<a href="addwork" class="btn btn-primary">Thêm mới</a>
									<table class="table table-borderless datatable">
										<thead>
											<tr>
												<th scope="col">Mã công việc</th>
												<th scope="col">Ngày giao</th>
												<th scope="col">Mô tả công việc</th>
												<th scope="col">Hạn hoàn thành</th>
												<th scope="col">Tiến độ công việc</th>
												<th scope="col">Mã nhân viên</th>
												<th scope="col">Chức năng</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${requestScope.assignedWorks }" var="wk">
												<tr>
													<td>${wk.jobid }</td>
													<td>${wk.deliverydate }</td>
													<td>${wk.descriptions }</td>
													<td>${wk.deadline }</td>
													<td>${wk.workrogress }</td>
													<td>${wk.employeeid }</td>
													<td>
														<a href="updateassignedwork?jobid=${wk.jobid}"><i class="ri-repeat-line"></i></a>
														<a href="#" onclick="deleteWork('${wk.jobid}');"><i class="ri-delete-bin-2-fill"></i></a>
													</td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
									
								</div>

							</div>
						</div>
						<!-- End Recent Sales -->

						<!-- Top Selling -->
						<div class="col-12">
							<div class="card top-selling overflow-auto">

								<div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>

										<li><a class="dropdown-item" href="#">Today</a></li>
										<li><a class="dropdown-item" href="#">This Month</a></li>
										<li><a class="dropdown-item" href="#">This Year</a></li>
									</ul>
								</div>

								<div class="card-body pb-0">
									<h5 class="card-title">
										Bảng xếp hạng hoàn thành công việc
									</h5>

									<table class="table table-borderless">
										<thead>
											<tr>
												<th scope="col"></th>
												<th scope="col">Mã nhân viên</th>
												<th scope="col">Tên nhân viên</th>
												<th scope="col">Công việc đã hoàn thành</th>
												<th scope="col">Tỷ lệ hoàn thành công việc</th>
												
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${requestScope.list}" var="top">
												<tr>
													<td><a href="#"><img width="60px" height="60px"
														src="${url}/assets/img/${top.image}" alt=""></a></td>
													<td>${top.employeeid}</td>
													<td>${top.employeename }</td>
													<td>${top.completedWorks }</td>
													<td class="fw-bold">${top.completionPercentage}</td>
												</tr>
											</c:forEach>
											
										</tbody>
									</table>

								</div>

							</div>
						</div>
						<!-- End Top Selling -->

					</div>
				</div>
				<!-- End Left side columns -->

				<!-- Right side columns -->


			</div>
		</section>

	</main>
	<!-- End #main -->

	<%@include file="Layout/footer.jsp"%>
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="${url}/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="${url}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${url}/assets/vendor/chart.js/chart.min.js"></script>
	<script src="${url}/assets/vendor/echarts/echarts.min.js"></script>
	<script src="${url}/assets/vendor/quill/quill.min.js"></script>
	<script
		src="${url}/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="${url}/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="${url}/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script>
		function deleteWork(jobid) {
			let ans = confirm("Bạn có đồng ý xóa?");
			if(ans){
				window.location = "deletework?jobid="+jobid;
			}
		}
	</script>

</body>

</html>