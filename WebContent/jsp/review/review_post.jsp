<%@page import="com.conv.review.domain.Reply"%>
<%@page import="java.util.Date"%>
<%@page import="com.conv.review.domain.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Review post = (Review)request.getAttribute("post");
	List<Reply> reply = (List<Reply>)request.getAttribute("reply");
%>
<!DOCTYPE html>
<html>
<head>
<title>삑</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jsp/main/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jsp/main/main2.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=Libre+Barcode+39+Text" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
	
</head>
<body>

	<%--페이스북 로그인 api --%>

	<script>
		window.fbAsyncInit = function() {
			FB.init({
				appId : '1943226235933346',
				xfbml : true,
				version : 'v2.10'
			});
			FB.AppEvents.logPageView();
		};

		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.10&appId=409465049448770";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<!-- Side Navigation -->
	<nav
		class="w3-sidebar w3-bar-block w3-card-2 w3-animate-left w3-center"
		style="display: none" id="mySidebar">
		<h1 class="w3-xxxlarge w3-text-theme">메뉴</h1>
		<button class="w3-bar-item w3-button" onclick="w3_close()">
			숨기기 <i class="fa fa-remove"></i>
		</button>
		<a href="/conv/com/conv/recipe/controller/recipelistcontroller"
			class="w3-bar-item w3-button">혼밥 게시판!</a> <a
			href="/conv/com/conv/world/controller/worldlistcontroller"
			class="w3-bar-item w3-button">세계의 편의점</a>
		<form action="/conv/review/list">
			<a href="/conv/review/list" class="w3-bar-item w3-button">리뷰 게시판</a>
		</form>
		<a href="/conv/free/list" class="w3-bar-item w3-button">나눔 게시판</a> 
		<a href="/conv/pb/list" class="w3-bar-item w3-button">PB 상품</a>
			 <a
			href="/conv/sale/list" class="w3-bar-item w3-button">이달의 행사</a>
	</nav>

	<!-- Header -->
	<header class="w3-container w3-theme w3-padding" id="myHeader">
		<i onclick="w3_open()" class="fa fa-bars w3-xlarge w3-button w3-theme"></i>
		<span style="float: right"> <c:choose>
				<c:when test="${empty user}">
				 ${welcome} <a class="w3-button w3-theme"
						href="/conv/jsp/member/login.jsp">로그인</a>

					<c:if test="${empty welcome}">
						<a class="w3-button w3-theme" href="/conv/jsp/member/signin.jsp">회원가입</a>
					</c:if>
					<br>
					<%--페이스북 로그인 버튼 --%>
					<div class="fb-login-button" data-max-rows="1" data-size="large"
						data-button-type="continue_with" data-show-faces="false"
						data-auto-logout-link="false" data-use-continue-as="false"></div>

				</c:when>
				<c:otherwise>
					<a class="w3-button w3-theme" href="/conv/member/logout"> 로그아웃</a>
				
				 ${user}님 환영합니다! 
				<%--
				접속시간 : ${user.accessTime}
				 --%>
				</c:otherwise>
			</c:choose>
		</span>







		<div class="w3-center"><h6>&nbsp;</h6>
			<h4 style="text-align: center">펴니점 꿀정보 사이트</h4>
			<h1 class="w3-xxxlarge w3-animate-bottom">
				<a href="/conv/jsp/main/main.jsp" style="font-family: 'Libre Barcode 39 Text', cursive; font-size:250%; text-decoration: none; ">   BBIK   </a>
			</h1>
			<div class="w3-padding-32">
				<button class="w3-btn w3-xlarge w3-dark-grey w3-hover-light-grey"
					onclick="document.getElementById('id01').style.display='block'"
					style="font-weight: 900;">밥 뭐먹지</button>
			</div>
		</div>
		<span style="float: right">
			<form action="/conv/main/search">
				<input type="text" name="keyword">
				<button class="w3-button w3-theme" type="submit">검색</button>
			</form>
		</span>

	</header>


	<!-- Modal -->
	<div id="id01" class="w3-modal">
		<div class="w3-modal-content w3-card-4 w3-animate-top">
			<header class="w3-container w3-theme-l1">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="w3-button w3-display-topright">X</span>
				<h4>밥 메뉴가 고민된다면??</h4>
				<h5>
					여러 사람들의 편의점 레시피가 모인 곳!<i class="fa fa-smile-o"></i>
				</h5>
			</header>
			<div class="w3-padding">
				<p>혼밥 레시피! 게시판에서</p>
				<p>다양한 음식 조합을 만나보세요!</p>
			</div>
			<footer class="w3-container w3-theme-l1">
				<p>
					<a class="w3-btn" href="/conv/com/conv/recipe/controller/recipelistcontroller">혼밥 레시피! 바로 가기</a>
				</p>
			</footer>
		</div>
	</div>



	<div id="id02" class="w3-modal">
		<div class="w3-modal-content w3-card-4 w3-animate-top">
			<header class="w3-container w3-theme-l1">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="w3-button w3-display-topright">X</span>
				<h4>글에 댓글이 있으면 삭제를 못합니다..</h4>
				<h5>
					안타깝네요....<i class="fa fa-smile-o"></i>
				</h5>
			</header>
			<div class="w3-padding">
				<p>어쩔 수가 없어요...</p>
			</div>
			<footer class="w3-container w3-theme-l1">
				<p>
				<span onclick="document.getElementById('id02').style.display='none'">
					<a class="w3-btn">네...</a></span>
				</p>
			</footer>
		</div>
	</div>



