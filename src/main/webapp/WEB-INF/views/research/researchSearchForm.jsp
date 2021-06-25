<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div>여기는 검색페이지 </div>
	<div>
		<form id="frm" name="frm" action="../researchSelect.do" method="post">
			<table border="1">
				<tr>
					<th width="150">검색번호</th>
					<td width="200"><input type="text" id="id" name="id"></td> 		<!-- id= ajax / name=  java ,vo값과 동일하게 -->
					<td width="100" align="center"><input type="submit" value="검색"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>