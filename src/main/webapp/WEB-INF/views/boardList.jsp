<%@page import="kr.boksun.mapper.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	//java controller에서보면 addAttribute가 Object타입이므로 형변환을 해줘야함. 어떤 타입이든 가능하다는 장점.
	%>
	<div class="container">
		<h2>Spring MVC BOARD</h2>
		<div class="panel panel-default">
			<div class="panel-heading">
				Board List <span style="float: right"> <c:choose>
						<c:when test="${not empty info}">
    	  				${info.nick}님 환영합니다!
    	  				<a href="logout.do"><button class="btn btn-info btn-sm">로그아웃</button></a>
							<a href="update.do"><button class="btn btn-info btn-sm">회원정보
									수정</button></a>
							<c:if test="${info.id eq 'admin'}">
								<button style="width:100px;" id="memberList" class="btn btn-info btn-sm">회원정보
									보기</button>
							</c:if>
						</c:when>
						<c:otherwise>
							<a href="login.do"><button class="btn btn-info btn-sm">로그인</button></a>
						</c:otherwise>
					</c:choose>
				</span>
				<div style="display : none; width:100%;" id="memberView">
					
				</div>
			</div>
			<div class="panel-body">
				<table class="table table-hover table-bordered">
					<thead>
						<tr class="active">
							<td>번호</td>
							<td>제목</td>
							<td>내용</td>
							<td>조회수</td>
							<td>작성자</td>
							<td>작성일</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${list}" varStatus="i">
							<tr>
								<td>${i.count}</td>
								<td><a href="boardContents.do?idx=${vo.idx}">${vo.title}</a></td>
								<td>${vo.contents}</td>
								<td>${vo.count}</td>
								<td>${vo.writer}</td>
								<td>${vo.indate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 스프링에선 a href = ".jsp"로 페이지끼리 직접 이동이 안됀다. 
    				무조건 POJO(FrontController)를 들려야하기 떄문에 .do로 바꿔준다 -->
				<a href="boardinsertForm.do"><button class="btn btn-info btn-sm">글쓰기</button></a>
			</div>
		</div>
		<div class="panel-body">지능형 IoT 신지수</div>
	</div>

	<!-- 자바스크립트에서 중괄호는 객체를 의미함 -->
	<script type="text/javascript">
		$("#memberList").click(function() {
			$.ajax({
				url : "memberList.do", //jsp에서 컨트롤러로 가능. /넣으면 안됌. /넣으려먼 (web/) 넣어줘야함
				type : "post",
				dataType : "json",
				success : resultJson,
				error : function(e) {
					console.log(e);
				}
			});
		});
		function resultJson(data) {
			console.log(data);
			
			var btn_text = $('#memberList').text();
			console.log(btn_text);
			
			if(btn_text == '회원정보보기'){
				$('#memberList').text('닫기');
			}else{
				$('#memberList').text('회원정보보기');
			}
			
			var html = "<table class='table table-hover table-bordered'>";
			html += "<tr>"
			html += "<td>번호</td><td>아이디</td><td>비밀번호</td>";
			html += "<td>닉네임</td><td>전화번호</td>";
			html += "</tr>";
			//each : jquery 반복문
			//현재 data는 리스트형태이기때문에 obj에서 하나씩 객체로 받는다는 뜻
			$.each(data, (index, obj) =>{
				html += "<tr>";
	            html += "<td>"+index+"</td>";
	            html += "<td>"+obj.id+"</td>";
	            html += "<td>"+obj.pw+"</td>";
	            html += "<td>"+obj.nick+"</td>";
	            html += "<td>"+obj.phone+"</td>";
	            html += "</tr>";
			});  
			html += "</table>";
			
			$("#memberView").html(html);
			
			if($("#memberView").css('display') == 'none'){
				$("#memberView").slideDown(2000);
			}else{
				$("#memberView").slideUp(2000);
			}
		}
	</script>
</body>
</html>