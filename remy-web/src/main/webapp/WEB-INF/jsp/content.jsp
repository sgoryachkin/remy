<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns="http://www.w3.org/1999/xhtml"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:tiles="http://tiles.apache.org/tags-tiles" version="2.1">


	<div style="margin-top: 5px; padding: 5px;"
		class="ui-widget ui-widget-content ui-corner-all">

		<tiles:useAttribute id="list" name="widgets"
			classname="java.util.List" />

		<c:forEach var="item" items="${list}">
			<tiles:insertAttribute value="${item}" flush="true" />
		</c:forEach>

	</div>

</jsp:root>