<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">


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

	<div id="accordion">
		<h3>
			<a href="/dsf/dfsf/dsf.html">Бар</a>
		</h3>
		<div>
			<p>Mauris mauris ante, blandit et, ultrices a, suscipit eget,
				quam.</p>
		</div>
		<h3>
			<a href="#">Ресторан</a>
		</h3>
		<div>
			<p>Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum
				sit amet purus. </p>
		</div>
		<h3>
			<a href="#">Кафе</a>
		</h3>
		<div>
			<p>Nam enim risus, molestie et, porta ac, aliquam ac, risus.
				Quisque lobortis. .</p>
			<ul>
				<li>List item one</li>
				<li>List item two</li>
				<li>List item three</li>
			</ul>
		</div>
	</div>


</jsp:root>