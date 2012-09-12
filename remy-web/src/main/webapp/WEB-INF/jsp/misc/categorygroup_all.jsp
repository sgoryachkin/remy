<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">

	<h2>Группы категорий</h2>
	<c:choose>
		<c:when test="${fn:length(categorygroup_all)==0}">
			<em>Группы категорий отсутствуют</em>
		</c:when>
		<c:otherwise>
			<table class="simpletablestyle">
				<thead>
					<tr>
						<th>Id</th>
						<th>Код</th>
						<th>Имя</th>
						<th>Только один в продукте</th>
						<th>Отображать в фильтрах</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categorygroup_all}" var="bean">
						<tr>
							<td>${bean.id}</td>
							<td>${bean.code}</td>
							<td>${bean.name}</td>
							<td>${bean.multiple}</td>
							<td>${bean.showable}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

</jsp:root>