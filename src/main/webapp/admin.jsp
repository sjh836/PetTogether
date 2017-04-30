<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="syu.DBproject.biz.member.MemberDAO" %>
<%@ page import="syu.DBproject.biz.member.MemberVO" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	// 세션에 저장된 글 목록을 꺼낸다.
	List<MemberVO> memberList=(List)request.getAttribute("memberList");
%>

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
					<li class="active">Admin</li>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<section id="content">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>관리자 페이지-유저</h1>
				
				<table class="table table-bordered table-hover">
					<tr>
						<th class="col-xs-1">번호</th>
						<th class="col-xs-2">아이디</th>
						<th class="col-xs-2">이름</th>
						<th class="col-xs-3">연락처</th>
						<th class="col-xs-1">나이</th>
						<th class="col-xs-1">활동력</th>
						<th class="col-xs-2">가입날짜</th>
					</tr>
					<% for(MemberVO member:memberList)
						{	%>
					<tr>
						<td><%= member.getMno() %></td>
						<td align="left"><a href="getMember.do?mno=<%= member.getMno() %>"><%= member.getId() %></a></td>
						<td><%= member.getName() %></td>
						<td><%= member.getTel() %></td>
						<td><%= member.getAge() %></td>
						<td><%= member.getGrade() %></td>
						<td><%= member.getRegDate() %></td>
					</tr>
					<% } %>
				</table>
				<center><a href="toMemberExcel.do" class="btn btn-default">Excel 출력</a>&nbsp;&nbsp;&nbsp;
				<a href="toMemberPdf.do" class="btn btn-default">PDF 출력</a>&nbsp;&nbsp;&nbsp;
				<a href="memberTransJson.do" class="btn btn-default">Json 출력</a>&nbsp;&nbsp;&nbsp;
				<a href="admin2.do" class="btn btn-default">삼냥이 관리하기</a></center>
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