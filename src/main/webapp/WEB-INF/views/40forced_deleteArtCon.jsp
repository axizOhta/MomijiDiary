<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除記事確認画面</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/f.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
</head>
<body>
	<header>
		<div id="header-fixed">
			<div id="a_header-bk">
				<div class="a_center">
					<div class="a_form_conf">
						<img src="image/image002.png" alt="" class="a_momiji"><a>もみじ日記</a>
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
		<div class="o_wrapper">
			<p class="k_required">以下の記事を削除します</p>
			<p>対象ユーザ：${name}さん</p>
			<table class="k_table">
				<c:forEach items="${userlist}" var="users">
					<tr>
						<td class="k_padding">${users.article_title}</td>
					</tr>
				</c:forEach>
			</table>

			<br>
			<form:form method="post" action="41forced_deleteArtOK"
				modelAttribute="form">
				<input type="hidden" name="name" value="${name}" />
				<input type="submit" value="削除完了">
				<br>
				<br>
				<form action="39forced_deleteArt">
					<input type="submit" name="button" value="ユーザ記事一覧に戻る">
				</form>
			</form:form>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
				integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
				crossorigin="anonymous"></script>
		</div>
	</div>
</body>
</html>
