<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自分の記事</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/f.css" rel="stylesheet">
<script src="js/jquery.js"></script>
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
	<div class="a_btn">
	<form method="post" action="06post">
	<input type="submit" value= "新しく記事を書く" class="btn btn-warning btn-lg btn-block">
	</form>
	</div>
	<div class="a_btn">
	<form method="post" action="16all_postArt">
	<input type="submit" value= "投稿した記事を見る" class="btn btn-primary btn-lg btn-block">
	</form>
	</div>

	<div class="a_btn">
	<form method="post" action="09all_edit_delete">
		<input type="submit" value= "記事の編集・削除" class="btn btn-danger btn-lg btn-block">
	</form>
	</div>
<div class="a_return">
	<div class="a_btn">
	<input type="submit" class="btn btn-info btn-lg btn-block" name="button" value="基本ページに戻る" onclick="location.href='05mypage.html'; return false;">
	</div>
<div>
</div>
</div>
</div>
</div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>