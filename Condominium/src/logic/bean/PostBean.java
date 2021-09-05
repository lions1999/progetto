package logic.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class PostBean {

//	FileOutputStream output = null;
//		
//	public void ImageConverter(InputStream input,String nome)  throws Exception {
//		
//		try {
//			File file = new File(nome);
//        	output = new FileOutputStream(file);
//    		byte[] buffer = new byte[1024];
//    		while(input.read(buffer) > 0 ) {
//    			output.write(buffer);
//    		}
//    		System.out.println("Saved to File:"+file.getAbsolutePath());
//		}
//		
//		finally {
//			if(output !=  null) {
//				output.close();
//			}
//			if (input != null) {
//				input.close();
//			}
//		}	
//	}	
	
	private String usr;
	private InputStream img;
	private String text;
	
	public void setUser(String usr) {
		this.usr = usr;
	}
	
	public String getUser() {
		return this.usr;
	}
	
	public void setImage(InputStream img) {
		this.img = img;
	}
	
	public InputStream getImage() {
		return this.img;
	}	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
