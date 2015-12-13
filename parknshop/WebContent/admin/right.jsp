
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<%@ page language="java" contentType="text/html; charset="
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}

a:link {
	text-decoration: underline;
}
-->
</style>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		height="100%">
		<tr>
			<td width="17" valign="top" background="images/mail_leftbg.gif"><img
				src="images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="images/content-bg.gif">

				<table width="100%" height="31" border="0" cellpadding="0"
					cellspacing="0" class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">Welcome</div></td>
					</tr>
				</table>
			</td>
			<td width="16" valign="top" background="images/mail_rightbg.gif"><img
				src="images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<tr>
			<td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">

				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td colspan="2" valign="top">&nbsp;</td>
						<td>&nbsp;</td>
						<td valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" valign="top"><img src="images/pic19.gif"><span
							class="left_bt">${AdminName}</span><br>
						<br> <span class="left_bt">Account sum:${Account} yuan</span><br>
						<br> <span class="left_bt">Rate:${Rate} %</span><br>
						<br> <span class="left_bt">Current Date:${CurrentDate}</span><br>
						<br> <br></td>
						<td width="7%">&nbsp;</td>
						<td width="40%" valign="top">

							<table width="100%" height="228" border="0" cellpadding="0"
								cellspacing="0" id=secTable>
								<tr align="center">
									<td width="7%" height="27"
										background="images/news-title-bg.gif"><img
										src="images/news-title-bg.gif" width="2" height="27"></td>
									<td width="93%" background="images/news-title-bg.gif"
										class="left_bt2">Comments reported newly</td>
								</tr>

								<tr>
									<td colspan="2" valign="top">
										<table class="line_table" border="0" width="100%">
											<tr>
												<td align="center" background="images/news-title-bg.gif"
													width="20%" class="left_bt2">Time</td>
												<td align="center" background="images/news-title-bg.gif"
													width="80%" class="left_bt2">Comments</td>
											</tr>

											<c:forEach items="${Comments}" var="comment">
												<tr>
													<td align="center" width="20%" class="left_bt2"><a
														href="AdminCommentServlet?id=${comment.commentId}"
														target="main">${comment.time}</a></td>
													<td align="center" width="80%" class="left_bt2"><a
														href="AdminCommentServlet?id=${comment.commentId}"
														target="main">${comment.comment}</a></td>
												</tr>
											</c:forEach>

											<tr align="center">
												<td></td>
												<td align="right" class="left_bt2">${CommentsMsg1}<a
													href="CommentsServlet?type=1">${CommentsMsg2}</a></td>
											</tr>
										</table>

									</td>
								</tr>

							</table>


						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" valign="top">
							<!--HTML部分-->
							<TABLE width=96% border=0 cellPadding=0 cellSpacing=0 id=secTable>
								<TBODY>
									<TR align="center" height=20>
										<td background="images/news-title-bg.gif" class="left_bt2">Shops
											applied newly</td>
									</TR>
								</TBODY>
							</TABLE>
							<TABLE class=main_tab id=mainTable cellSpacing=0 cellPadding=0
								width=96% border=0>
							</TABLE>
							<table class="line_table" width="96%">
								<tr>
									<td align="center" background="images/news-title-bg.gif"
										width="20%" class="left_bt2">Shop</td>
									<td align="center" background="images/news-title-bg.gif"
										width="20%" class="left_bt2">ShopOwner</td>
									<td align="center" background="images/news-title-bg.gif"
										width="60%" class="left_bt2">Description</td>
								</tr>

								<c:forEach items="${Shops}" var="shop">
									<tr>
										<td align="center" width="20%" class="left_bt2"><a
											href="ShopServlet?id=${shop.shopInfoId}" target="main">${shop.shopInfoName}</a></td>
										<td align="center" width="20%" class="left_bt2"><a
											href="ShopServlet?id=${shop.shopInfoId}" target="main">${shop.customerName}</a></td>
										<td align="center" width="60%" class="left_bt2"><a
											href="ShopServlet?id=${shop.shopInfoId}" target="main">${shop.shopInfoDescription}</a></td>
									</tr>
								</c:forEach>

								<tr align="center">
									<td></td>
									<td></td>
									<td align="right" class="left_bt2">${ShopsMsg1}<a
										href="ShopsServlet?type=-1">${ShopsMsg2}</a></td>
								</tr>
							</table>
						</td>



						<td>&nbsp;</td>
						<td valign="top"><table width="100%" height="228" border="0"
								cellpadding="0" cellspacing="0" id=secTable>
								<tr align="center">
									<td width="7%" height="27"
										background="images/news-title-bg.gif"><img
										src="images/news-title-bg.gif" width="2" height="27"></td>
									<td width="93%" background="images/news-title-bg.gif"
										class="left_bt2">Customers reported newly</td>
								</tr>
								<tr>
									<td colspan="2" valign="top">
										<table class="line_table" width="100%">
											<tr>
												<td align="center" background="images/news-title-bg.gif"
													width="20%" class="left_bt2">Customer</td>
												<td align="center" background="images/news-title-bg.gif"
													width="20%" class="left_bt2">RealName</td>
												<td align="center" background="images/news-title-bg.gif"
													width="5%" class="left_bt2">Sex</td>
												<td align="center" background="images/news-title-bg.gif"
													width="15%" class="left_bt2">PhoneNumber</td>
												<td align="center" background="images/news-title-bg.gif"
													width="20%" class="left_bt2">AccountState</td>
												<td align="center" background="images/news-title-bg.gif"
													width="20%" class="left_bt2">RegTime</td>
											</tr>

											<c:forEach items="${Customers}" var="customer">
												<tr>
													<td align="center" width="20%" class="left_bt2"><a
														href="CustomerServlet?id=${customer.customerName}"
														target="main">${customer.customerName}</a></td>
													<td align="center" width="20%" class="left_bt2"><a
														href="CustomerServlet?id=${customer.customerName}"
														target="main">${customer.realName}</a></td>
													<td align="center" width="5%" class="left_bt2"><a
														href="CustomerServlet?id=${customer.customerName}"
														target="main">${customer.sex}</a></td>
													<td align="center" width="15%" class="left_bt2"><a
														href="CustomerServlet?id=${customer.customerName}"
														target="main">${customer.phoneNumber}</a></td>
													<td align="center" width="20%" class="left_bt2"><a
														href="CustomerServlet?id=${customer.customerName}"
														target="main">${customer.state}</a></td>
													<td align="center" width="20%" class="left_bt2"><a
														href="CustomerServlet?id=${customer.customerName}"
														target="main">${customer.regTime}</a></td>
												</tr>
											</c:forEach>

											<tr align="center">
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td align="center" class="left_bt2">${CustomersMsg1}<a
													href="CustomersServlet?type=1">${CustomersMsg2}</a></td>
											</tr>




										</table>
								</tr>
							</table></td>
					</tr>
					<tr>
						<td height="25" colspan="4"><table width="100%" height="1"
								border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
								<tr>
									<td></td>
								</tr>
							</table></td>
					</tr>
					<tr>
						<td width="2%">&nbsp;</td>
						<td width="51%" class="left_txt"><img
							src="images/icon-mail2.gif" width="16" height="11">
							Official Email: *********@qq.com<br> <img
							src="images/icon-phone.gif" width="17" height="14">
							Official Telephone: ***********</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>
			<td background="images/mail_rightbg.gif">&nbsp;</td>
		</tr>
		<tr>
			<td valign="bottom" background="images/mail_leftbg.gif"><img
				src="images/buttom_left2.gif" width="17" height="17" /></td>
			<td background="images/buttom_bgs.gif"><img
				src="images/buttom_bgs.gif" width="17" height="17"></td>
			<td valign="bottom" background="images/mail_rightbg.gif"><img
				src="images/buttom_right2.gif" width="16" height="17" /></td>
		</tr>
	</table>
</body>
</html>