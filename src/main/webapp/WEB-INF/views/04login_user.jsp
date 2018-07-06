<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>ログイン画面</title>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/f.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
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
         		<li class="a_select"><a href="53 selectUnlogin">検索</a></li>
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
	<form:form action="login" modelAttribute="form">
  <fieldset>
  		<c:if test="${not empty errmsg}">
  		<p class="a_denger">${errmsg}</p>
		</c:if>
    <div>
      <label class="h2">IDを入力してください</label><br>
      <form:input type="text" class="form-control input-lg" id="id" path="login_id"></form:input>
    </div>
    <div>
      <label class="h2">パスワードを入力してください</label><br>
      <form:input type="password" class="form-control input-lg" id="pass" path="password"/>
    </div>
  </fieldset>
  <br>
<br>
<br>
<div class="a_btn">
  <input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="ログインする">
 </div>
 </form:form>
  <br>
<br>
<form action ="top">
<div class="a_btn">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="前のページに戻る">
</div>
</form>
</div>
</div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>