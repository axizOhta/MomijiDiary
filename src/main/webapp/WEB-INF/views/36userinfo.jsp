<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー表示画面</title>
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
<<<<<<< HEAD
						<ul>
							<li><a href="43managerMenu" id="manager">管理者メニュー</a></li>
=======
						<ul>
							<li><a href="43managerMenu.html" id="manager">管理者メニュー</a></li>
>>>>>>> refs/remotes/origin/UserUpdate
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>

		<div class="o_">
			<div class="o_wrapper">
				<div class="a_manager">
					<caption>ユーザー情報</caption>
					<table border="1" class="k_table">
						<thead>
							<tr>
								<th class="k_padding">ID</th>
								<th class="k_padding">ユーザー名</th>
								<th class="k_padding">メールアドレス</th>
								<th class="k_padding">登録日時</th>
								<th class="k_padding">最終更新日時</th>
								<th class="k_padding">記事削除</th>
								<th class="k_padding">強制退会</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userlist}" var="users">
								<tr>
									<td class="k_padding">${fn:escapeXml(users.user_id)}</td>
									<td class="k_padding">${fn:escapeXml(users.name)}</td>
									<td class="k_padding">${fn:escapeXml(users.email_address)}</td>
									<td class="k_padding">${fn:escapeXml(users.entry_date)}</td>
									<td class="k_padding">${fn:escapeXml(users.last_update_date)}</td>
									<td class="k_padding">
									 <form:form action="39forced_deleteArt" modelAttribute="form">
									 <input type = "hidden" name = "user_id" value = "${users.user_id}"/>
									 <input type = "hidden" name = "name" value = "${users.name}"/>
											<input type="submit" value="記事削除"></input>
										</form:form></td>
									<td class="k_padding">
										<form:form action="37userdelete" modelAttribute="form">
										<input type = "hidden" name = "user_id" value = "${users.user_id}"/>
										<input type = "hidden" name = "name" value = "${users.name}"/>
											<input type="submit" value="強制退会"></input>
										</form:form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="a_btn">
					<form action="43managerMenu">
						<input type="submit" value="メニュー" class="a_btn_manager">
					</form>
				</div>

			</div>
		</div>

</body>
</html>