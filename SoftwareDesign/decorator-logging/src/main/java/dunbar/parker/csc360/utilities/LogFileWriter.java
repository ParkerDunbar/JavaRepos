package dunbar.parker.csc360.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class LogFileWriter implements FileWriter {
	
	private FileOutputStream fileOut;

	public LogFileWriter(String path) throws FileNotFoundException {
		this.setFileOutputStream(path);
	}
	
	public void write(String line) throws IOException {
//		long time = System.currentTimeMillis();
//		Calendar c = Calendar.getInstance();
//		c.setTimeInMillis(time);
//		byte[] outBytes = ("" + c.toString() + "  " + 
//							Thread.currentThread().getId() + " " + line).getBytes();
		this.fileOut.write(line.getBytes());
	}
	
	private void setFileOutputStream(String path) throws FileNotFoundException {
		if(path == null) {
			throw new IllegalArgumentException("cannot be null");
		}
		fileOut = new FileOutputStream(path);
	}
}
