<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">

	<div style="margin: 3px;">
		<div id="menu_category" >

			<c:forEach items="${menus}" var="bean">
				<div>
					<h3>
						<a href="#"><c:out value="${bean.name}" /></a>
					</h3>
					<div>
						<c:forEach items="${bean.items}" var="item">
							<a href="${item.url}"> <c:out value="${item.caption}" />
							</a>
							<br />
						</c:forEach>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/remy/js/category.js" />

</jsp:root>