<div class="w3-container">
  <hr>
  <div class="w3-center">
    <h2>리뷰 게시판</h2>
    <p w3-class="w3-large">각종 리뷰들이 한곳에!</p>
  </div>
<p>
<%-- <div class="w3-half"> --%>
<div class="w3-card white">


  <div class="w3-container w3-theme">
    <h3>${post.title}</h3>
  </div>
  <div class="w3-container">
  <h3 class="w3-text-theme"><%= post.getWriter() %></h3>
  </div>
  <ul class="w3-ul w3-border-top">
    <li>
      <p><%= post.getRegDate() %></p>
    </li>
    <li>
      <p><%= post.getHit() %></p>
    </li>
    <li>
		<c:forEach var ="i" items="${image}" >
    		<img src="${pageContext.request.contextPath}/review_upload${i.path}/${i.sName}"/>
		</c:forEach>
      <p><%= post.getContent() %></p>
  </ul>
  
  
</div>
	<p>
	
	<div class="w3-responsive w3-card-2">
	<table class="w3-table w3-striped w3-bordered">
	<tbody>
	
	
	<form action = "/conv/review/updateno">
<button class="w3-btn w3-xlarge w3-blue w3-hover-white" style="font-weight:900;" name="no" value="<%= post.getNo() %>">수정</button>
</form>
<form action = "/conv/review/delete"> 
<% if(reply.size() == 0) {
	String msg = "possible"; %>
<input type="hidden" value="<%=msg%>" required/>
<button class="w3-btn w3-xlarge w3-blue w3-hover-white" style="font-weight:900;" name="no" value="<%= post.getNo() %>"
	onclick="document.getElementById('id02').style.display='block'">삭제</button>
<%
}
%>
</form>
<a href = "/conv/review/list"><button class="w3-btn w3-xlarge w3-blue w3-hover-white" style="font-weight:900;">목록으로</button></a>
	
	
	</tbody>
	</table>
	</div>
	<p>
	
		<div class="w3-responsive w3-card-2">
	
	<div class="w3-container w3-theme">
    <h3>댓글(${reply.size()})</h3>
  </div>
	
	</div>
	
