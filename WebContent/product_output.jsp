<%@page import="model.ProductVO"%>
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
	List<GroupcodeVO> list = (List<GroupcodeVO>) request.getAttribute("list");
	ProductVO vo = (ProductVO) request.getAttribute("vo");
	%>
	<h3 style="text-align: center">생산관리 등록화면</h3>
	<form name="mainform" action="search.do" method="post">
		<fieldset style="width: 610px; margin: 0 auto;">
			<legend>
				<b>생산관리 등록화면</b>
			</legend>
			<ul>
				<li>제품코드 <input type="text" name="code" <%if (vo != null) {%>
					value="<%=vo.getCode()%>" <%}%>autofocus required></li>
				<li>제품이름 <input type="text" name="pname" <%if (vo != null) {%>
					value="<%=vo.getPname()%>" required <%}%>></li>
				<li>제품원가 <input type="number" name="cost" <%if (vo != null) {%>
					value="<%=vo.getCost()%>" required <%}%>></li>
				<li>목표수량 <input type="number" name="pnum" <%if (vo != null) {%>
					value="<%=vo.getPnum()%>" required <%}%>></li>
				<li>재고수량 <input type="number" name="inum" <%if (vo != null) {%>
					value="<%=vo.getInum()%>" required <%}%>></li>
				<li>출고가 &nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="sale"
					<%if (vo != null) {%> value="<%=vo.getSale()%>" required <%}%>></li>
				<li>그룹이름 <select name="gcode">
						<%
						for (GroupcodeVO gvo : list) {
						%>
						<option
							value="<%=gvo.getGcode()%>" <%if (vo != null) { if(gvo.getGcode().equals(vo.getGcode())){%> selected <%}}%> ><%=gvo.getGname()%></option>
						<%
						}
						%>
				</select>
				</li>
			</ul>
			<button style="background: gold; width: 100px; height: 30px;"type="submit" formaction="search.do" formmethod="post" >조회</button>
			<button style="background: gold; width: 100px; height: 30px;"type="submit" formaction="update.do" formmethod="post" >수정</button>
			<button style="background: gold; width: 100px; height: 30px;"type="submit" formaction="delete.do" formmethod="post" >삭제</button>
			<input style="background: gold; width: 100px; height: 30px;" type="button" onclick="location.href='main.do'" value="메인화면">
		</fieldset>
	</form>
</body>
</html>