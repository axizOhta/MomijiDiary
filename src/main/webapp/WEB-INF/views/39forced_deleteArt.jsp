<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記事強制削除</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/f.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
</head>
<body>
	<header>
		<div id="header-fixed">
			<div id="a_header-bk">
				<div class="a_center">
					<div class="a_form_conf">
						<img src="image/image002.png" alt="" class="a_momiji"><a>もみじ日記</a>
					</div>
					<div class="a_menu">
						<ul>
							<li><a href="43managerMenu" id="manager">管理者メニュー</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="o_">
		<div class="o_wrapper">
			<p>${ msg }</p>
			<p>対象ユーザ：${name}さん</p>
			<p>削除する記事を選択してください</p>
		<form:form action="40forced_deleteArtCon" modelAttribute="form">
			<div class="table_-responsive">
				<table border="1" class="k_table">
					<c:forEach items="${userlist}" var="users">
						<tr>
							<td class="k_padding"><a href="50artUnlogin?art_id = ${users.article_id}"
								target="newtab">${fn:escapeXml(users. article_title)}</a></td>
							<td><input type="checkbox" id="select_article_id" name="check" value="${users.article_id}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br>

				<input type="hidden" name="user_id" value="${user_id}" />
				<input type="hidden" name="name" value="${name}" />
				<input type="submit" value="削除確認">
				<br>
				<br>
			</form:form>
			<form action="36userinfo">
				<input type="submit" name="button" value="ユーザー一覧へ">
			</form>

		</div>
	</div>
</body>
</html>
