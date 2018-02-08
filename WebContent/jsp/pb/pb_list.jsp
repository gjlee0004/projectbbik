<%@page import="com.conv.pb.domain.PB"%>
<%@page import="com.conv.sale.domain.Sale"%>
<%@page import="java.util.Date"%>
<%@page import="com.conv.review.domain.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	List<Review> all = (List<Review>)request.getAttribute("all");
--%>
<% 
	List<PB> list = (List<PB>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<title>삑</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%-- 이 자리 --%>
<%	int cnt = 13; %>
<script>
$(document).ready(function(){
    $("#more").on("click", function(){
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#more2").show();
        $("#more").hide();
    });
    $("#more2").on("click", function(){
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#more3").show();
        $("#more2").hide();
    });
    $("#more3").on("click", function(){
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#more4").show();
        $("#more3").hide();
    });
    $("#more4").on("click", function(){
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#more5").show();
        $("#more4").hide();
    });
    $("#more5").on("click", function(){
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#<%=cnt++ %>").show();
        $("#more6").show();
        $("#more5").hide();
    });
});
$("#more").off("click");
</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Libre+Barcode+39+Text" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
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


<div class="w3-container">
  <hr>
  <div class="w3-center">
    <h2>PB 상품</h2>
    <p w3-class="w3-large">여러 편의점의 PB상품이 한곳에!</p>
  </div>
<p>
<div class="w3-responsive w3-card-4" id="conts">
<table class="w3-table w3-striped w3-bordered">
<tbody>
<%-- 
<c:forEach var ="r" items="${list}"> 	
	<div class="w3-card white w3-quarter">
	
		
	  <div class="w3-container w3-theme">
	    <h3>${r.productName}</h3>
	  </div>
	  <div class="w3-container">
	  <h3 class="w3-text-theme">${r.event}</h3>
	  </div>
	  <ul class="w3-ul w3-border-top">
	    <li>
	      <p>${r.convName}</p>
	    </li>
	    <li>
	      <p><img src="${r.imageURL}" width="300px" height="300px"/></p>
	    </li>
	    <li>
	      <p>${r.price}</p>
	  </ul>
	</div>
</c:forEach>
--%>
<%	for(int i = 0; i <= 11; i++){ %>
	<div id="<%=i + 1%>" class="w3-card white w3-quarter">
		  <div class="w3-container w3-theme">
		    <h3><%= list.get(i).getProductName() %></h3>
		  </div>
		  <ul class="w3-ul w3-border-top">
		    <li>
		      <p><%= list.get(i).getConvName() %></p>
		    </li>
		    <li>
		      <p><img src="<%=list.get(i).getImageURL()%>" width="300px" height="300px"/></p>
		    </li>
		    <li>
		      <p><%= list.get(i).getPrice() %></p>
		  </ul>
	</div>
<% } %>
<%	for(int i = 12; i < list.size(); i++){ %>
	<div hidden id="<%=i + 1%>" class="w3-card white w3-quarter">
		  <div class="w3-container w3-theme">
		    <h3><%= list.get(i).getProductName() %></h3>
		  </div>
		  <ul class="w3-ul w3-border-top">
		    <li>
		      <p><%= list.get(i).getConvName() %></p>
		    </li>
		    <li>
		      <p><img src="<%=list.get(i).getImageURL()%>" width="300px" height="300px"/></p>
		    </li>
		    <li>
		      <p><%= list.get(i).getPrice() %></p>
		  </ul>
	</div>
<% } %>
</tbody>
</table>
</div>
<br>
<div class="w3-center">
  <button id="more" class="fa fa-plus w3-button w3-circle w3-large w3-theme"></button>  
</div>
<div hidden id="more2" class="w3-center">
  <button hidden="true" class="fa fa-plus w3-button w3-circle w3-large w3-theme"></button>  
</div>
<div hidden id="more3" class="w3-center">
  <button hidden="true" class="fa fa-plus w3-button w3-circle w3-large w3-theme"></button>  
</div>
<div hidden id="more4" class="w3-center">
  <button hidden="true" class="fa fa-plus w3-button w3-circle w3-large w3-theme"></button>  
</div>
<div hidden id="more5" class="w3-center">
  <button hidden="true" class="fa fa-plus w3-button w3-circle w3-large w3-theme"></button>  
</div>


</div>
<br>

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
