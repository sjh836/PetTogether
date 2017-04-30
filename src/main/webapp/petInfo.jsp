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
			<div class="col-md-12">
				<h1>유기동물 정보</h1>
				
<h3>1) 유기동물이란?</h3>

<p>유기동물은 주인의 실수, 혹은 의도적인 목적으로 인하여 버려진 이국적인 동물, 혹은 반려동물을 뜻합니다. 유기동물들은 주로 주인의 죽음이나, 혹은 동물들이 너무 커지거나 질병에 걸린 경우 발생합니다. 해외의 경우, 많은 유기동물들이 주인의 집이 압류당하여, 버려진 집에 구조되지 못한 채로 버려져 있기도 한다고 합니다. 유기동물들은 많은 원인에 의하여 유기되는데 유기됐을 때에는 스스로를 방어하고 지키기 위해 야생성을 보이게 되고 그 상태로 떠돌게 됩니다. 고양이와 개들은 다른 동물들과는 달리 그들만의 식민지를 형성하는 경우도 있으며, 떠돌이 개에 비하여 떠돌이 고양이의 수가 개체 수가 월등히 많다고 알려져 있습니다.
</p>
<h3>2) 유기동물 발견 시 대처요령</h3>
<p>
1. 만약 유기동물을 주웠을 때 현행 동물보호법에서는 지자체에 신고하게 되어 있으며 지역별 동물보호과 연락처는 홈페이지(주소: http://foranimal.or.kr/xe/careanimal_4)에 마련되어 있습니다. 지자체에서는 지자체 보호소에 보호하면서 7일간 홍보를 하게 되고 10일이 지나면 소유주가 지자체로 넘어가게 되어 있습니다.
<br><br>
2. 지자체 보호소에 10일이 넘은 유기동물은 보호소의 유기동물 수나 수용능력에 따라 안락사를 하게 됩니다. 또 워낙 많은 유기동물이 생기다 보니 현실적으로 다른 대안을 못 찾고 있습니다. 최근 정부에서도 유기동물의 안락사를 줄이기 위해 분양센터도 만들고 홍보도 하며 여러 단체에서도 유기동물 안락사를 줄이기 위한 노력을 기울이고 있습니다.
<br><br>
3. 유기동물들 중에 소유주가 있는 경우가 많으며 다른 사람이 소유주가 있는 동물을 임의대로 데려가는 것도 법적으로 위배됩니다. 따라서 이런 위법을 피하면서 유기동물에게 도움을 주려면 지자체에 신고를 하신 후 10일간의 홍보와 보호가 이루어 져서 지자체에 소유가 넘어 간 상태에서 이때 지자체를 통해 1순위로 입양을 예약해 놓으셔서 입양하시면 법적으로 소유권을 갖게 됩니다. 이렇게 새로운 주인이 되어 주시거나 여건이 안되면 사랑으로 키울 새로운 주인을 만나게 해주세요.
<br><br>
4. 보호, 홍보, 입양에 대한 좀더 구체적인 것은 지자체와 상의하시는 것이 좋습니다.
<br><br>
5. 새로운 주인을 찾을 때에는 동물을 사랑하는 사람들이 많이 가입된 카페나 유기동물 분양 사이트를 이용하시는 것이 좋습니다. 이때 새로운 주인을 직접 만나 잘 키울 수 있는 사람인지 평가해 보시고 가끔 잘 지내는지 확인도 해보시길 부탁합니다.
<br><br>
6. 유기동물 구조시 특히 미용이 되어 있거나 털이 깨끗한 경우는 버려지는 것 보다 주인을 잊어버린 경우가 대부분이고 잊어버린 지 얼마 안 된 경우가 많습니다. 따라서 주위에 유기동물를 찾아서 다니는 분이 있는지 관심을 기울여 주세요.
<br><br>
7. 주위에 동물을 찾는 분이 없으면 신고 후 전단지를 만들어 발견 장소 근처에 붙여 주시고 근처의 동물병원에도 전달해 주세요. 잃어버린 지 얼마 안 되는 경우는 이런 전단지로 주인을 찾게 되는 경우가 많습니다.
<br><br>
8. 간혹 주인이 있고 평소에도 동물이 혼자 나가 항상 일정한 곳을 산책을 하고 집에 들어오는 경우도 있습니다. 이런 산책 중에 주위에 주인이 없다고 구조하게 되면 이 동물은 가장 사랑하는 주인을 영영 잃어버리는 경우도 있으니 잘 관찰해 보아야 합니다. 위험한 곳으로 전혀 안가고 혼자 다니다 집으로 찾아 가는지 확인해 보면 더욱 좋습니다.
<br><br>
9. 두려움이나 공포에 떨고 있는 경우 또는 사고가 생겨서 무척 통증이 있는 경우는 통증이나 두려움으로 구조 하려는 분을 무는 경우도 있으니 주의하셔야 합니다.
<br><br>
10. 사람에 대해 경계심이 무척 심하여 근처에 갈수 없고 몰골이 초췌한 경우 심하게 
다쳤거나 예민해서 그냥 상태를 유지하게 되면 위험할 경우에 119 또는 지역별 
동물보호과 등의 도움을 받아 구조를 하시는 것이 좋습니다. 
		</p>		
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