<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.1">


	<c:forEach items="${pagingResult.result}" var="bean">

		<a href="${pageContext.request.contextPath}/dispatcher/restaurant/show?id=${bean.id}"><c:out
				value="${bean.name}" /></a>

		<p>
			<c:out value="${bean.description}" />
		</p>

	</c:forEach>

</jsp:root>
