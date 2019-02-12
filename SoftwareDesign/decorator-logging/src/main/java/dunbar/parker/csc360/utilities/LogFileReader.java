package dunbar.parker.csc360.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogFileReader implements FileReader {

	private FileInputStream fileIn;
	private File file;
	
	public LogFileReader(String path) throws FileNotFoundException {
		this.setFileInputStream(path);
		this.setFile(path);
	}
	
	public String read() throws IOException {
		byte[] data = new byte[(int) file.length()];
		this.fileIn.read(data);
		String newData = new String(data);
		return newData;
		
	}
	
	private void setFileInputStream(String path) throws FileNotFoundException {
		if(path == null) {
			throw new IllegalArgumentException("cannot be null");
		}
		fileIn = new FileInputStream(path);
	}
	
	private void setFile(String path) throws FileNotFoundException {
		if(path == null) {
			throw new IllegalArgumentException("cannot be null");
		}
		file = new File(path);
	}
}
