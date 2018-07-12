<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ履歴</title>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/f.css" rel="stylesheet">
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


<div class = "o_wrapper">
<div class="a_">
<div class = "table-responsive">
<div class="a_table">

	<table class = "k_table" border="1">
	<tbody>
	   <c:forEach items="${contactlist}" var="contact">
	  <tr>
		<th class="k_title">お問い合わせ履歴</th>
		</tr>
	  <tr>
	  	<td class="a_date">${fn:escapeXml(contact.contact_date)}</td>
	  	</tr>
        <td class="k_bold">${fn:escapeXml(contact.contact_title)}</td>
       <tr>
        <td class="a_contact">${fn:escapeXml(contact.contact_message)}</td>
      </tr>
    </c:forEach>
  </tbody>

	</table>

</div>
</div>
<br>
<div class = "k_center">
	<input type="submit" class="btn btn-info btn-lg btn-block" name="button" value="基本ページに戻る" onclick="location.href='05mypage'; return false;">
</div>
<div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</div>
</div>
</div>
</div>
</body>
</html>