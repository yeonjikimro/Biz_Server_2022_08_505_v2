<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
		<th>내용</th>
	</tr>
	<tr>
		<td>${todo.context}</td>
	</tr>
	</table>

	<form:form>
		<div>
			<input name="context" placeholder="해야할 일">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form:form>
</body>
</html>