<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>強制退会完了完了画面</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/f.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
</head>
<body>
<header>
<div id="header-fixed">
     <div id="a_header-bk">
		 <div class="a_center">
		 <div class="a_form_conf">
            <img src="image/image002.png"  alt="" class="a_momiji"><a>もみじ日記</a>
         </div>
         <div class="a_menu">
         	<ul>
         		<li><a href="43managerMenu" id="manager">管理者メニュー</a></li>
         	</ul>
        </div>
        </div>
	</div>
	</div>
</header>

<div class="o_">
<div class = "o_wrapper">
	<p class = "k_center">強制退会させました。</p>

<div class = "table-responsive">
<table border = "1" class = "k_table k_padding k_center">
    <tr>
      <th>ID</th>
      <th>ユーザー名</th>
    </tr>
  <tr>
      <td>${user_id}</td>
      <td>${user_name}</td>
    </tr>
   </table>
   </div>
<br>
	<div class = "k_center">
<form:form action ="36userinfo" modelAttribute="form" method ="post">
<input type="submit" value="ユーザー情報">
</form:form>
	</div>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</div>
</div>

</body>
</html>
