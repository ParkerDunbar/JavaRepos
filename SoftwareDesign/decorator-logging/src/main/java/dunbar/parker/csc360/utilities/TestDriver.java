package dunbar.parker.csc360.utilities;

import java.io.IOException;

public class TestDriver {

	static Configuration cfg;
	static FileWriter log;
	static FileReader reader;
	
	public static void main(String[] args) throws IOException {
//		log = new LoggingFactory().getInstance(cfg);
// 		log.write("This is my test line");
		
		
//		1
//		log = new NameDatePrependingFileWritingDecorator(new LogFileWriter("C:\\Users\\Parker\\Documents\\log.txt"));
//		log.write("Errlin sucks at phone games");
		
//		2
//		log = new UpShiftFileWritingDecorator(new LogFileWriter("C:\\Users\\Parker\\Documents\\log.txt"));
//		log.write("This is a test string");
		
//		3
//		reader = new DownShiftFileReadingDecorator(new LogFileReader("C:\\Users\\Parker\\Documents\\log.txt"));
//		System.out.println(reader.read());
		
//		4
		/* If you wrap decorator 1 in decorator 2, decorator 2 will upshift the data
		 * first and then the name and date will be prepended.
		 * 
		 * If you wrap decorator 2 in decorator 1, decorator 1 will prepend
		 * the name and date, and then decorator 2 will upshift it all
		 */
		
//		5
//		reader = new WindowsToUnixFileReadingDecorator(new LogFileReader("C:\\Users\\Parker\\Documents\\log.txt"));
//		String test = reader.read();
//		System.out.println(test);
		
	
		
		
		
		
//		Date + ThreadID + Data
//		Swap ThreadIDPrepending and TimestampPrepending class for reverse
		
//		log = new ThreadIdPrependingFileWritingDecorator(
//				new TimestampPrependingFileWritingDecorator(
//				new LogFileWriter("C:\\Users\\Parker\\Documents\\log.txt")));
//		log.write("This is my test line");
		
		
		
	}

}
