<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>설문조사지</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>설문조사</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="researchAppendwrite.do"
				method="post">
				<input type="hidden" name='test[]' id='test_list' value=''>
				<div>
					<table border="1">
						<tr>
							<td colspan="2" width="700" height="200" align="center">
								<h1>${researchTitle.title }</h1>
								<h1>${researchTitle.id }</h1>
								<h4>종료일자 :${researchTitle.edate }</h4> ${fn:length(qlists) }건<br />
							</td>
						</tr>
						<c:forEach var="q" items="${qlists }">
							<tr>
								<th width="50" height="100">문항${q.qOrder }</th>
								<td>${q.qTitle }</td>
							</tr>
							<c:set var="qstr" value="${fn:split(q.qSubTitle, ',') }"></c:set>
							<tr>
								<td colspan="2" width="700"><c:choose>
										<c:when test="${q.qType eq 'S' }">
											<c:forEach var="str" items="${qstr }">
												<input type="checkbox" name="qResult[${q.qOrder }]"
													value="${str }">${str }
											</c:forEach>
										</c:when>
										<c:when test="${q.qType eq 'R' }">
											<c:forEach var="str" items="${qstr }">
												<input type="radio" name="qResult[${q.qOrder }]"
													value="${str }">${str }
											</c:forEach>
										</c:when>
										<c:when test="${q.qType eq 'C' }">
										 ${q.qSubTitle} : <input type="text"
												name="qResult[${q.qOrder }]">${str }
										</c:when>
										<c:when test="${q.qType eq 'SC' }">
											<c:forEach var="str" items="${qstr }">
												<input type="checkbox" name="qResult[${q.qOrder }]"
													value="${str }">${str }
												<c:if test="${str eq '기타' }">
													<input type="text" name="qResultText[${q.qOrder }]">
												</c:if>
											</c:forEach>
										</c:when>
									</c:choose></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<input type="submit" onclick="insertdddddd()" value="결과제출">
				<button type="reset">취소</button>
			</form>
		</div>
	</div>


	<script>
		function insertt(){
			console.log(qResult[1].val());
		}
		 function insertdddddd(responseid){
		 var list = $("input[name='qResult[${q.qOrder }]']").length;
		 var arry = new Array(list);
		 for(var i=0; i<list; i++){
		 list[i] = $("input[name='qResult[${q.qOrder }]']").eq(i).val();
		 console.log(list[i] + list);
		 console.log(array +"배열");
		 }
		 }
		 
		 
		function insertdddd(responseid) {
			var value = $("input[name='qResult[${q.qOrder }]']:checked").val();
			console.log(value);

			var value2 = $("input[name='qResult[${q.qOrder }]']:checked").val();
			alert(value2);

		}

		function insert(responseid) {
			var list = new Array();
			$("input[name='qResult[${q.qOrder }]']").each(
					function(index, item) {
						list.push($(item).val());
					});
			$("#test_list").val(list);
			alert(list);
			console.log($("#test_list").val(list));
		}
	</script>
</body>

</html>