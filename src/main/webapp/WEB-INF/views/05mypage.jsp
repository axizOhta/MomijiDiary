<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/f.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</head>
<body>
<c:if test="${empty user}">
		<c:redirect url="47Top" />
</c:if>

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
<p class ="h2">ようこそ${fn:escapeXml(user.name)}さん</p>
<br>
<br>
<div class="a_">
<form action ="44myArt">
	<input type="submit" value= "自分の記事" class="btn btn-success btn-lg btn-block">
</form>

<br>
<br>

<form action ="45myPro">
	<input type="submit" value= "自己紹介" class="btn btn-info btn-lg btn-block">
</form>

<br>
<br>

<form action ="19userinfoUpdate">
<input type="submit" value="登録情報の更新" class="btn btn-primary btn-lg btn-block">
</form>

<br>
<br>

<form action ="33contactHis">
<input type="submit" value="お問い合わせ履歴" class="btn btn-primary btn-lg btn-block">
</form>

<br>
<br>
<br>
<br>
<form action="logout" method="POST">
	<input type="submit" value="ログアウト" class="btn btn-warning btn-lg btn-block">
</form>

<br>
<br>
<form action ="48unsubscribepass">
<input type="submit" value="退会" class="btn btn-danger btn-lg btn-block">
</form>
</div>
</div>
</div>
</body>
</html>