<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.1">


	<div style="margin: 3px;" class="ui-widget">
		<div style="text-align: center; padding: 5px;"
			class="ui-widget-header ui-corner-top">
			Заведение:
			<c:out value="${product.name}" />
		</div>
		<div style="text-align: left; padding: 5px;"
			class="ui-widget-content ui-corner-bottom">

			<h2>
				<c:out value="${product.name}" />
			</h2>

			<h3>
				<c:out value="${product.description}" />
			</h3>

			<c:forEach items="${product.categories}" var="bean">

				<p>
					<c:out value="${bean.name}" />
				</p>

			</c:forEach>

			<div id="restaurant_show_gallery" />

			<script type="text/javascript"
				src="${pageContext.request.contextPath}/resources/remy/js/gallery.js" />
		</div>
	</div>

</jsp:root>