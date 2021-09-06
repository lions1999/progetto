package logic.model;

import java.io.InputStream;

public class Post {

	private String usr;
	private InputStream img;
	private String text;
		
	
	public Post(String usr,String text,InputStream img){
		this.usr = usr;
		this.img = img;
		this.text = text;
	}
	
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
