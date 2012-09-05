var picasa = function(userId, albomId, photoListener, postProcessListener) {

	var parseData = function(data) {
		$.each(data.feed.entry, function(i, item) {
			$.each(item.media$group.media$content, function(i, item) {
				photoUrl = item.url;
			});
			$.each(item.media$group.media$thumbnail, function(i, item) {
				photoThumb = item.url;
			});

			photo = photoUrl.split('/')[7];
			photoUrl = photoUrl.replace(photo, 's1024/' + photo);

			photoTitle = item.media$group.media$title.$t;
			if (photoTitle == photo)
				photoTitle = '';

			photoListener(photoUrl, photoTitle, photoThumb);
		});
		postProcessListener();
	};

	$.ajax({
		type : 'GET',
		url : 'https://picasaweb.google.com/data/feed/base/user/' + userId
				+ '/albumid/' + albomId + '?alt=json&thumbsize=80',
		crossDomain : true,
		dataType : 'json',
		async : true,
		success : parseData
	});

};
