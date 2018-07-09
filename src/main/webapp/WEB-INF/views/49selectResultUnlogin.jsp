<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面画面</title>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/f.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<script>
$(function() {
  var page = 0;
  function draw() {
    $('#page').html(page + 1);
    $('.select').hide();
    $('.select:first,.select:gt(' + page * 3 + '):lt(3)').show();
  }
  $('#prev').click(function() {
    if (page > 0) {
      page--;
      draw();
    }
  });
  $('#next').click(function() {
	  var size = $('.select').length;
    if (page < (size - 1) / 3 - 1) {
      page++;
      draw();
    }
  });
  draw();
});
</script>
<style>

#prev, #next {
  cursor: pointer;
}
</style>
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
<div class = "o_wrapper">
<p class ="h2"><span class="select"></span>${fn:escapeXml(keyword)}の検索結果</p>
<ul id="tbl1">
			<c:forEach items="${articlelist}" var="article" varStatus="status">
			<li class = "select"><a href="15art?art_id=${article.article_id}" class ="a_kensaku">${fn:escapeXml(article.article_title)}</a></li>
	</c:forEach>
</ul>
	<br>
	<br>
<div id= "button">
	<input type="button"  id="prev" value="前へ" class="btn btn-success btn-lg btn-block"><br>
	<input type="button"  id="next" value="次へ" class="btn btn-primary btn-lg btn-block"><br>
</div>
<br>
	<input type="submit" class="btn btn-info btn-lg  btn-block" name="button" value="検索画面に戻る" onclick="location.href='53selectUnlogin'; return false;">
	<br>
	<input type="submit" class="btn btn-primary btn-lg  btn-block" name="button" value="トップに戻る" onclick="location.href='47Top'; return false;">
	<br>
	<input type="submit" class="btn btn-info btn-lg  btn-block" name="button" value="新規登録" onclick="location.href='25userinsert'; return false;">
</div>

</div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</body>
</html>