<%-- 	<div class="w3-container"> --%>
	<div class="w3-responsive w3-card-2">
	<table class="w3-table w3-striped w3-bordered">
	<tbody>
	
	
	<%-- 
		for(Board b : list) {
		b.getNo();
		b.getTitle() ;
		}
	 --%>
	 
	 <c:choose>
		<c:when test="${!empty reply}">
		 	<c:forEach var ="r" items="${reply}" > 	
		 	<tr>
		 	<td><c:out value ="${r.writer}" /></td>
		 	<td><c:out value ="${r.content}" /></td>
		 	<td><c:out value ="${r.regDate}" /></td>
			<td>	
				<form action="/conv/review/deletereply">
				
					<a href="/conv/review/post" class="w3-bar-item w3-button w3-hover-theme" >
					<input type="hidden" name="no" value="${post.no}"/>
					<button name="deleteno" value="${r.no}" class="w3-bar-item w3-button w3-hover-theme" >삭제
					</button></a>
				</form>
		 	</td>
		 	</tr>
		 	</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td> 
				이 글의 첫번째 댓글을 달아주세요!
  					
				</td>
			</tr>		
		</c:otherwise>
	</c:choose>
	</tbody>
	</table>
	</div>
	
	
	
	<%-- 댓글작성창 --%>
	<div class="w3-responsive w3-card-2">
	
	
	<%-- 
		for(Board b : list) {
		b.getNo();
		b.getTitle() ;
		}
	 --%>
	 
	 <form action="/conv/review/reply">
	 
	
		&nbsp;&nbsp;&nbsp; 댓글 쓰기! <input type="text" size="50%" name="content" placeholder="등록한 댓글은 수정할 수 없습니다. 신중하게 써 주세요. " />
		
	<a href="/conv/review/post" class="w3-bar-item w3-button w3-hover-theme" >		
		<button name="no" value="${post.no}" class="w3-bar-item w3-button w3-hover-theme">등록</button></a>
	</form>	
	 
	 
	 
	 
	 
	</div>
	
<%--	</div> --%>
	
	
<%--  </div> --%>

</div>

	<!-- Footer -->
	<footer class="w3-container w3-theme-dark w3-padding-16">
		<h3>BBIK</h3>
		<p>
			Made by <a href="/conv/jsp/common/us.jsp"
				class="w3-btn w3-theme-light" target="_blank">삑을 만든 사람들</a>
		</p>
		<div style="position: relative; bottom: 55px;"
			class="w3-tooltip w3-right">
			<span class="w3-text w3-theme-light w3-padding">위로 가기</span>  <a
				class="w3-text-white" href="#myHeader"><span class="w3-xlarge">
					<i class="fa fa-chevron-circle-up"></i>
			</span></a>
		</div>
		<p>문의 : sangjoons@bbik.com</p>
	</footer>

<!-- Script for Sidebar, Tabs, Accordions, Progress bars and slideshows -->
<script>
// Side navigation
function w3_open() {
    var x = document.getElementById("mySidebar");
    x.style.width = "100%";
    x.style.fontSize = "40px";
    x.style.paddingTop = "10%";
    x.style.display = "block";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
}

// Tabs
function openCity(evt, cityName) {
  var i;
  var x = document.getElementsByClassName("city");
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  var activebtn = document.getElementsByClassName("testbtn");
  for (i = 0; i < x.length; i++) {
      activebtn[i].className = activebtn[i].className.replace(" w3-dark-grey", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " w3-dark-grey";
}

var mybtn = document.getElementsByClassName("testbtn")[0];
mybtn.click();

// Accordions
function myAccFunc(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

// Slideshows
var slideIndex = 1;

function plusDivs(n) {
slideIndex = slideIndex + n;
showDivs(slideIndex);
}

function showDivs(n) {
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length} ;
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}

showDivs(1);

// Progress Bars
function move() {
  var elem = document.getElementById("myBar");   
  var width = 5;
  var id = setInterval(frame, 10);
  function frame() {
    if (width == 100) {
      clearInterval(id);
    } else {
      width++; 
      elem.style.width = width + '%'; 
      elem.innerHTML = width * 1  + '%';
    }
  }
}
</script>

</body>
</html>
