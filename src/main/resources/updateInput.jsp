<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容入力画面</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js" type="text/javascript" ></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/update.css" rel="stylesheet">
<link href="css/commons.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
		<div class="container">
		 <div class="navbar-header">
            <a class="navbar-brand">アイス在庫管理システム</a>
        </div>
				<form:form action="post" modelAttribute="form" >
				</form:form>
				<ul class="nav navbar-nav">
			<li><a href="menu">メニュー</a></li>
            <li><a href="select">在庫検索</a></li>
            <li ><a href="insert">登録</a></li>
            <li><a href="update">更新</a></li>
            <li><a href="delete">削除</a></li>
        </ul>

    </div>
</nav>
<div id="sample" >
<div class="article">
			<div class="wrapper">
<p>１箇所以上の項目を変更してください<br>
※バーコードNo.は変更できません</p>

<c:if test="${not empty msg}">
   <span class="require">${msg}</span>
  </c:if>

<form:form action="updateConfirm" method="post" modelAttribute="form">
  <fieldset class="label-110">
    <div>
     <br> <label>バーコードNo.</label><form:input path="id" readonly="true" />
    </div>
    <div>
      <br><label>商品名</label><form:input path="newName" />
    </div>
    <div>
      <br><label>在庫数</label><form:input path="newStock" />
    </div>
    <div>
      <br><label>価格</label><form:input path="newPrice" />
    </div>
    <div>
      <br><label>購入日時</label><form:input path="newTime"/>
    </div>
  </fieldset>
  <br>
  <br>
  <div>
    <input type="submit" name="button" value="確認" class="btn btn-lg btn-warning btn-block">
    <br>
    <input type="submit" name="button" value="戻る" class="btn btn-lg btn-danger btn-block" onclick="location.href='update'; return false;">
  </div>
</form:form>

</div>
</div>
</div>
</body>
</html>
