package dunbar.parker.csc360.utilities;

import java.io.IOException;

public class UpShiftFileWritingDecorator implements FileWriter {

	private FileWriter outWriter;

	public UpShiftFileWritingDecorator(FileWriter o) {
		this.outWriter = o;
	}

	public void write(String data) throws IOException {
		char[] splitData = data.toCharArray();
		String upShiftString = "";
		for (char c : splitData) {
			if (c != ' ') {
				int ascii = (int) c;
				ascii++;
				upShiftString += (char) ascii;
			} else {
				upShiftString += " ";
			}
		}
		outWriter.write(upShiftString);
	}

}
