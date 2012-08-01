package org.sg.remy.common.image;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

public class ImageServiceTest {
	
	//@Test
	public void uploadImageTest() throws FileNotFoundException{
		ImageService imageService = new ImageServiceImpl();
		String result = imageService.uploadImage(new BufferedInputStream(new FileInputStream(new File("/home/sgoryachkin/1.jpg"))));
		System.out.println(result);
	}

}
