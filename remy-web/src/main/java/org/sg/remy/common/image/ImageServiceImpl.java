package org.sg.remy.common.image;

import java.io.InputStream;

public class ImageServiceImpl implements ImageService{

	@Override
	public String uploadImage(InputStream is) {
		/*
		PicasawebService picaseService = new PicasawebService("exampleCo-exampleApp-1");
		
		try {
			picaseService.setUserCredentials("artful.tiger@gmail.com", "");
			URL albumPostUrl = new URL("https://picasaweb.google.com/data/feed/api/user/artful.tiger/albumid/5771783291887167073");
			MediaSource myMedia = new MediaStreamSource(is, "image/jpeg");
			PhotoEntry returnedPhoto = picaseService.insert(albumPostUrl, PhotoEntry.class, myMedia);
			if (returnedPhoto.getMediaContents().size() > 0) {
				return returnedPhoto.getMediaContents().get(0).getUrl();
			} else {
				throw new RuntimeException();
			}
			
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		*/
		// TODO Удалить
		return null;
	}

	@Override
	public String getImageUrl(Long id) {
		
		return null;
	}

}
