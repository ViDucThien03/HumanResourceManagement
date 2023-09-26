<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Quản lý nhân sự-Lương</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <c:url var="url" value="/Views/Admin"></c:url>
  <!-- Favicons -->
  <link href="${url }/assets/img/favicon.png" rel="icon">
  <link href="${url }/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

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

    <div class="pagetitle">
      <h1>Bảng lương</h1>
    </div><!-- End Page Title -->

    <section class="section">    
        <div class="col-lg-12"></div>

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Danh sách lương</h5>

              <!-- Table with stripped rows -->
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">Mã nhân viên</th>
                    <th scope="col">Tên nhân viên</th>
                    <th scope="col">Chức vụ</th>
                    <th scope="col">Lương</th>
                    <th scope="col">Chi tiết</th>
          
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${requestScope.salaries }" var="sal">
                  	<tr>
                    	<td>${sal.employeeid }</td>
                    	<td>${sal.employeename }</td>
                    	<td>${sal.positionname }</td>
                    	<td>${sal.actualsalary }</td>
                    	<td>
                    		<a href="salarydetails?employeeid=${sal.employeeid }"><i class="bx bxs-right-arrow-circle"></i></a>
                    	</td>
                  	</tr>
                  </c:forEach>
                </tbody>
              </table>
              <!-- End Table with stripped rows -->

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