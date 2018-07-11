<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール画面</title>
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

		<div class="a_info">
			<p>自己紹介</p>
		</div>
		<div class="a_form">

			<div class="o_pattern1">
				<img src="${Profile.profile_image}" alt="">
			</div>
			<div class="a_">
				<form action="16all_postArt">
					<input type="submit" class="btn btn-warning btn-lg btn-block"
						value="記事を見る">
				</form>

				<div class="a_btn">

					<div class="panel panel-success">
						<div class="panel-heading">
							<h3 class="panel-title">名前</h3>
						</div>
						<div class="panel-body">${Profile.name}</div>
						<div class="panel-heading">
							<h3 class="panel-title">性別</h3>
						</div>
						<div class="panel-body">${Profile.sex}</div>
						<div class="panel-heading">
							<h3 class="panel-title">誕生日</h3>
						</div>
						<div class="panel-body">
							<c:if test="${not empty newProfile.birthyear}">
										${newProfile.birthyear}年
									</c:if>
							<c:if test="${not empty newProfile.birthmonth}">
										${newProfile.birthmonth}月
									</c:if>
							<c:if test="${not empty newProfile.birthday}">
										${newProfile.birthday}日
									</c:if>
						</div>
						<div class="panel-heading">
							<h3 class="panel-title">趣味</h3>
						</div>
						<div class="panel-body">${Profile.hobby}</div>
						<div class="panel-heading">
							<h3 class="panel-title">ひとこと</h3>
						</div>
						<div class="panel-body">${Profile.self_introduction}</div>
					</div>

				</div>

				<div>

					<div class="a_return">
						<input type="submit" class="btn btn-info btn-lg btn-block"
							name="button" value="基本ページに戻る"
							onclick="location.href='05mypage'; return false;">
					</div>
				</div>
			</div>
		</div>
		</div>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
			integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
			crossorigin="anonymous"></script>
</body>
</html>