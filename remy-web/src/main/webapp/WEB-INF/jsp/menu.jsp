<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:sgsec="http://web.gaeshop.sg.org/taglib/sgsec"
	xmlns:sgsecfn="http://web.gaeshop.sg.org/taglib/sgsecfn"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.0">


	<table>
		<tr>
			<td colspan="2" style="font-weight: bold;">Available URLs:</td>
		</tr>
		<tr>
			<td><a href="find">List</a></td>
		</tr>
		<tr>
		<td>
			<h2>
				<c:out value="${menu}" />
			</h2>
		</td>
		</tr>


	</table>


</jsp:root>