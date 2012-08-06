var picasa = function(userId, albomId, photolistener) {
	$.ajax({
		type : 'GET',
		url : 'http://picasaweb.google.com/data/feed/base/user/' + userId
				+ '/albumid/' + albomId + '?alt=json&thumbsize=80',
		success : function(data) {
			$.each(data.feed.entry, function(i, item) {
				$.each(item.media$group.media$content, function(i, item) {
					photoUrl = item.url;
				});
				$.each(item.media$group.media$thumbnail, function(i, item) {
					photoThumb = item.url;
				});

				photo = photoUrl.split('/')[7];
				photoUrl = photoUrl.replace(photo, 's800/' + photo);

				photoTitle = item.media$group.media$title.$t;
				if (photoTitle == photo)
					photoTitle = '';

				photolistener(photoUrl, photoTitle, photoThumb)
			});
		},
		dataType : 'json',
		async : false,
	});
}
