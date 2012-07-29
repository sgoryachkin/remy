<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">


	<div id="accordion">

		<c:forEach items="${categories}" var="bean">
			<h3>
				<a
					href="#{pageContext.request.contextPath + '/dispatcher/restaurant/find?page=1&category=' + bean.id}">
					<c:out value="${bean.name}" />
				</a>
			</h3>
			<div>
				<p>
					<c:out value="${bean.description}" />
				</p>
			</div>
		</c:forEach>

	</div>


</jsp:root>