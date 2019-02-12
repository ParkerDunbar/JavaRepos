package dunbar.parker.csc180.httpconnect;

import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {
		Crawler c = new Crawler();
		Save s = new Save();
		
		for(int i = 0; i < args.length; i++) {
			Crawler.URL = args[i];
			c.URLtoString(args[i]);
		}
		s.getTheGoods(c.Everything);
	}

}