package dunbar.parker.csc360.utilities;

import java.io.IOException;

public class ThreadIdPrependingFileWritingDecorator implements FileWriter {
	
	private FileWriter outWriter;
	
	public ThreadIdPrependingFileWritingDecorator(FileWriter o) {
		this.outWriter = o;
	}

	public void write(String data) throws IOException {
		data = Thread.currentThread().getId() + " " + data;
		outWriter.write(data);
	}

}
