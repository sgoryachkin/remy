<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	
	<jsp:directive.page isELIgnored="false"/>

	<table>
		<tr>
			<td>
			<h2><c:out value="${productBean.name}" />  
			</h2>
			</td>
		</tr>
		<tr>
			<td>
			<h3><c:out value="${productBean.code1}" /></h3>
			</td>
		</tr>
		<tr>
			<td>
			<h3><c:out value="${productBean.code2}" /></h3>
			</td>
		</tr>
		<tr>
			<td>
			<h3><c:out value="${productBean.desc}" /></h3>
			</td>
		</tr>
	</table>


</jsp:root>