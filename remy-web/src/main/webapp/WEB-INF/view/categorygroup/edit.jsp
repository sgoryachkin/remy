<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">

	<div style="margin: 5px; padding: 5px;"
		class="ui-widget ui-widget-content ui-corner-all">
		<h2>Добавить/Изменить группу категорий</h2>
		<form:form commandName="categorygroupBean" id="categorygroupBean_form">
			<table>
				<tbody>
					<tr>
						<td><form:label path="code">Код:</form:label></td>
						<td><form:input path="code" /></td>
						<td><form:errors class="invalid" path="code" /></td>
					</tr>
					<tr>
						<td><form:label path="name">Имя:</form:label></td>
						<td><form:input path="name" /></td>
						<td><form:errors class="invalid" path="name" /></td>
					</tr>
					<tr>
						<td><form:label path="multiple">Несколько категорий:</form:label></td>
						<td><form:checkbox path="multiple" /></td>
						<td><form:errors class="invalid" path="multiple" /></td>
					</tr>
					<tr>
						<td><form:label path="showable">Видна в фильтрах:</form:label></td>
						<td><form:checkbox path="showable" /></td>
						<td><form:errors class="invalid" path="showable" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td><input type="submit" value="Добавить/Изменить" /></td>
					<td><div class="invalid"><c:out value="${categorygroupBeanError}"/></div></td>
				</tr>
			</table>
		</form:form>
	</div>
</jsp:root>