<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報の編集画面</title>
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
<div class="a_">
<div class="text-center">
<div class="a_info">
<p>登録情報の更新</p>
</div>
<form:form action="20userinfoUpdateConfirm" method="post" modelAttribute="form">
<fieldset>
<div>
<label class="h2">名前</label>
<br>
<br><form:input path="newName" class="form-control input-lg"  value="${name}"/>
<form:errors path="newName" cssStyle="color: red; font-size: 20px"/>
<c:if test="${not empty sameerr}">
  <p class="a_denger">${fn:escapeXml(sameerr)}</p>
</c:if>
</div>
</fieldset>
<br>
<div>
<label class="h2">Eメール</label>

<form:input type="text" path="newEmail" class="form-control input-lg"  value="${email_address}"/>
<form:errors path="newEmail" cssStyle="color: red; font-size: 20px"/>
</div>
<br>
<div>
<label class="h2">パスワード</label>
<p><span class="a_denger">※半角英数字4文字以上10文字以下</span></p>
<br>
<form:input type="password" path="newPassword" class="form-control input-lg"  value="${password}"/>
<form:errors path="newPassword" cssStyle="color: red; font-size: 20px"/>
</div>
<br>
<br>
	<div class="a_btn">
		<input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="確認">
  </div>
  </form:form>
  <br>
<br>
<div class="a_return">
	<div class="a_btn">
	<input type="submit" class="btn btn-info btn-lg btn-block" name="button" value="基本ページに戻る" onclick="location.href='05mypage'; return false;">
	</div>

</div>
</div>
</div>
</div>

</body>
</html>
