package curtis.max.Driver;

import java.io.FileOutputStream;
import java.io.IOException;

public class File_Writer {

	private FileOutputStream outputStream;
	private String JavaTempletStart = getJavatempletStart();
	private String JavaTempletEnd = getJavatempletEnd();
	private String HTMLTempletStart = getHTMLtempletStart();
	private String HTMLTempletEnd = getHTMLtempletEnd();

	public void write(String componentCode, String type, String fileLocation) throws IOException {
		if (type.equalsIgnoreCase("Jave")) {
			outputStream = new FileOutputStream(fileLocation);
			outputStream.write((JavaTempletStart + componentCode + JavaTempletEnd).getBytes());
			outputStream.flush();
			outputStream.close();
		} else if (type.equalsIgnoreCase("HTML")) {
			outputStream = new FileOutputStream(fileLocation);
			outputStream.write((HTMLTempletStart + componentCode + HTMLTempletEnd).getBytes());
			outputStream.flush();
			outputStream.close();
		} else {
			throw new IllegalArgumentException();
		}

	}

	private String getHTMLtempletStart() {
		return "<!DOCTYPE><html>";
	}

	private String getHTMLtempletEnd() {
		return "</html>";
	}

	private String getJavatempletStart() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "\r\n" + "<?import javafx.geometry.*?>\r\n"
				+ "<?import javafx.scene.control.*?>\r\n" + "<?import java.lang.*?>\r\n"
				+ "<?import javafx.scene.layout.*?>\r\n"
				+ "<AnchorPane maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"902.0\" prefWidth=\"1034.0\" xmlns=\"http://javafx.com/javafx/8\" xmlns:fx=\"http://javafx.com/fxml/1\">\r\n"
				+ "   <children>";
	}

	private String getJavatempletEnd() {
		return "   </children>\r\n" + "</AnchorPane>";
	}

}
