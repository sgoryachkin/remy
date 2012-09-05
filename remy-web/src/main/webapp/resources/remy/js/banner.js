picasa('artful.tiger', '5771783291887167073',

function(photoUrl, photoTitle, photoThumb) {
	$('#main_banner').append(
			'<img src="' + photoUrl + '" data-thumb="' + photoUrl
					+ '" alt=""	data-transition="slideInLeft" />');

},

function() {
	$('#main_banner').nivoSlider();
}

);
