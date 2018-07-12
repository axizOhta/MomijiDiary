<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ履歴画面(管理者)</title>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/f.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
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
         		<li><a href="43managerMenu" id="manager">管理者メニュー</a></li>
         	</ul>
        </div>
        </div>
	</div>
	</div>
</header>
<div class="o_">
<div class = "o_wrapper">
<div class="a_manager">
<p class = "k_center k_bold">問い合わせ一覧</p>
<fieldset>
<caption>ユーザー情報</caption>
	<table border="1">
	<thead>
	    <tr>
	     <th class = "a_content">問い合わせ日時</th>
	      <th class = "k_padding">ユーザーID</th>
	      <th class = "k_padding">連絡先</th>
	      <th class = "k_padding">件名</th>
	      <th class = "a_content">問い合わせ内容</th>
	    </tr>
	  </thead>
	  <tbody>
	   <c:forEach items="${contactlist}" var="contact">
	  <tr>
	  	<td>${fn:escapeXml(contact.contact_date)}</td>
        <td> <a href="52all_postArtUnlogin?user_id=${contact.user_id}" target="newtab">${contact.user_id}</a></td>
        <td>${fn:escapeXml(contact.email_address)}</td>
        <td>${fn:escapeXml(contact.contact_title)}</td>
        <td>${fn:escapeXml(contact.contact_message)}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</fieldset>
<div class="a_return">
	<div class="a_btn">
	<input type="submit" name="button" value="メニュー" onclick="location.href='43managerMenu'; return false;">
	</div>
</div>
</div>
</div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</body>
</html>