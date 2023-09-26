<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Users / Profile - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${url }/assets/img/favicon.png" rel="icon">
  <link href="${url }/assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <c:url var="url" value="/Views/Admin"></c:url>
  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${url }/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${url }/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${url }/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${url }/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="${url }/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="${url }/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="${url }/assets/vendor/simple-datatables/style.css" rel="stylesheet">

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

  <%@include file="Layout/header.jsp" %>

  <%@include file="Layout/sidebar.jsp" %>

  <main id="main" class="main">
	<c:set var="pf" value="${requestScope.profile }"></c:set>
    <div class="pagetitle">
      <h1>Profile</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">Users</li>
          <li class="breadcrumb-item active">Profile</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section profile">
      <div class="row">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

              <img src="${url }/assets/img/${pf.image}" alt="Profile" class="rounded-circle">
              <c:set var="ep" value="${requestScope.employees }"></c:set>
              <h2>${pf.employeeid }</h2>
              <h3>${pf.positionname }</h3>
              <div class="social-links mt-2">
                <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
              </div>
            </div>
          </div>

        </div>

        <div class="col-xl-8">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Overview</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Edit Profile</button>
                </li>

              
              </ul>
              <div class="tab-content pt-2">

                <div class="tab-pane fade show active profile-overview" id="profile-overview">

                  <h5 class="card-title">Hồ sơ chi tiết</h5>
				  
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Mã nhân viên</div>
                    <div class="col-lg-9 col-md-8">${pf.employeeid }</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Tên nhân viên</div>
                    <div class="col-lg-9 col-md-8">${pf.employeename }</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Ngày sinh</div>
                    <div class="col-lg-9 col-md-8">${pf.employeebirth }</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Quê quán</div>
                    <div class="col-lg-9 col-md-8">${pf.employeehometown }</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Hộ khẩu thường trú</div>
                    <div class="col-lg-9 col-md-8">${pf.employeeaddress }</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Số điện thoại</div>
                    <div class="col-lg-9 col-md-8">${pf.employeephone }</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Ngày vào làm việc</div>
                    <div class="col-lg-9 col-md-8">${pf.employeeworkday }</div>
                  </div>
				  
				  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Kinh nghiệm</div>
                    <div class="col-lg-9 col-md-8">${pf.employeeexp }</div>
                  </div>
                </div>
                <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                  <!-- Profile Edit Form -->
                  <form action="/HumanResourceManagement/" method="post">
                    <div class="row mb-3">
                      <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                      <div class="col-md-8 col-lg-9">
                        <img src="${url }/assets/img/profile-img.jpg" alt="Profile">
                        <div class="pt-2">
                          <a href="#" class="btn btn-primary btn-sm" title="Upload new profile image"><i class="bi bi-upload"></i></a>
                          <a href="#" class="btn btn-danger btn-sm" title="Remove my profile image"><i class="bi bi-trash"></i></a>
                        </div>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Full Name</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="fullName" type="text" class="form-control" id="fullName" value="Kevin Anderson">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="about" class="col-md-4 col-lg-3 col-form-label">Ngày sinh</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="fullName" type="text" class="form-control" id="fullName" value="Kevin Anderson">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="company" class="col-md-4 col-lg-3 col-form-label">Quê quán</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="company" type="text" class="form-control" id="company" value="Lueilwitz, Wisoky and Leuschke">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Job" class="col-md-4 col-lg-3 col-form-label">Hộ khẩu thường trú</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="job" type="text" class="form-control" id="Job" value="Web Designer">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Country" class="col-md-4 col-lg-3 col-form-label">Số điện thoại</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="country" type="text" class="form-control" id="Country" value="USA">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Address" class="col-md-4 col-lg-3 col-form-label">Ngày vào làm việc</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="address" type="text" class="form-control" id="Address" value="A108 Adam Street, New York, NY 535022">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">Kinh nghiệm</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="phone" type="text" class="form-control" id="Phone" value="(436) 486-3538 x29071">
                      </div>
                    </div>

                    

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Lưu</button>
                    </div>
                  </form><!-- End Profile Edit Form -->

              </div><!-- End Bordered Tabs -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->

  <%@include file="Layout/footer.jsp" %>

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="${url }/assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="${url }/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${url }/assets/vendor/chart.js/chart.min.js"></script>
  <script src="${url }/assets/vendor/echarts/echarts.min.js"></script>
  <script src="${url }/assets/vendor/quill/quill.min.js"></script>
  <script src="${url }/assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="${url }/assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="${url }/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="${url }/assets/js/main.js"></script>

</body>

</html>