<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>동행길</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- css -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/bootstrap/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="resources/bootstrap/css/jcarousel.css" rel="stylesheet" />
<link href="resources/bootstrap/css/flexslider.css" rel="stylesheet" />
<link href="resources/bootstrap/css/style.css" rel="stylesheet" />

<!-- skin -->
<link href="resources/bootstrap/skins/default.css" rel="stylesheet" />

</head>
<body>
<div id="wrapper">
	<!-- start header -->
	<header>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><span>SYU</span> 동행길</a>
                </div>
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                        <li><a href="intro.jsp">동행길 소개</a></li>
                        <li class="dropdown ">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">집사활동 <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="petInfo.jsp">유기동물 정보</a></li>
                                <li><a href="support.jsp">후원안내</a></li>
								<li><a href="getPetList.do">갤러리</a></li>
                            </ul>
                        </li>
                        <li><a href="getBoardList.do">커뮤니티</a></li>
                        <% if(session.getAttribute("userName")==null) { %><li class="active"><a href="login.jsp">Login</a></li><% } %>
                        <% if(session.getAttribute("userName")!=null) { %><li><a href="admin.do"><%= session.getAttribute("userName")%>님</a></li>
                        <li class="active"><a href="logout.do">Logout</a></li><% } %>
                    </ul>
                </div>
            </div>
        </div>
	</header>
	<!-- end header -->
	<section id="inner-headline">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<ul class="breadcrumb">
					<li><a href="#"><i class="fa fa-home"></i></a><i class="icon-angle-right"></i></li>
					<li class="active">Intro</li>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<section id="content">
	<div class="container">
		<div class="row">
			<h1>동행길을 소개합니다</h1>
			<div class="col-md-3">
				<img src="resources/bootstrap/img/intro/1.jpg" alt="1">
			</div>
			<div class="col-md-9">
				<p>동행길은 2016년 9월에 만들어진 삼육대학교 신규동아리로 생명존중정신을 바탕으로 길 고양이, 유기동물, 반려동물과 같은 우리 주변의 동물들과 함께 공존 할 수 있는 방안을 찾고 실천하는 동아리입니다. </p>
				<p>※ 가입문의<br>동아리 회장: 박은수(삼육대학교 동물자원학과) <br>연락처: 010-2811-1805</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h3>모니터링</h3>
				<p>삼육대 내를 모니터링하거나 제보를 받아서 길 고양이 및 유기동물들에게 먹이와 물을 제공하고 모니터링 중 사고로 다치거나 죽은 동물이 있다면 병원에 데려가거나 사후 조치를 하고 있습니다.</p>
			</div>
			<div class="col-md-4">
				<img src="resources/bootstrap/img/intro/4.jpg" alt="1">
			</div>
			<div class="col-md-4">
				<img src="resources/bootstrap/img/intro/5.jpg" alt="1">
			</div>
			<div class="col-md-4">
				<img src="resources/bootstrap/img/intro/6.jpg" alt="1">
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h3>집짓기, 급식소 설치</h3>
				<p>- 추운 겨울에 길 고양이들의 보금자리를 마련하여 길 고양이들이 얼어 죽지 않도록 해주고 있습니다.</p>
			</div>
			<div class="col-md-4">
				<img src="resources/bootstrap/img/intro/10.jpg" alt="1">
			</div>
			<div class="col-md-4">
				<img src="resources/bootstrap/img/intro/11.jpg" alt="1">
			</div>
			<div class="col-md-4">
				<img src="resources/bootstrap/img/intro/12.jpg" alt="1">
			</div>
		</div>
	</div>
	</section>
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 text-center">
				삼육대학교 16-2학기 데이터베이스 프로그래밍 3B 1조
			</div>
		</div>
	</div>
	<div id="sub-footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
				</div>
				<div class="col-lg-6">
					<ul class="social-network">
						<li><a href="https://www.facebook.com/donghanggil/" data-placement="top" title="Facebook"><i class="fa fa-facebook"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</footer>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<!-- javascript -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/bootstrap/js/jquery.js"></script>
<script src="resources/bootstrap/js/jquery.easing.1.3.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/bootstrap/js/jquery.fancybox.pack.js"></script>
<script src="resources/bootstrap/js/jquery.fancybox-media.js"></script>
<script src="resources/bootstrap/js/google-code-prettify/prettify.js"></script>
<script src="resources/bootstrap/js/portfolio/jquery.quicksand.js"></script>
<script src="resources/bootstrap/js/portfolio/setting.js"></script>
<script src="resources/bootstrap/js/jquery.flexslider.js"></script>
<script src="resources/bootstrap/js/animate.js"></script>
<script src="resources/bootstrap/js/custom.js"></script>

</body>
</html>