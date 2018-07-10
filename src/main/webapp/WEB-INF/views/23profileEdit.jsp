<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール編集画面</title>
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
		<div class="o_wrapper">
			<div class="a_info">
				<p class="h2">自己紹介の編集</p>
				<br>
			</div>
			<div class="a_form">
				<form:form action="24profileEditResult" modelAttribute="form"
					enctype="multipart/form-data">
					<div id="a_photo">
						<div class="a_pro_photo">
							<div class="a_photos">
								<img id="img1" class="a_user_photo" /> <label
									class="btn btn-default btn-lg btn-block" id="a_line">
									自己紹介写真の変更<form:input id="photo1" type="file" path="profile_image"
										style="display: none" />
								</label>
								<input type="hidden"
									class="btn btn-danger btn-lg btn-block" value="写真を設定しない"
									onclick="clearValue1();" id="delete1">
							</div>
						</div>
					</div>
					<br>
					<br>
					<div class="a_">
						<div class="a_sukima">
							<label for="title" class="a_midashi">名前</label><br>
							<form:input class="form-control input-lg" id="name" path="name"
								placeholder="${beforeProfile.name}" />
							<br> <label for="title" class="a_midashi">誕生日<span
								class="a_denger">※半角数字</span></label><br>
							<div class="row">
								<div class="col-lg-6">
									<form:input path="birthyear" class="form-control input-lg"
										min="0" max="4" placeholder="${beforeProfile.birthyear}" />
									<label class="h4">年</label>
								</div>
								<div class="col-sm-3">
									<form:input path="birthmonth" class="form-control input-lg"
										min="0" max="2" placeholder="${beforeProfile.birthmonth}" />
									<label class="h4">月</label>
								</div>
								<div class="col-sm-3">
									<form:input path="birthday" class="form-control input-lg"
										min="0" max="2" placeholder="${beforeProfile.birthday}" />
									<label class="h4">日</label>
								</div>
							</div>
							<br>

							<div class="a_sukima">
								<label for="title" class="a_midashi">性別</label><br>
								<form:input class="form-control input-lg" id="name" path="sex"
									placeholder="${beforeProfile.sex}" />
							</div>
							<br>

							<div class="a_sukima">
								<label for="title" class="a_midashi">趣味</label><br>
								<form:input class="form-control input-lg" id="name" path="hobby"
									placeholder="${beforeProfile.hobby}" />
							</div>
							<br>
							<div class="a_sukima">
								<label for="title" class="a_midashi">自己紹介(300字)</label><br>
								<form:textarea class="form-control input-lg" id="name"
									path="self_introduction"
									placeholder="${beforeProfile.self_introduction}" />
							</div>
							<br>
							<div class="a_btn">
								<form:button class="btn btn-warning btn-lg btn-block">変更</form:button>
							</div>
						</div>
				</form:form>
				<div class="a_return">
					<input type="submit" class="btn btn-info btn-lg btn-block"
						name="button" value="基本ページに戻る"
						onclick="location.href='05mypage'; return false;">
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		function getValue(id) {
			var value = $("#" + id).val();
			window.alert(value);
		}
		function clearValue1() {
			$("#photo1").val("");
			$("#img1").attr("src", "plofile/images/default.jpg");
			$("#img1").attr("title", "default");
			$("#delete1").attr("type", "hidden");
		}
	</script>
	<script>
		$(function() {
			$('#photo1').change(function(e) {
				//ファイルオブジェクトを取得する
				var file = e.target.files[0];
				var reader = new FileReader();

				//画像でない場合は処理終了
				if (file.type.indexOf("image") < 0) {
					alert("画像ファイルを指定してください。");
					return false;
				}

				//アップロードした画像を設定する
				reader.onload = (function(file) {
					return function(e) {
						$("#img1").attr("src", e.target.result);
						$("#img1").attr("title", file.name);
						$("#delete1").attr("type", "button");
					};
				})(file);
				reader.readAsDataURL(file);

			});
		});
	</script>
</body>
</html>