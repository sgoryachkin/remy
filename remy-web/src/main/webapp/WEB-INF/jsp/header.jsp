<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1">

	<div class="slider-wrapper theme-default">
		<div id="main_banner" class="nivoSlider" style="height:200px;">
		
		</div>
	</div>

	<script type="text/javascript">
	<![CDATA[
		$.ajax({type : 'GET',
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
													's800/' + photo);

											photoTitle = item.media$group.media$title.$t;
											if (photoTitle == photo)
												photoTitle = '';
											
											$('#main_banner').append('<img src="'+ photoUrl +'" data-thumb="'+ photoUrl +'" alt=""	data-transition="slideInLeft" />');
									       });}, 
				dataType: 'json', 
				async: false,  
				});
		$('#main_banner').nivoSlider();
	]]>
	</script>

</jsp:root>