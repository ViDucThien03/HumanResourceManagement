<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Quản lý nhân sự - Đăng nhập hệ thống</title>
<meta content="" name="description">
<meta content="" name="keywords">
<c:url var="url" value="/Views/Admin"></c:url>
<!-- Favicons -->
<link href="${url}/assets/img/favicon.png" rel="icon">
<link href="${url}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${url}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${url}/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
<link href="${url}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="${url}/assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="${url}/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="${url}/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="${url}/assets/vendor/simple-datatables/style.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${url}/assets/css/style.css" rel="stylesheet">
</head>

<body>

	<main>
		<div class="container">

			<section
				class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
				<div class="container">
					<div class="row justify-content-center">
						<div
							class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

							<div class="d-flex justify-content-center py-4">
								<a href="index.html"
									class="logo d-flex align-items-center w-auto"> <img
									src="${url}/assets/img/logo.png" alt=""> <span
									class="d-none d-lg-block">Quản lý nhân sự</span>
								</a>
							</div>
							<!-- End Logo -->

							<div class="card mb-3">

								<div class="card-body">

									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">Đăng nhập hệ thống</h5>									
									</div>

									<form action="/HumanResourceManagement/loginAdmin" method="post" class="row g-3">

										<div class="col-12">
											<label for="yourUsername" class="form-label">Tài khoản</label>
											<div class="input-group has-validation">
												<span class="input-group-text" id="inputGroupPrepend">@</span>
												<input type="text" name="username" class="form-control" id="username" required>												
											</div>
										</div>

										<div class="col-12">
											<label for="yourPassword" class="form-label">Mật khẩu</label>
											<input type="password" name="password" class="form-control"
												id="yourPassword" required>
											
										</div>

										<div class="col-12">
											<div class="form-check">
												<input class="form-check-input" type="checkbox"
													name="remember" value="true" id="rememberMe"> <label
													class="form-check-label" for="rememberMe">Ghi nhớ</label>
											</div>
											<c:if test="${requestScope.error != null}">
												<p class="text-danger">${requestScope.error}</p>
											</c:if>
										</div>
										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit">Đăng nhập</button>
										</div>
										<div class="col-12">
											<p class="small mb-0">
												Bạn chưa có tài khoản? <a href="pages-register.html">Tạo tài khoản</a>
											</p>
										</div>
									</form>

								</div>
							</div>
							
						</div>
					</div>
				</div>

			</section>

		</div>
	</main>
	<!-- End #main -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="${url}/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="${url}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${url}/assets/vendor/chart.js/chart.min.js"></script>
	<script src="${url}/assets/vendor/echarts/echarts.min.js"></script>
	<script src="${url}/assets/vendor/quill/quill.min.js"></script>
	<script src="${url}/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="${url}/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="${url}/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="${url}/assets/js/main.js"></script>

</body>

</html>