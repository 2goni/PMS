<%@page import="model.GroupcodeVO"%>
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
<%
	List<GroupcodeVO> list = (List<GroupcodeVO>)request.getAttribute("list");
%>
<h3 style="text-align: center"> 생산관리 등록화면 </h3>
<form action="pdbinput.do" method="post">
 <fieldset style="width: 610px; margin:0 auto;">
  <legend><b>생산관리 등록화면</b></legend>
  <ul>
  <li>제품코드 <input type="text" name="code" autofocus required></li>
  <li>제품이름 <input type="text" name="pname" required></li>
  <li>제품원가 <input type="number" name="cost" required></li>
  <li>목표수량 <input type="number" name="pnum" required></li>
  <li>재고수량 <input type="number" name="inum" required></li>
  <li>출고가 &nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="sale" required></li>
  <li>그룹이름 
  <select name="gcode">
  <%
  	for(GroupcodeVO vo : list){ %>
  		<option value="<%= vo.getGcode()%>"><%= vo.getGname()%></option>
  	<%}%>
  </select>  
  </li>
  </ul>
  <input type="submit" style="background:gold; width: 100px; height: 30px;" name="create" value="등록">
  <input type="button" style="background:gold; width: 100px; height: 30px;" onclick="location.href='main.do'" value="메인화면">
 </fieldset>
 </form>
</body>
</html>