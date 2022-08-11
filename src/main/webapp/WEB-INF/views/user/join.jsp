<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>

<h1>회원가입</h1>
<form:form>
	<div><input name="username" placeholder="아이디를 입력하세요"></div>
	<div><input name="password" type="password"></div>
	<div><input name="email" placeholder="이메일을 입력하세요"></div>
	<div><input name="realname" placeholder="이름을 입력하세요"></div>
	<div><input name="address" placeholder="주소를 입력하세요"></div>
	<div><input name="phone" placeholder="전화번호를 입력하세요"></div>
	<div><button>회원가입</button></div>
</form:form>

</body>
</html>