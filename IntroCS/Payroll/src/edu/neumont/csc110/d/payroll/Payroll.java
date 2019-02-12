package edu.neumont.csc110.d.payroll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class Payroll {

	public static void main(String[] args) throws IOException {
		final double HOURLY_RATE = 8.45;
		double hoursWorked = getHoursWorkedFromUser();
		double weeklyPay;
		
		if(hoursWorked > 40) {
			double overTimeHours = hoursWorked - 40;
			weeklyPay = HOURLY_RATE * 40;
			double overTimeWeeklyPay = HOURLY_RATE * overTimeHours * 1.5;
			weeklyPay = weeklyPay + overTimeWeeklyPay;
		}
		else {
			weeklyPay = HOURLY_RATE * hoursWorked;
		}
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String printableWeeklyPay = fmt.format(weeklyPay);
		System.out.println("You earned " + printableWeeklyPay + " this week.");
	}
	
	public static double getHoursWorkedFromUser() throws IOException {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		final int HOURS_IN_A_WEEK = 24 * 7;
		//System.out.println("How many hours did you work this week?");
		String hr;
		double hours = -1;
		boolean isInputValid;
		 do {
			isInputValid = true;
			System.out.println("How many hours did you work this week?");
			hr = console.readLine();
			hours = Double.parseDouble(hr);
			if(hours < 0 || hours > HOURS_IN_A_WEEK) {
				System.out.println("Sorry. No way you could have worked that many hours.");
				isInputValid = false;
			}
		} while(!isInputValid);
		
		return hours;
		
	}
}
