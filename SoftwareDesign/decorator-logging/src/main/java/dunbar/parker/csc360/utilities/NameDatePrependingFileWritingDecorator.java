package dunbar.parker.csc360.utilities;

import java.io.IOException;
import java.util.Calendar;

public class NameDatePrependingFileWritingDecorator implements FileWriter {
	
	private FileWriter outWriter;
	
	public NameDatePrependingFileWritingDecorator(FileWriter o) {
		this.outWriter = o;
	}

	public void write(String data) throws IOException {
		Calendar c = Calendar.getInstance();
		data = "Parker Dunbar " + c.getTime() + " " + data;
		outWriter.write(data);

	}

}
