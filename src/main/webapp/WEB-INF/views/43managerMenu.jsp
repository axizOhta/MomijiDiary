<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者メニュー画面</title>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/f.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
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
<form:form action="post"  modelAttribute="form">
<div class="o_">
<div class = "o_wrapper">
<div class="a_">
<div class="a_btn">
<form action="34 contactsuper">
	<input type="submit" value="問い合わせ確認" class="a_btn_manager">
</form>
</div>
<br><br>
<div id="a_btn">
<form:form action="36userinfo"  method = "post" modelAttribute="form">
	<input type="submit" value="ユーザー一覧" class="a_btn_manager">
</form:form>
</div>
<br><br>
<div id="a_btn">
<form action="35login_manager">
	<input type="submit" value="ログアウト" class="a_btn_manager">
</form>
</div>
</div>
</div>
</div>
</form:form>
</body>
</html>
