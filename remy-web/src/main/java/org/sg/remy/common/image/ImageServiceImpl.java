package org.sg.remy.common.image;

import java.io.InputStream;
import java.net.URL;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.media.MediaSource;
import com.google.gdata.data.media.MediaStreamSource;
import com.google.gdata.data.photos.PhotoEntry;

public class ImageServiceImpl implements ImageService{

	@Override
	public String uploadImage(InputStream is) {
		PicasawebService picaseService = new PicasawebService("exampleCo-exampleApp-1");
		
		try {
			picaseService.setUserCredentials("artful.tiger@gmail.com", "gBarbadosl");
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
	}

	@Override
	public String getImageUrl(Long id) {
		
		return null;
	}

}
