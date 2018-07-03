<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせフォーム</title>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/f.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
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
<div class = "o_wrapper">

<div class="a_">
<div class="text-center">
<form:form action="contactConfirm" method="post" modelAttribute="contactForm">
<fieldset>
<div>
<label class="h2">連絡用メールアドレス</label><br>
<form:input class="form-control input-lg" path="mail"/>
</div>
<div>
<label class="h3">件名</label><br>
<form:input class="form-control input-lg" path="subject"/>
</div>
<form>
<div class = "form-group">
<label class="h2">本文(お問い合わせ内容)</label><br>
<form:textarea rows = "4"class="form-control input-lg" path="content"/>
</div>
</form>
</fieldset>
<br>
<br>
<div class="a_btn">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="確認">
</div>
</form:form>
<br>
<br>
<p class="h3">よくある質問はこちらへ</p>
<br>
<div class="a_btn">
<input type="submit" class="btn btn-primary btn-lg btn-block" value="よくある質問はこちらへ" onclick="location.href='42faq'; return false;">
</div>
</div>
</div>
</div>
</div>
</body>
</html>