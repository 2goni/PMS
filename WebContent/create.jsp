<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style="text-align: center"> 생산관리 등록화면 </h3>
<form action="PMS" method="post">
 <fieldset style="width: 610px; margin:0 auto;">
  <legend><b>생산관리 등록화면</b></legend>
  <ul>
  <li>제품코드 <input type="text" name="code" autofocus required></li>
  <li>제품이름 <input type="text" name="pname" required></li>
  <li>제품원가 <input type="number" name="cost" required></li>
  <li>목표수량 <input type="number" name="pnum" required></li>
  <li>재고수량 <input type="number" name="inum" required></li>
  <li>출고가격 <input type="number" name="sale" required></li>
  <li>그룹이름 
  <select name="group">
  <option value="컴퓨터">컴퓨터</option>
  <option value="모바일">모바일</option>
  <option value="냉장고">냉장고</option>
  <option value="전자렌지">전자렌지</option>
  <option value="게임기">게임기</option>
  </select>  
  </li>
  </ul>
  <input style="background:gold; width: 100px; height: 30px;" type="submit" name="create" value="등록">
  <input style="background:gold; width: 100px; height: 30px;" type="button" onclick="location.href='main.jsp'" value="메인화면">
 </fieldset>
 </form>
</body>
</html>