<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">

	<h2>Добавить/Изменить группу категорий</h2>
	<form:form commandName="productCategoryGroup"
		id="productCategoryGroup_form">
		<table>
			<tbody>
				<tr>
					<td><form:label path="code">Name:</form:label></td>
					<td><form:input path="code" /></td>
					<td><form:errors class="invalid" path="code" /></td>
				</tr>
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name" /></td>
					<td><form:errors class="invalid" path="name" /></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tr>
				<td><input type="submit" value="Добавить/Изменить" /></td>
			</tr>
		</table>
	</form:form>
</jsp:root>