<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録確認画面</title>
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
<div class="a_">
<div class="a_info">
<p>新規登録情報の確認</p>
<p>これでよろしいですか</p>
</div>
<div class="text-center">
<form:form action="27userinsertResult" method="post"
						modelAttribute="form">
<fieldset>
<div class="a_cc">
<label class="h2">名前</label><br>
<p class="h3">${fn:escapeXml(userinsert.name)}</p>
</div>
<div class="a_cc">
<label class="h2">ログインID</label><br><p class="h3"><br>
<p class="h3">${fn:escapeXml(userinsert.login_id)}</p>
</div>
<div class="a_cc">
<label class="h2">メールアドレス</label>
<br>
<p class="h3">${fn:escapeXml(userinsert.email_address)}</p>
</div>
<div class="a_cc">
<label class="h2">パスワード</label><br>
<form:password class="form-control input-lg" path="password" readonly="true" showPassword="true"/></p>
</div>
<div class="a_cc">
<label class="h2">パスワード(再入力)</label><br>
<form:password class="form-control input-lg" path="repassword"/>
</div>
</div>
</fieldset>
<br>
<br>
<div class="a_btn">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="登録完了" onclick="location.href='05mypage'; return false;">
</form:form>
  <br>
<br>
<input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="戻る" onclick="location.href='25userinsert'; return false;">
  </div>
  </div>
  </div>
  </div>
</body>
</html>