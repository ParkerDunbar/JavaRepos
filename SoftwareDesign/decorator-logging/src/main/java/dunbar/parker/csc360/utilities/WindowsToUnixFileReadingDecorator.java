package dunbar.parker.csc360.utilities;

import java.io.IOException;

public class WindowsToUnixFileReadingDecorator implements FileReader {
	
	private FileReader fileIn;
	
	public WindowsToUnixFileReadingDecorator(FileReader r) {
		this.fileIn = r;
	}

	public String read() throws IOException {
		String line = this.fileIn.read();
		line = line.replaceAll("\r\n", "\n");
		return line;
	}

}
