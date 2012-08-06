<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1">

	<div class="slider-wrapper theme-default">
		<div id="main_banner" class="nivoSlider" style="height:200px;">
		
		</div>
	</div>

	<script type="text/javascript">
	<![CDATA[
	    retrivePicasaAlbom('artful.tiger', '5771783291887167073', function (photoUrl){
			$('#main_banner')
			.append(
					'<img src="'
							+ photoUrl
							+ '" data-thumb="'
							+ photoUrl
							+ '" alt=""	data-transition="slideInLeft" />');
	    });
		$('#main_banner').nivoSlider();
	]]>
	</script>

</jsp:root>