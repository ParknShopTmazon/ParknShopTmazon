<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>management center</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<frameset rows="64,*" frameborder="NO" border="0" framespacing="0">
	<frame src="admin/admin_top.jsp" noresize="noresize" frameborder="0"
		name="topFrame" scrolling="no" marginwidth="0" marginheight="0"
		target="main" />
	<frameset cols="200,*" rows="100%,*" id="frame">
		<frame src="admin/left.jsp" name="leftFrame" noresize="noresize"
			marginwidth="0" marginheight="0" frameborder="0" scrolling="no"
			target="main" />
		<frame src="admin/right.jsp" name="main" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="auto" target="_self" />
	</frameset>
</frameset>
<noframes>
	<body></body>
</noframes>
</html>
