<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns="http://www.w3.org/1999/xhtml"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:tiles="http://tiles.apache.org/tags-tiles" version="2.1">

	<div style="margin: 3px;" class="ui-widget">
		<div style="text-align: center; padding: 5px;"
			class="ui-widget-header ui-corner-top">Админка</div>
		<div style="text-align: left; padding: 5px;"
			class="ui-widget-content ui-corner-bottom">

			<a
				href="${pageContext.request.contextPath}/dispatcher/categorygroup/edit">Группы
				категорий</a> <br /> <a
				href="${pageContext.request.contextPath}/dispatcher/category/edit">Категорий</a>

		</div>
	</div>

</jsp:root>