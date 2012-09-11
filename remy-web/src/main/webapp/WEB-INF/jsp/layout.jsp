<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns="http://www.w3.org/1999/xhtml"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:tiles="http://tiles.apache.org/tags-tiles" version="2.1">

	<jsp:directive.page language="java" contentType="application/xhtml+xml"
		pageEncoding="utf-8" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.1//EN"
		doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"
		omit-xml-declaration="true" />

	<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=utf-8" />


<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/nivo-slider/themes/default/default.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/nivo-slider/themes/light/light.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/nivo-slider/themes/dark/dark.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/nivo-slider/themes/bar/bar.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/nivo-slider/nivo-slider.css"
	type="text/css" media="screen" />
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/jquery/css/dark-hive/jquery-ui-1.8.21.custom.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/remy/css/layout.css"
	type="text/css" />


<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery/js/jquery-1.7.2.min.js" />


<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery/js/jquery-ui-1.8.21.custom.min.js" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/nivo-slider/jquery.nivo.slider.js" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/remy/js/helper.js" />




<style type="text/css">
/*demo page css*/
body {
	font: 70% "Trebuchet MS", sans-serif;
	margin: 10px;
}

.demoHeaders {
	margin-top: 2em;
}

#dialog_link {
	padding: .4em 1em .4em 20px;
	text-decoration: none;
	position: relative;
}

#dialog_link span.ui-icon {
	margin: 0 5px 0 0;
	position: absolute;
	left: .2em;
	top: 50%;
	margin-top: -8px;
}

ul#icons {
	margin: 0;
	padding: 0;
}

ul#icons li {
	margin: 2px;
	position: relative;
	padding: 4px 0;
	cursor: pointer;
	float: left;
	list-style: none;
}

ul#icons span.ui-icon {
	float: left;
	margin: 0 4px;
}
</style>


</head>
<body>

	<div id="layout-container">
		<div id="layout-header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="layout-container2">
			<div id="layout-left">
				<tiles:insertAttribute name="left" />
			</div>
			<div id="layout-content">
				<tiles:insertAttribute name="content" />
			</div>
			<div id="layout-right">
				<tiles:insertAttribute name="right" />
			</div>
		</div>
		<div id="layout-footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

</body>
	</html>
</jsp:root>