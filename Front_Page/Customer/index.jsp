<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="text/html UTF-8">
	<meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="cache-control" content="no-cache, must-revalidate"> 
	<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57GMT">
	<title>parknshop</title>
	<link rel="stylesheet" type="text/css" href="./css/customer.css">
	<link rel="stylesheet" type="text/css" href="./css/swiper.min.css">
</head>
<body>
	<%@ include file="header.html"%>
	<%@ include file="dialog.html"%>
	<div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide">
            	<div class="swiper-banner" style="background-image: url(./images/1380961451846.jpg);"></div>
            </div>
            <div class="swiper-slide">
				<div class="swiper-banner" style="background-image: url(./images/6630096896932174829.jpg);"></div>
            </div>
        </div>
        <div class="swiper-pagination"></div>
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
    </div>
	<%@ include file="footer.html"%>
	<script type="text/javascript" src="./js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="./js/swiper.min.js"></script>
	<script type="text/javascript" src="./js/customer.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	    customer.init();
	    customer.initIndex();
	});
	</script>
</body>
</html>