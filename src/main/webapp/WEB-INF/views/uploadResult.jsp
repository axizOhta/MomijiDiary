<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
アップロードされました。<br>
ファイル名は<c:out value="${fileName}" /><br>
送信されたtestパラメータは<c:out value="${test}" />
<img src = "/images/${uploadedImage}">
</body>
</html>