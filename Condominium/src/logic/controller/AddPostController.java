package logic.controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddPostController {
	
	public File selectFile() {
		File file = null;
    	JFileChooser fc = new JFileChooser();  
    	fc.setCurrentDirectory(new java.io.File("C:/Users/"));
    	FileFilter filter = new FileNameExtensionFilter("JPEG/JPG/PNG/GIF file", "jpg", "jpeg","png","gif");
    	fc.setFileFilter(filter);
    	int response = fc.showOpenDialog(null);
		if(response == JFileChooser.APPROVE_OPTION) {
			 file =  new File(fc.getSelectedFile().getAbsolutePath());
		} 
		return file;
	}
}
