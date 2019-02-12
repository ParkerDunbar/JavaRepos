package edu.neumont.csc150.hellowindow;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class HelloWindow implements ActionListener {
	public final int TEXT_FIELD_WIDTH = 6;
	public final int TO_BOX_HEIGHT = 1;
	public final int ATTACH_BOX_HEIGHT = 1;
	public final int TEXT_BOX_HEIGHT = 1;
	
	private JFrame window;
	private JPanel mainPanel;
	private JLabel createdByLabel, fromLabel, toLabel, subjectLabel, attachLabel, textLabel;
	private JTextField createdByField, fromField, subjectField;
	private JTextArea toArea, attachArea, textArea;
	private JButton addToButton, addAttachButton;
	
	public static void main(String[] args) {
		HelloWindow myInstance = new HelloWindow();
		myInstance.guiMain();
	}
	
	public void guiMain() {
		window = new JFrame("Nice");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGui();
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	private void initGui() {
		createdByLabel = new JLabel("Created-by:");
		fromLabel = new JLabel("From:");
		toLabel = new JLabel("To:");
		subjectLabel = new JLabel("Subject:");
		attachLabel = new JLabel("Attachments:");
		textLabel = new JLabel("Text");
		
		createdByField = new JTextField(TEXT_FIELD_WIDTH);
		fromField = new JTextField(TEXT_FIELD_WIDTH);
		subjectField = new JTextField(TEXT_FIELD_WIDTH);
		
		toArea = new JTextArea(TO_BOX_HEIGHT, TEXT_FIELD_WIDTH);
		attachArea = new JTextArea(ATTACH_BOX_HEIGHT, TEXT_FIELD_WIDTH);
		textArea = new JTextArea(TEXT_BOX_HEIGHT, TEXT_FIELD_WIDTH);
		
		addToButton = new JButton("Add");
		addAttachButton = new JButton("Add");
		
		addToButton.addActionListener(this);
		addAttachButton.addActionListener(this);
		
		
		//FlowLayout layout = new FlowLayout();
		//BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.X_AXIS);
		//BorderLayout layout = new BorderLayout();
		GridLayout gridLayout = new GridLayout(6, 3, 10, 10);
		mainPanel = new JPanel();
		mainPanel.setLayout(gridLayout);
		
		mainPanel.add(createdByLabel);
		mainPanel.add(createdByField);
		mainPanel.add(new JPanel());
		
		mainPanel.add(fromLabel);
		mainPanel.add(fromField);
		mainPanel.add(new JPanel());
		
		mainPanel.add(toLabel);
		mainPanel.add(toArea);
		mainPanel.add(addToButton);
		
		mainPanel.add(subjectLabel);
		mainPanel.add(subjectField);
		mainPanel.add(new JPanel());
		
		mainPanel.add(attachLabel);
		mainPanel.add(attachArea);
		mainPanel.add(addAttachButton);
		
		mainPanel.add(textLabel);
		mainPanel.add(textArea);
		mainPanel.add(new JPanel());
		
		
		
		window.getContentPane().add(mainPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addToButton) {
			JOptionPane.showMessageDialog(window, "Clicked the add recipient button");
		}
		else if(e.getSource() == addAttachButton) {
			JOptionPane.showMessageDialog(window, "Clicked the add attachment button");
		}
		
	}

}
