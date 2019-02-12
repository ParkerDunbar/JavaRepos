package edu.neumont.csc150.temperature;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Temperature implements ActionListener{
	private JFrame window;
	private JPanel mainPanel;
	private JLabel prompt, fTemp, fText, cTemp, cText, kTemp, kText;
	private JTextField inTemp;
	private JButton convert;
	private String farenheit;
	private String celsius;
	private String kelvin;
	private double fDouble;
	private double cDouble;
	private double kDouble;

	public static void main(String[] args) {
		Temperature myInstance = new Temperature();
		myInstance.guiMain();

	}

	private void guiMain() {
		window = new JFrame("Temperature Converter");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGui();
		window.pack();
		window.setVisible(true);
		
	}

	private void initGui() {
		prompt = new JLabel("Please enter a temperature in Farenheit");
		inTemp = new JTextField(25);
		convert = new JButton("Convert");
		
		fTemp = new JLabel("Farenheit: ");
		fText = new JLabel();
		cTemp = new JLabel("Celsius: ");
		cText = new JLabel();
		kTemp = new JLabel("Kelvin: ");
		kText = new JLabel();
		
		convert.addActionListener(this);
		
		GridLayout layout = new GridLayout(2, 6, 10, 10);
		mainPanel = new JPanel();
		mainPanel.setLayout(layout);
		
		mainPanel.add(prompt);
		mainPanel.add(new JPanel());
		mainPanel.add(inTemp);
		mainPanel.add(new JPanel());
		mainPanel.add(convert);
		mainPanel.add(new JPanel());
		
		mainPanel.add(fTemp);
		mainPanel.add(fText);
		mainPanel.add(cTemp);
		mainPanel.add(cText);
		mainPanel.add(kTemp);
		mainPanel.add(kText);
		
		window.getContentPane().add(mainPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == convert) {
			farenheit = inTemp.getText();
			
			try {
			fDouble = Double.parseDouble(farenheit);
			cDouble = (((fDouble - 32) * 5) / 9 );
			kDouble = ((((fDouble - 32) * 5) / 9) + 273);
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(this.window, "Invalid Input");
			}
			
			farenheit = Double.toString(fDouble);
			fText.setText(farenheit);
			
			celsius = Double.toString(cDouble);
			cText.setText(celsius);
			
			kelvin = Double.toString(kDouble);
			kText.setText(kelvin);
			
		}
		
	}

}
