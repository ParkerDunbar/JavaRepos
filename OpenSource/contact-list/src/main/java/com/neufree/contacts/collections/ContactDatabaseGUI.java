package com.neufree.contacts.collections;

import com.neufree.contacts.Contact;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContactDatabaseGUI extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox container = new VBox();
		Label head = new Label("Contact Database");
		TableView<Contact> table = new TableView<Contact>();
		TableColumn firstName = new TableColumn("First Name");
        TableColumn lastName = new TableColumn("Last Name");
        TableColumn email = new TableColumn("Email");
        TableColumn primaryEmail = new TableColumn("Primary");
        TableColumn secondaryEmail = new TableColumn("Secondary");
        TableColumn phone = new TableColumn("Phone");
        TableColumn primaryPhone = new TableColumn("Primary");
        TableColumn secondaryPhone = new TableColumn("Secondary");
        Button edit = new Button("Edit");
        
        head.setFont(new Font("Arial", 20));
        container.getChildren().addAll(head, table, edit);
        container.setSpacing(5);
        container.setAlignment(Pos.CENTER);
        email.getColumns().addAll(primaryEmail, secondaryEmail);
        phone.getColumns().addAll(primaryPhone, secondaryPhone);
        table.getColumns().addAll(firstName, lastName, email, phone);
		
		
		Scene mainScene = new Scene(container);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Contact Database");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		ContactDatabaseGUI.launch();
	}

}
