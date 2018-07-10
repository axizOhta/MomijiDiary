<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール変更完了画面</title>
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
							<li><a href="30 contact">お問い合わせ</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="o_">
		<div class="a_">
			<div class="o_wrapper">
				<p class="h2">以下で登録しました</p>
				<form action="05mypage">
						<div class="a_btn">
							<div class="panel panel-success">
								<div id="a_photo">
									<div class="a_pro_photo">
										<div class="a_photos">
											<img src="profile/images/${newProfile.profile_image}" title="写真①" class="a_user_photo">
										</div>
									</div>
								</div>
								<div class="panel-heading">
									<h3 class="panel-title">名前</h3>
								</div>
								<div class="panel-body">${newProfile.name}</div>
								<div class="panel-heading">
									<h3 class="panel-title">性別</h3>
								</div>
								<div class="panel-body">${newProfile.sex}</div>
								<div class="panel-heading">
									<h3 class="panel-title">誕生日</h3>
								</div>
								<div class="panel-body">${newProfile.birthyear}年${newProfile.birthmonth}月${newProfile.birthday}日</div>
								<div class="panel-heading">
									<h3 class="panel-title">趣味</h3>
								</div>
								<div class="panel-body">${newProfile.hobby}</div>
								<div class="panel-heading">
									<h3 class="panel-title">自己紹介</h3>
								</div>
								<div class="panel-body">${newProfile.self_introduction}</div>
							</div>
						</div>
						<br>
						<br>
						<input type="submit" value="基本ページに戻る" class="btn btn-info btn-lg btn-block">
				</form>
			</div>
		</div>
	</div>
</body>
</html>