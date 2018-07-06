<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
         		<li><a href="47 Top">トップページ</a></li>
         		<li><a href="54 contactUnlogin">お問い合わせ</a></li>
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
	<p class = "h1">釣りバカ日誌</p>
</div>
<div>
	<p class = "h4">～釣り好きの佐藤のブログです～</p>
</div>
<form action ="51 profileUnlogin.html">
<input type="submit" value="自己紹介" class="btn btn-primary btn-lg btn-block">
</form>
<br>
<br>
<div class="a_">
<div class = "o_wrapper">

	<table>
		<tr><th class ="h1">投稿した記事一覧</th></tr>
		<tr>
			<td class = "o_td"><a href="50 artUnlogin.html" class ="h2" >記事タイトル①</a></td>
		</tr>
		<tr>
			<td class = "o_td"><a href="50 artUnlogin.html"  class ="h2">記事タイトル②</a></td>
		</tr>
		<tr>
			<td class = "o_td"><a href="50 artUnlogin.html"  class ="h2">記事タイトル③</a></td>
		</tr>
	</table>

<br>
<br>
<div id= "button">
	<input type="submit" value="前へ" class="btn btn-success btn-lg btn-block">
	<input type="submit" value="次へ" class="btn btn-primary btn-lg btn-block"><br>
</div>
<br>
<br>
<input type="submit" class="btn btn-info  btn-lg btn-sucsses" name="button" value="トップページに戻る" onclick="location.href='47Top'; return false;">
<br>
	<input type="submit" class="btn btn-info btn-lg  btn-block" name="button" value="新規登録" onclick="location.href='25userinsert'; return false;">

</div>
</div>
</div>
</div>
</div>
</body>
</html>