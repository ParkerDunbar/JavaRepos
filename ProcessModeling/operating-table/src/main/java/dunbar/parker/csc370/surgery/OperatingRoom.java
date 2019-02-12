package dunbar.parker.csc370.surgery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dunbar.parker.csc370.surgery.Patient;

public class OperatingRoom {
	public static final boolean otherServiceProvider = true;

	public static void main(String[] args) {
		// Surgeon 1
		// AR = 1 hour (1 patients / hour)
		// SR = 45 mins (1.3 patients / hour)
		
		// Surgeon 2
		// AR = 30 mins (2 patients / hour)
		// SR = 25 mins (2.4 patients / hour)

		// RV = random value from 0 (inclusive) to 1 (non-inclusive)
		
		// Surgeon 1
		// Inter-arrival time = -Ln(1-RV)*60
		// Surgery time = -Ln(1-RV)*45
		
		// Surgeon 2
		// Inter-arrival time = -Ln(1-RV)*30
		// Surgery time = -Ln(1-RV)*25
		
		List<ServiceProvider> spList = new ArrayList<ServiceProvider>();

		ServiceProvider sp1 = new ServiceProvider();
		spList.add(sp1);
		if(otherServiceProvider) {
			ServiceProvider sp2 = new ServiceProvider();
			spList.add(sp2);
		}
		for(ServiceProvider p : spList) {
			p.start();
		}
	}
}
