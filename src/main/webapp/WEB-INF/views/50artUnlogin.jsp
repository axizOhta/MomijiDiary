<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>記事</title>
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
         		<li class="a_select"><a href="53selectUnlogin">検索</a></li>
         		<li><a href="47Top">トップページ</a></li>
         		<li><a href="54contactUnlogin">お問い合わせ</a></li>
         	</ul>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="o_">

		<div class="o_wrapper">
			<c:choose>
				<c:when test="${!empty noArt}">
					<p class="a_denger">${noArt}</p>
				</c:when>
				<c:otherwise>
					<div>
						<p class="h2">${ art.name }さんの日記</p>
					</div>
					<div class="a_">
						<form:form action="51profileUnlogin" modelAttribute="form">
							<form:hidden path="user_id" />
							<input type="submit" value="自己紹介"
								class="btn btn-primary btn-lg btn-block">
						</form:form>
						<br> <br>
						<div>
							<div class="a_article">
								<div class="a_line">
									<p class="h2">${ art.article_title }</p>
								</div>
								<div class="a_line">
									<p class="h4">${ art.contribute_date }</p>
								</div>
								<div>
									<p class="a_kiji">${ art.article_main }</p>
								</div>
								<c:if test="${not empty art.image_1}">
									<div class="o_pattern1">
										<img src="${ art.image_1 }" alt="">
									</div>
								</c:if>
								<c:if test="${not empty art.image_2}">
									<div class="o_pattern1">
										<img src="${ art.image_2 }" alt="">
									</div>
								</c:if>
								<c:if test="${not empty art.image_3}">
									<div class="o_pattern1">
										<img src="${ art.image_3 }" alt="">
									</div>
								</c:if>
								<c:if test="${not empty art.image_4}">
									<div class="o_pattern1">
										<img src="${ art.image_4 }" alt="">
									</div>
								</c:if>
							</div>
						</div>
				</c:otherwise>
			</c:choose>
			<div class="a_">
				<br> <br> <input type="submit" class="btn btn-primary btn-lg  btn-block" name="button" value="トップページに戻る" onclick="location.href='47Top'; return false;">
				<br> <input type="submit"
					class="btn btn-info btn-lg  btn-block" name="button" value="新規登録"
					onclick="location.href='25userinsert'; return false;">
			</div>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
			integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
			crossorigin="anonymous"></script>
		</div>
	</div>
</body>
</html>