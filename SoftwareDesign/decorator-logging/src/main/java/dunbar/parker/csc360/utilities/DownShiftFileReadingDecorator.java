package dunbar.parker.csc360.utilities;

import java.io.IOException;

public class DownShiftFileReadingDecorator implements FileReader {

	private FileReader fileIn;
	
	public DownShiftFileReadingDecorator(FileReader r) {
		this.fileIn = r;
	}
	
	public String read() throws IOException {
		String data = this.fileIn.read();
		char splitData[] = data.toCharArray();
		String downShiftString = "";
		for (char c : splitData) {
			if (c != ' ') {
				int ascii = (int) c;
				ascii--;
				downShiftString += (char) ascii;
			} else {
				downShiftString += " ";
			}
		}
		return downShiftString;
	}

}
