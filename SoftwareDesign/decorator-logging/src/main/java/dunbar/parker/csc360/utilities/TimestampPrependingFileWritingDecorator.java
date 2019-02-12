package dunbar.parker.csc360.utilities;

import java.io.IOException;
import java.util.Calendar;

public class TimestampPrependingFileWritingDecorator implements FileWriter {
	
	private FileWriter outWriter;
	
	public TimestampPrependingFileWritingDecorator(FileWriter o) {
		this.outWriter = o;
	}
	
	public void write(String data) throws IOException {
		Calendar c = Calendar.getInstance();
		data = c.getTime() + " " + data;
		outWriter.write(data);
	}

}
