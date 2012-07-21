<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">

	<form:form commandName="productBean">
		<table>
			<tr>
				<td><label for="nameInput">Название:</label></td>
				<td><form:input id = "nameInput" path="name" /></td>
			</tr>
			<tr>
				<td><label for="code1Input">Внутренний код:</label></td>
				<td><form:input id = "code1Input" path="code1" /></td>
			</tr>
			<tr>
				<td><label for="code2Input">Внешний код:</label></td>
				<td><form:input id="code2Input" path="code2" /></td>
			</tr>
			<tr>
				<td><label for="descTextarea">Описание:</label></td>
				<td><form:textarea id="descTextarea" path="desc" rows="10"/></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Сохранить" /></td>
			</tr>
		</table>
	</form:form>

</jsp:root>