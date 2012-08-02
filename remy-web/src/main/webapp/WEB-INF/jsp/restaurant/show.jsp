<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.1">


	<h2>
		<c:out value="${restaurant.name}" />
	</h2>

	<h3>
		<c:out value="${restaurant.description}" />
	</h3>

	<c:forEach items="${restaurant.categories}" var="bean">

		<p>
			<c:out value="${bean.name}" />
		</p>

	</c:forEach>

	<ul id="restaurant_show_gallery"></ul>
	<script type="text/javascript">
	<![CDATA[
		$
				.ajax({
					type : 'GET',
					url : 'http://picasaweb.google.com/data/feed/base/user/artful.tiger/albumid/5771783291887167073?alt=json&thumbsize=80',
					success : function(data) {
						$.each(data.feed.entry, function(i, item) {
								$.each(
															item.media$group.media$content,
															function(i, item) {
																photoUrl = item.url;
															});
											$
													.each(
															item.media$group.media$thumbnail,
															function(i, item) {
																photoThumb = item.url;
															});

											photo = photoUrl.split('/')[7];
											photoUrl = photoUrl.replace(photo,
													's1200/' + photo);

											photoTitle = item.media$group.media$title.$t;
											if (photoTitle == photo)
												photoTitle = '';

											$('#restaurant_show_gallery').append('<li><a href="' + photoUrl + '" title="' + photoTitle + '"><img src="'  + photoThumb + ' alt="" /></a></li>');
									       });}, dataType: 'json', async: false,  });
								]]>
						</script>

</jsp:root>