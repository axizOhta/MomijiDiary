<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
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
<div class="text-center">
<form:form action="26userinsertConfirm" method="post"
						modelAttribute="form">
<fieldset>
<div>
<label class="h2">名前</label><br>
<form:input class="form-control input-lg" path="name"/>
<form:errors path="name" cssStyle="color: red"/>
</div>
<br>
<div>
<label class="h2">ログインID</label>
<p><span class="a_denger">※ひらがな、カタカナ、漢字、英数字で4文字以上10文字以内</span></p>
<p><span class="a_denger">※名前と同じにはできません</span></p>
<c:if test="${not empty sameerr}">
  <p class="error">${fn:escapeXml(sameerr)}</p>
</c:if>
<c:if test="${not empty alrderr}">
  <p class="error">${fn:escapeXml(alrderr)}</p>
</c:if>
<br>
<form:input class="form-control input-lg" path="login_id"/>
<form:errors path="login_id" cssStyle="color: red"/>
</div>
<br>
<div>
<label class="h2">メールアドレス</label>
<br>
<form:input class="form-control input-lg" path="email_address"/>
<form:errors path="email_address" cssStyle="color: red"/>
</div>
<br>
<div>
<label class="h2">パスワード</label>
<p><span class="a_denger">※半角英数字4文字以上10文字以下</span></p>
<br>
<c:if test="${not empty nhlferr}">
  <p class="error">${fn:escapeXml(nhlferr)}</p>
</c:if>
<form:password class="form-control input-lg" path="password"/>
<form:errors path="password" cssStyle="color: red"/>
</div>
</fieldset>
<br>
<br>
	<div class="a_btn">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="確認">
  </div>
  </form:form>
  <br>
<br>
<div class="a_btn">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="前のページに戻る" onclick="location.href='47 Top.html'; return false;">
</div>
</div>
</div>
</div>
</body>
</html>