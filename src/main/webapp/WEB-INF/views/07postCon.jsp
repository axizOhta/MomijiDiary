<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
         		<li class="a_select"><a href="17select.html">検索</a></li>
         		<li><a href="05mypage.html">基本ページ</a></li>
         		<li><a href="30 contact.html ">お問い合わせ</a></li>
         	</ul>
        </div>
        </div>
	</div>
	</div>
</header>
<div class="o_">
<div class="a_info">
	<p>投稿内容の確認</p>
	<p><span class="a_denger">※まだ投稿は完了していません！</span></p>
</div>

<div class = "o_wrapper">
<div class="a_">
<div class ="a_article">
	<div class="a_line">
		<p class = "h2">マグロ釣った！</p>
	</div>
	<div class="a_line">
		<p class ="h4">7月2日20時15分</p>
	</div>
	<div>
		<p class ="a_kiji">今日はマグロを釣った！<br>大漁だ！</p>
	</div>
	<div class="o_pattern1">
	  <img src="image/maguro.jpg"  alt="">
	</div>
</div>
<div class ="a_form">
<div class="a_btn">
<form:form action="08postOK" modelAttribute="form">

	<input  class="btn btn-warning btn-lg btn-block" type="submit" value="投稿完了">
	<br>
	<input type="submit" class="btn btn-success btn-lg btn-block" name="button" value="編集に戻る" onclick="location.href='06post.html'; return false;">
	<div class="a_return">
	<input type="submit" class="btn btn-info btn-lg btn-block" name="button" value="基本ページに戻る" onclick="location.href='05mypage.html'; return false;">
	</div>
</form:form>
</div>
</div>
</div>
</div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</body>
</html>