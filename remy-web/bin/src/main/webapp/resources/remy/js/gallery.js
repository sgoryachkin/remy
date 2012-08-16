picasa('artful.tiger', '5771783291887167073', function(photoUrl, photoTitle,
		photoThumb) {
	$('#restaurant_show_gallery').append(
			'<a href="' + photoUrl + '" title="' + photoTitle + '"><img src="'
					+ photoThumb + '" alt="" /></a>');
});
