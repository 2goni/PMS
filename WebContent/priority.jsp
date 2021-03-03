<%@page import="model.ProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<% List<ProductVO> list = (List<ProductVO>)request.getAttribute("list");%>
<div id="login"	style="width: 30%; text-align: center; margin: 0px auto;">
		<h3>우선생산 제품화면</h3>
		<table style="margin: auto;" border="1">
			<th>제품이름</th>
			<th>생산해야할 수량</th>
			<%
			for (ProductVO vo : list) {
			%>
			<tr>
				<td><%=vo.getPname()%></td>
				<td><%=vo.getPnum()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<input style="background: gold;" type="button"
			onclick="location.href='main.do'" value="메인화면">
</body>
</html>