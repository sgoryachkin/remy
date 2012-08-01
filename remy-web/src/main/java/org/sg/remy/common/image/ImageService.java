package org.sg.remy.common.image;

import java.io.InputStream;

public interface ImageService {
	
	String uploadImage(InputStream is);
	String getImageUrl(Long id);

}
