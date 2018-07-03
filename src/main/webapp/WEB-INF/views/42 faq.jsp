<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>よくある質問</title>
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
         		<li><a href="30contact">お問い合わせ</a></li>
         	</ul>
        </div>
        </div>
	</div>
	</div>
</header>
<div class="o_">
<div class="a_info">
	<p>よくあるご質問</p>
</div>
<div class = "o_wrapper">
<div class="a_">
<div class="text-center">
<div class="a_QandA">
	<div class="a_Q">
		<p>【質問】</p><p>この日記を使いたいのですがどうしたらいいですか？</p>
	</div>
	<div class="a_A">
		<p>【回答】</p><p>新規登録から会員登録をしていただけると日記の投稿が可能になります。</p>
	</div>
</div>
<div class="a_QandA">
	<div class="a_Q">
		<p>【質問】</p><p>この日記を使いたいのですがどうしたらいいですか？</p>
	</div>
	<div class="a_A">
		<p>【回答】</p><p>新規登録から会員登録をしていただけると日記の投稿が可能になります。</p>
	</div>
</div>
<br>
<br>
<p class="h3">このページで解決しない場合はお問い合わせへ</p>
<br>
<br>
<form:form action="30contact">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="お問い合わせへ">
</form:form>
</div>
</div>
</div>
</div>
</body>
</body>
</html>