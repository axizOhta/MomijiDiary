<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投稿記事一覧画面</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/f.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
$(function() {
  var page = 0;
  function draw() {
    $('#page').html(page + 1);
    $('tr').hide();
    $('tr:first,tr:gt(' + page * 3 + '):lt(3)').show();
  }
  $('#prev').click(function() {
    if (page > 0) {
      page--;
      draw();
    }
  });
  $('#next').click(function() {
	  var size = tbl1.rows.length;
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
<div>
	<p class = "h2">${name}さんの日記</p>
</div>
<form action ="22profile">
<input type="submit" value="自己紹介" class="btn btn-primary btn-lg btn-block">
</form>
<br>

<br>
<div class="a_">
<div class = "o_wrapper">
    <table id="tbl1">
		<tr><th class ="h1">投稿した記事一覧</th></tr>
		<c:forEach var="list" items="${list}"  varStatus="status">
			<tr>
				<td class = "o_td"><a href="15art?art_id=${list.article_id}" class ="h2">${list.article_title}</a></td>
			</tr>
		</c:forEach>
	</table>

<br>
<br>
<div id= "button">
	<input type="button"  id="prev" value="前へ" class="btn btn-success btn-lg btn-block"><br>
	<input type="button"  id="next" value="次へ" class="btn btn-primary btn-lg btn-block"><br>
</div>
<br>
<br>
<input type="submit" class="btn btn-info  btn-lg btn-block" name="button" value="基本ページに戻る" onclick="location.href='05mypage'; return false;">

</div>
</div>
</div>
</div>
</div>
</body>
</html>