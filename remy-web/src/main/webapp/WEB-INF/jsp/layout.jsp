<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:tiles="http://tiles.apache.org/tags-tiles" version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="/resources/style/layout.css"
		type="text/css" />

	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	
	</head>
		<body>
			<div id="layout-container">
				<div id="layout-header"><tiles:insertAttribute name="header" /></div>
				<div id="layout-container2">
					<div id="layout-left"><tiles:insertAttribute name="menu" /></div>
					<div id="layout-content"><tiles:insertAttribute name="content" /></div>
					<div id="layout-right">Right</div>
				</div>
				<div id="layout-footer"><tiles:insertAttribute name="footer" /></div>
			</div>
		</body>
	</html>
</jsp:root>