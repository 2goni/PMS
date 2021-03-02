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
<form name="mainform" action="" method="post">
 <fieldset style="width: 610px; margin:0 auto;">
  <legend><b>생산관리 등록화면</b></legend>
  <ul>
  <li>제품코드 <input type="text" name="code"></li>
  <li>제품이름 <input type="text" name="name"></li>
  <li>제품원가 <input type="text" name="cost"></li>
  <li>목표수량 <input type="text" name="tquantity"></li>
  <li>재고수량 <input type="text" name="squantity"></li>
  <li>출고가 &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="price"></li>
  <li>그룹이름 
  <select name="gcode">
  <%
  	for(GroupcodeVO vo : list){ %>
  		<option value="<%= vo.getGcode()%>"><%= vo.getGname()%></option>
  	<%}%>
  </select>  
  </li>
  </ul>
  <input style="background:gold; width: 100px; height: 30px;" type="button" onclick="click(1)" value="조회">
  <input style="background:gold; width: 100px; height: 30px;" type="button" onclick="click(2)" value="수정">
  <input style="background:gold; width: 100px; height: 30px;" type="button" onclick="click(3)" value="삭제">
  <input style="background:gold; width: 100px; height: 30px;" type="button" onclick="location.href='main.do'" value="메인화면">
 </fieldset>
 </form>
 <script type="text/javascript">
	function click(i){
		if(i==1){
			document.mainform.action='search.do';
		}else if(i==2){
			document.mainform.action='update.do';
		}else if(i==3){
			document.mainform.action='delete.do';
		}
		document.mainform.submit();
	}
</script>
</body>
</html>