<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報編集確認画面</title>
<script src="js/jquery.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link href="css/f.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
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
		<div class="a_">
			<div class="text-center">
				<div class="a_info">
					<p>登録情報の変更確認</p>
					<p>これでよろしいですか</p>
				</div>

				<c:if test="${not empty msg}">
					<span class="require">${msg}</span>
				</c:if>
				<form:form action="21userinfoUpdateResult" method="post"
					modelAttribute="form">

					<fieldset>
						<div class="a_cc">
							<label class="h2">名前</label><br>
							<form:hidden path="newName"/>
							<p class="h3">${form.newName}</p>
						</div>
						<div class="a_cc">
							<label class="h2">メールアドレス</label> <br>
							<form:hidden path="newEmail"/>
							<p class="h3">${form.newEmail}</p>
						</div>
						<div class="a_cc">
							<label class="h2">パスワード</label> <br>
							<form:password path="newPassword" showPassword="true"
								class="form-control input-lg" />
						</div>
						<div class="a_cc">
							<label class="h2">パスワード(再入力)</label> <br>
							<form:password path="confirmNewPassword" showPassword="true"
								class="form-control input-lg" />
						</div>
					</fieldset>
					<br>
					<br>
					<div class="a_btn">
						<input type="submit" class="btn btn-primary btn-lg btn-block"
							name="button" value="更新完了">
					</div>
				</form:form>
				<br>
				<div class="a_btn">
					<input type="submit" class="btn btn-primary btn-lg btn-block"
						name="button" value="戻る"
						onclick="location.href='19userinfoUpdate'; return false;">
				</div>
			</div>
		</div>
	</div>

</body>
</html>