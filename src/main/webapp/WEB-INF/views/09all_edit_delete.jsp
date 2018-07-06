<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集・削除記事一覧</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/f.css" rel="stylesheet">
<script src="js/jquery.js"></script>
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
         		<li><a href="30 contact">お問い合わせ</a></li>
         	</ul>
        </div>
        </div>
	</div>
	</div>
</header>
<div class="o_">
<div class="a_">
<div class = "o_wrapper">

	<table>
		<tr>
			<th colspan="3" class = "h2">編集・削除したい記事を選んでください</th>
		</tr>
		<tr>
			<td  class = "o_td">
				<form method="post" action="08editArt">
					<div>
						<a href="15art" class = "h3">記事タイトル①</a>
					</div>
				</form>
			</td>
			<td  class = "o_td">
				<form method="post" action="10edit" >
				  <input type="submit" value="編集" class="btn  btn-success btn-lg">
				</form>
			</td>
			<td  class = "o_td">
				<form method="post" action="13deleteCon">
				  <input type="submit" value="削除"  class="btn  btn-danger btn-lg">
				</form>
			</td>
		</tr>
		<tr>
			<td  class = "o_td">
				<form method="post" action="08editArt">
					<div>
						<a href="15art.html" class = "h3">記事タイトル②</a>
					</div>
				</form>
			</td>
			<td  class = "o_td">
				<form method="post" action="10edit.html">
				  <input type="submit" value="編集"  class="btn  btn-success btn-lg">
				</form>
			</td>
			<td  class = "o_td">
				<form method="post" action="13deleteCon.html" >
				  <input type="submit" value="削除" class="btn  btn-danger btn-lg">
				</form>
			</td>
		</tr>
	</table>
	<br>
<br>
	<input type="submit" class="btn btn-info btn-lg" name="button" value="基本ページに戻る" onclick="location.href='05mypage.html'; return false;">
</div>
</div>
</div>
</body>
</html>