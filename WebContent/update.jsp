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
<from action="create" method="post">
 <fieldset style="width: 610px; margin:0 auto;">
  <legend><b>생산관리 등록화면</b></legend>
  <ul>
  <li>제품코드 <input type="text" name="code"></li>
  <li>제품이름 <input type="text" name="name"></li>
  <li>제품원가 <input type="text" name="cost"></li>
  <li>목표수량 <input type="text" name="tquantity"></li>
  <li>재고수량 <input type="text" name="squantity"></li>
  <li>출고가격 <input type="text" name="price"></li>
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
  <input style="background:gold; width: 100px; height: 30px;" type="submit" value="조회">
  <input style="background:gold; width: 100px; height: 30px;" type="submit" value="수정">
  <input style="background:gold; width: 100px; height: 30px;" type="submit" value="삭제">
  <input style="background:gold; width: 100px; height: 30px;" type="button" onclick="location.href='main.jsp'" value="메인화면">
 </fieldset>
</body>
</html>