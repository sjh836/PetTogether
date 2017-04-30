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


<!-- Theme skin -->
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
					<li class="active">Board</li>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<section id="content">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>자유 게시판</h1>
				
				<form action="insertBoard.do" method="post" enctype="multipart/form-data">
					<table class="table table-bordered">
						<tr>
							<td>제목</td>
							<td align="left"><input class="form-control" type="text" name="title" /></td>
						</tr>
						<tr>
							<td>작성자</td><input name="id" type="hidden" value="<%= session.getAttribute("userId")%>" />
							<td align="left"><input name="writer" type="hidden" value="<%= session.getAttribute("userName")%>" /><%= session.getAttribute("userName")%></td>
						</tr>
						<tr>
							<td>내용</td>
							<td align="left"><textarea class="form-control" name="content" cols="40" rows="10"></textarea></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input class="btn btn-default" type="submit" value="새글 등록" /></td>
						</tr>
					</table>
				</form>
				<hr>
				<a href="getBoardList.do" class="btn btn-default">글 목록가기</a>
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
<!-- javascript
    ================================================== -->
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