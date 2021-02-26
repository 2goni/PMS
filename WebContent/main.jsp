<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style="text-align: center"> 생산관리 시스템 </h3>
 <fieldset style="width: 610px; margin:0 auto;">
  <legend><b>기능</b></legend>
  <input style="background:gold; width: 300px; height: 100px;" type="button" onclick="location.href='create.jsp'" value="제품입력">
  <input style="background:gold; width: 300px; height: 100px;" type="button" onclick="location.href='update.jsp'" value="제품조회 및 수정">
  <br>
  <input style="background:gold; width: 300px; height: 100px;" type="button" onclick="location.href='priority.jsp'" value="우선생산제품">
  <input style="background:gold; width: 300px; height: 100px;" type="button" onclick="location.href='profit.jsp'" value="이익순위">
  <br>
  <input style="background:gold; width: 300px; height: 100px;" type="button" onclick="location.href='stock.jsp'" value="그룹별 재고수량">
 </fieldset>
</body>
</html>