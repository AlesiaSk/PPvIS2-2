package View;

import java.util.List;

import Controller.Delete;
import Model.Search;
import Model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;

public class SearchWindow {

	public  RadioButton radioButton1;
	public  RadioButton radioButton2;
	public  RadioButton radioButton3;
	public  RadioButton radioButton4;
	
	public  Button button;
	public  Button button1;
	public  TextField text;
	public  Table table1 = new Table();
	public  List<Table> listOfPages;
	public int numOfPage;
	public Label lNumPage;
	
	public SearchWindow(List<Table> listOfPages, int numOfPage, Label lNumPage) {
		radioButton1 = new RadioButton("по ФИО студента");
		radioButton2 = new RadioButton("по ФИО родителя или месту работы");
		radioButton3 = new RadioButton("по стажу работы или месту работы");
		radioButton4 = new RadioButton("по ФИО студента или месту работы родителя");
		button = new Button("Выбрать");
		button1 = new Button("Ввести");
		text = new TextField();
		this.listOfPages = listOfPages;
		this.lNumPage = lNumPage;
	}

	public void display(Boolean b, List<Table> listOfPages, int numOfPage, Label lNumPage) {
		
		Stage window = new Stage();
		Scene scene = new Scene(new Group());
		window.initModality(Modality.APPLICATION_MODAL);
		final ToggleGroup group = new ToggleGroup();
		StackPane layout = new StackPane();
		VBox vbox = new VBox();
		if (b == true) {
			button.setOnAction( e -> kindOfSearch(listOfPages, numOfPage));
		} else if (b == false) {
			button.setOnAction(e -> kindOfDelete(listOfPages, numOfPage));
		}

		radioButton1.setToggleGroup(group);
		radioButton2.setToggleGroup(group);
		radioButton3.setToggleGroup(group);
		radioButton4.setToggleGroup(group);
		
		table1.table.setItems(listOfPages.get(numOfPage).data);

		lNumPage.setText("Номер страницы  - " + String.valueOf(numOfPage) + " /3");
		
		Button button11 = new Button("1");
		Button button2 = new Button("<-");
		Button button3 = new Button("->");
		Button button4 = new Button("3");
		
		button11.setOnAction(e -> {
			table1.table.setItems(listOfPages.get(getPage(numOfPage, "1")).data);
			lNumPage.setText("Номер страницы  - 1 / 3");
		});
		button2.setOnAction(e -> {
			table1.table.setItems(listOfPages.get(getPage(numOfPage, "2")).data);
			lNumPage.setText("Номер страницы  - " + String.valueOf(getPage(numOfPage, "2")) + " /3");
		});
		button3.setOnAction(e -> {
			table1.table.setItems(listOfPages.get(getPage(numOfPage, "3")).data);
			lNumPage.setText("Номер страницы  - " + String.valueOf(getPage(numOfPage, "3")) + " /3");
		});
		button4.setOnAction(e -> {
			table1.table.setItems(listOfPages.get(getPage(numOfPage, "4")).data);
			lNumPage.setText("Номер страницы - 3 / 3");
		});
	
		layout.setMargin(radioButton1, new Insets(10, 10, 50, 10));
		layout.setAlignment(radioButton1, Pos.TOP_LEFT);
		layout.setMargin(radioButton2, new Insets(30, 10, 50, 10));
		layout.setAlignment(radioButton2, Pos.TOP_LEFT);
		layout.setMargin(radioButton3, new Insets(50, 10, 50, 10));
		layout.setAlignment(radioButton3, Pos.TOP_LEFT);
		layout.setMargin(radioButton4, new Insets(70, 10, 50, 10));
		layout.setAlignment(radioButton4, Pos.TOP_LEFT);
		layout.setMargin(button, new Insets(90, 10, 50, 10));
		layout.setAlignment(button, Pos.TOP_LEFT);
		layout.setAlignment(text, Pos.BOTTOM_CENTER);
		layout.setMargin(text, new Insets(10, 10, 10, 10));
		layout.setMargin(button11, new Insets(10, 10, 50, 10));
		layout.setAlignment(button11, Pos.TOP_RIGHT);
		layout.setMargin(button2, new Insets(40, 10, 50, 10));
		layout.setAlignment(button2, Pos.TOP_RIGHT);
		layout.setMargin(button3, new Insets(70, 10, 50, 10));
		layout.setAlignment(button3, Pos.TOP_RIGHT);
		layout.setMargin(button4, new Insets(100, 10, 50, 10));
		layout.setAlignment(button4, Pos.TOP_RIGHT);
		
		layout.setMargin(lNumPage, new Insets(130, 10, 50, 10));
		layout.setAlignment(lNumPage, Pos.TOP_RIGHT);
		
		layout.getChildren().addAll(radioButton1, radioButton2, radioButton3, radioButton4, button, text, button1, button11, button2, button3, button4, lNumPage);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		if (b == true) {
			vbox.getChildren().addAll(table1.vbox, layout);
		} else if (b == false) {
			vbox.getChildren().addAll(table1.vbox, layout);
		}

		((Group) scene.getRoot()).getChildren().addAll(vbox);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
	
	public  void kindOfSearch(List<Table >listOfPages, int numOfPage) {
		Search search = new Search();
		System.out.println("hjkh");
		if (radioButton1.isSelected()) {
			System.out.println("hjkh");
			button1.setOnAction(e -> table1.table.setItems(search.tableSearch(table1.table, "first", text.getText(), listOfPages, numOfPage)));
		} else if (radioButton2.isSelected()) {
			button1.setOnAction(e -> table1.table.setItems(search.tableSearch(table1.table, "second", text.getText(), listOfPages, numOfPage)));
		} else if (radioButton3.isSelected()) {
			System.out.println("hjkh");
			button1.setOnAction(e -> table1.table.setItems(search.tableSearch(table1.table, "third", text.getText(), listOfPages, numOfPage)));
		} else if (radioButton4.isSelected()) {
			System.out.println("hjkh");
			button1.setOnAction(e -> table1.table.setItems(search.tableSearch(table1.table, "fourth", text.getText(), listOfPages, numOfPage)));
		}
		else {
			System.out.println("else");
		}
	}

	public  void kindOfDelete(List<Table >listOfPages, int numOfPage) {
		Delete del = new Delete();
		if (radioButton1.isSelected()) {
			button1.setOnAction(e -> listOfPages.get(numOfPage).table
					.setItems(del.deleteFromTable("first", listOfPages.get(numOfPage).table, text.getText(), listOfPages, numOfPage)));
		} else if (radioButton2.isSelected()) {
			button1.setOnAction(e -> listOfPages.get(numOfPage).table.setItems(
					del.deleteFromTable("second", listOfPages.get(numOfPage).table, text.getText(), listOfPages, numOfPage)));
		} else if (radioButton3.isSelected()) {
			button1.setOnAction(e -> listOfPages.get(numOfPage).table
					.setItems(del.deleteFromTable("third", listOfPages.get(numOfPage).table, text.getText(), listOfPages, numOfPage)));
		} else if (radioButton4.isSelected()) {
			button1.setOnAction(e -> listOfPages.get(numOfPage).table.setItems(
					del.deleteFromTable("fourth", listOfPages.get(numOfPage).table, text.getText(), listOfPages, numOfPage)));
		}
	}
	
	public int getPage(int numOfPage, String num) {
		if (num == "1") {
			numOfPage = 1;
		}
		else if (num == "2") {
			numOfPage -= 1;
		}
		else if (num == "3") {
			numOfPage += 1;
		}
		else if (num == "4") {
			numOfPage = 3;
		}
		
		return (numOfPage);
	}

}
