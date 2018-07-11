<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会</title>
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
         		<li class="a_select"><a href="17select">検索</a></li>
         		<li><a href="05mypage">基本ページ</a></li>
         		<li><a href="30contact">お問い合わせ</a></li>
         	</ul>
		</div>
		</div>
	</div>
	</div>
</header>
<div class="o_">
	<div class = "o_wrapper">
		<div class="a_">
			<div class="text-center">
				<p class="h2">退会</p>
				<br>
				<br>
				<p class="h3">パスワードを入力してください</p>
				<br>
				<c:if test="${not empty errmsg}">
				<p class="a_denger">${errmsg}</p>
				</c:if>
				<br>
				<form:form action="unsub" modelAttribute="form">
					<div>
						<label class="h2">パスワード</label>
						<br>
						<br>
						<form:input type="password" class="form-control input-lg" name="newpassword" path="newpassword" />
					</div>
					<br>
					<br>
					<div>
						<label class="h2">パスワード(再入力)</label>
					<br>
					<br>
						<form:input type="password" class="form-control input-lg" name="repassword" path="repassword"/>
					</div>
					<br>
					<br>
					<div class="a_btn">
						<input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="確認">
					</div>
					</form:form>
						<br>
						<br>
					<div class="a_btn">
						<input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="戻る"  onclick="location.href='05mypage' ; return false;">
					</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>