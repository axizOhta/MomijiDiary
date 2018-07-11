<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ確認画面</title>
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
<div class = "o_wrapper">
<div class="a_">
<p class="h2">こちらでよろしいですか</p>
<fieldset>
<div class="a_cc">
<p class="h2">連絡用メールアドレス</p>
<p class="h3">${fn:escapeXml(contact.email_address)}</p>
</div>
<div class="a_cc">
<p class="h2">件名</p>
<p class="h3">${fn:escapeXml(contact.contact_title)}</p>
</div>
<div class="a_cc">
<p class="h2">本文(お問い合わせ内容)</p>
<p class="h3">${fn:escapeXml(contact.contact_message)}</p>
</div>
</fieldset>
<br>
<div id="a_btn">
<input type="submit"  class="btn btn-primary btn-lg btn-block" value="送信" onclick="location.href='56contactResultUnlogin'; return false;">
</div>
<br>
<div id="a_btn">
<input type="submit" class="btn btn-primary btn-lg btn-block" value="戻る" onclick="location.href='54contactUnloginBack'; return false;">
</div>
</div>
</div>
</div>
</body>
</html>