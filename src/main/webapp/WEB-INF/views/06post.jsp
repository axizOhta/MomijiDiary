<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投稿画面</title>
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
		<form:form action="07postCon" modelAttribute="form" enctype="multipart/form-data">
			<div class="a_form">
				<div class="a_info">
					<p>記事の投稿</p>
				</div>
				<p><span class="a_denger">${msg}</span></p>
				<div>
					<label for="title" class="a_midashi">記事の題名</label><br>
					<form:input class="form-control input-lg" id="title" name="title"
						path="article_title" placeholder="記事の題名" />
				</div>
				<br>
				<div>
					<label for="content" class="a_midashi">本文</label>
					<form:textarea class="form-control  input-lg" rows="8" id="comment"
						path="article_main" placeholder="本文" />
				</div>


				<div id="a_photo">
					<div class="row">
						<div class="col-xs-12 col-md-6">
							<div class="a_photos">
								<label class="btn btn-default btn-lg btn-block" id="a_line">
									写真を追加①<form:input type="file" path="file" style="display: none" id="photo1" />
								</label>
								<p>ここに写真が表示されます</p>
								<img id="img1" class="a_user_photo" /> <input type="hidden"
									class="btn btn-danger btn-lg btn-block" value="写真①の削除"
									onclick="clearValue1();" id="delete1">
							</div>

						</div>
						<div class="col-xs-12 col-md-6">

							<div class="a_photos">
								<label class="btn btn-default btn-lg btn-block">
								写真を追加②<form:input type="file" path="file" style="display: none" id="photo2" />
								</label>
								<p>ここに写真が表示されます</p>
								<img id="img2" class="a_user_photo" /> <input type="hidden"
									class="btn btn-danger btn-lg btn-block" value="写真②の削除"
									onclick="clearValue2();" id="delete2">

							</div>

						</div>
						<div class="col-xs-12 col-md-6">

							<div class="a_photos">
								<label class="btn btn-default btn-lg btn-block">
								写真を追加③<form:input type="file" path="file" style="display: none" id="photo3" />
								</label>
								<p>ここに写真が表示されます</p>
								<img id="img3" class="a_user_photo" /> <input type="hidden"
									class="btn btn-danger btn-lg btn-block" value="写真③の削除"
									onclick="clearValue3();" id="delete3">

							</div>

						</div>
						<div class="col-xs-12 col-md-6">

							<div class="a_photos">
								<label class="btn btn-default btn-lg btn-block">
								写真を追加④<form:input type="file" path="file" style="display: none" id="photo4" />
								</label>
								<p>ここに写真が表示されます</p>
								<img id="img4" class="a_user_photo" /> <input type="hidden"
									class="btn btn-danger btn-lg btn-block" value="写真④の削除"
									onclick="clearValue4();" id="delete4">

							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="a_">
				<input class="btn btn-warning btn-lg btn-block" type="submit"
					value="表示の確認">
				<div class="a_return">
					<input type="submit" class="btn btn-info btn-lg btn-block"
						name="button" value="基本ページに戻る"
						onclick="location.href='05mypage.html'; return false;">
				</div>

			</div>
		</form:form>
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
			$("#img1").attr("src", "");
			$("#img1").attr("title", "");
			$("#delete1").attr("type", "hidden");
		}
		function clearValue2() {
			$("#photo2").val("");
			$("#img2").attr("src", "");
			$("#img2").attr("title", "");
			$("#delete2").attr("type", "hidden");
		}
		function clearValue3() {
			$("#photo3").val("");
			$("#img3").attr("src", "");
			$("#img3").attr("title", "");
			$("#delete3").attr("type", "hidden");
		}
		function clearValue4() {
			$("#photo4").val("");
			$("#img4").attr("src", "");
			$("#img4").attr("title", "");
			$("#delete4").attr("type", "hidden");
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
		$(function() {
			$('#photo2').change(function(e) {
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
						$("#img2").attr("src", e.target.result);
						$("#img2").attr("title", file.name);
						$("#delete2").attr("type", "button");
					};
				})(file);
				reader.readAsDataURL(file);

			});
		});
		$(function() {
			$('#photo3').change(function(e) {
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
						$("#img3").attr("src", e.target.result);
						$("#img3").attr("title", file.name);
						$("#delete3").attr("type", "button");
					};
				})(file);
				reader.readAsDataURL(file);

			});
		});
		$(function() {
			$('#photo4').change(function(e) {
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
						$("#img4").attr("src", e.target.result);
						$("#img4").attr("title", file.name);
						$("#delete4").attr("type", "button");
					};
				})(file);
				reader.readAsDataURL(file);

			});
		});
	</script>
</body>
</html>