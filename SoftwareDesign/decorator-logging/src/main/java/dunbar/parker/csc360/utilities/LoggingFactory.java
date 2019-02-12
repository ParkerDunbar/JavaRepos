package dunbar.parker.csc360.utilities;

import java.io.FileNotFoundException;

public class LoggingFactory {

	public FileWriter getInstance(Configuration cfg) throws FileNotFoundException {
		FileWriter log = new LogFileWriter("C:\\Users\\Parker\\Documents\\log.txt");
 		if(cfg.isTimestampLogging()) {
 			log = new TimestampPrependingFileWritingDecorator(log);
 		}
 		if(cfg.isTheadIdLogging()) {
 			log = new ThreadIdPrependingFileWritingDecorator(log);
 		}
 		return log;
	}
}
