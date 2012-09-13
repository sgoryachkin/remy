<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns="http://www.w3.org/1999/xhtml"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:tiles="http://tiles.apache.org/tags-tiles" version="2.1">

	<div style="margin: 5px; padding: 5px;"
		class="ui-widget ui-widget-content ui-corner-all">

		<tiles:useAttribute id="footerlist" name="widgets"
			classname="java.util.List" />

		<c:forEach var="item" items="${footerlist}">
			<tiles:insertAttribute value="${item}" />
		</c:forEach>

	</div>

</jsp:root>