package View;

import java.util.ArrayList;
import java.util.List;

import Model.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.ToolBar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

	Button addButton2 = new Button("Найти");
	Button addButton = new Button("Добавить");
	Button addButton3 = new Button("Удалить");
	Button addButton4 = new Button("Загрузить");
	Button addButton5 = new Button("Сохранить");
	Table table;
	Table table1;
	Table table2;
	public  List<Table> listOfPages;
	public  HBox hb = new HBox(10);
	public  HBox hb2 = new HBox(10);
	public  HBox hb3;
	public  VBox vbox;
	MenuBar menuBar;
	public  TextField addStudent;
	public  TextField numOfRec;
	public  Label label;
	public  Label lNumOfRec;
	public  int numOfPage = 1;
	public  int numOfRecords = 0;
	public  int numOfDel = 0;
	Label lNumPage;

	public void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {

		Scene scene = new Scene(new Group());
		stage.setTitle("");
		stage.setWidth(800);
		stage.setHeight(600);
		
		Save save1 = new Save();
		
		Menu menu = new Menu("Меню");
		
		
		SearchWindow search = new SearchWindow(listOfPages, numOfPage, lNumPage);
		
		Button but1 = new Button("Найти");
		Button but = new Button("Добавить");
		Button but2 = new Button("Удалить");
		Button but3 = new Button("Загрузить");
		Button but4 = new Button("Сохранить");

		numOfRec = new TextField();
		numOfRec.setText("1");
		
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu);

		addStudent = new TextField();

		addStudent.setText("File");

		MenuItem addItm = new MenuItem("добавить данные");
		addItm.setOnAction(e -> {int size = listOfPages.get(numOfPage).data.size(); AddWindow.display(listOfPages, numOfPage, numOfRecords, lNumPage, numOfDel, lNumOfRec); 
		numOfRecords += (listOfPages.get(numOfPage).data.size() - size);
		update();});
		MenuItem searchByStudItm = new MenuItem("поиск");
		searchByStudItm.setOnAction(e -> {
			search.display(true,listOfPages, numOfPage, lNumPage);
		});

		MenuItem deleteByStudItm = new MenuItem("удаление");
		deleteByStudItm.setOnAction(e -> {int size = listOfPages.get(numOfPage).data.size(); search.display(false,listOfPages, numOfPage, lNumPage); numOfRecords -= size - listOfPages.get(numOfPage).data.size(); numOfDel += (size - listOfPages.get(numOfPage).data.size()); update();});

		MenuItem save = new MenuItem("сохранение");
		save.setOnAction(e -> save1.main(null, addStudent.getText(), listOfPages, numOfPage));

		MenuItem download = new MenuItem("загрузка");
		ReadXMLFile read = new ReadXMLFile(addStudent.getText(), lNumOfRec, listOfPages, numOfPage, numOfRecords, numOfRec.getText());
		deleteByStudItm.setOnAction(e -> {int size = listOfPages.get(numOfPage).data.size(); read.main(null, read, addStudent.getText(), lNumOfRec, listOfPages, numOfPage, numOfRecords, numOfRec.getText()); numOfRecords += (listOfPages.get(numOfPage).data.size() - size);update();});

		menu.getItems().addAll(addItm, searchByStudItm, deleteByStudItm, save, download);

		addStudent.setPromptText("Input text");

		label = new Label();
		label.setText("Всего удалено: " + String.valueOf(numOfDel));

		lNumOfRec = new Label();
		lNumOfRec.setText("Всего записей: " + String.valueOf(numOfRecords));

		
		lNumPage = new Label();
		lNumPage.setText("Номер страницы  - 1 / 3");

		Button button1 = new Button("1");
		Button button2 = new Button("<-");
		Button button3 = new Button("->");
		Button button4 = new Button("3");
		Button button5 = new Button("Изменить");

		table = new Table();
		table.table.setItems(table.data);
		table1 = new Table();
		table1.table.setItems(table1.data);
		table2 = new Table();
		table2.table.setItems(table2.data);

		listOfPages = new ArrayList();
		listOfPages.add(table);
		listOfPages.add(table1);
		listOfPages.add(table2);
	
		
		listOfPages.add(table);
		hb.getChildren().addAll(addStudent, addButton, addButton2, addButton3, addButton4, addButton5, menuBar, button1,
				button2, button3, button4);
		hb.setSpacing(3);

		Label records = new Label();
		records.setText("Количество строк ");
		ToolBar toolBar = new ToolBar(but, but1, but2, but3, but4);

		but.setOnAction(e -> {int size = listOfPages.get(numOfPage).data.size(); AddWindow.display(listOfPages, numOfPage, numOfRecords, lNumPage, numOfDel, lNumOfRec); 
		numOfRecords += (listOfPages.get(numOfPage).data.size() - size);
		update();});
		but1.setOnAction(e -> search.display(true,listOfPages, numOfPage, lNumPage));
		but2.setOnAction(e -> {int size = listOfPages.get(numOfPage).data.size(); search.display(false,listOfPages, numOfPage, lNumPage); numOfRecords -= size - listOfPages.get(numOfPage).data.size();numOfDel += (size - listOfPages.get(numOfPage).data.size());update();});
		but3.setOnAction(e -> {int size = listOfPages.get(numOfPage).data.size(); read.main(null, read, addStudent.getText(), lNumOfRec, listOfPages, numOfPage, numOfRecords, numOfRec.getText()); numOfRecords += (listOfPages.get(numOfPage).data.size() - size);update();});
		but4.setOnAction(e -> save1.main(null, addStudent.getText(), listOfPages, numOfPage));

		hb2.getChildren().addAll(lNumPage, records, numOfRec, toolBar);

		hb3 = new HBox(10);
		hb3.getChildren().addAll(label, lNumOfRec);
		vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2, hb3);

		button1.setOnAction(e -> {
			numOfPage = 1;
			vbox.getChildren().clear();
			vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2, hb3);
			lNumPage.setText("Номер страницы  - 1 / 3");
		});
		button2.setOnAction(e -> {
			numOfPage -= 1;
			vbox.getChildren().clear();
			vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2, hb3);
			lNumPage.setText("Номер страницы  - " + String.valueOf(numOfPage) + " /3");
		});
		button3.setOnAction(e -> {
			numOfPage += 1;
			vbox.getChildren().clear();
			vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2, hb3);
			lNumPage.setText("Номер страницы  - " + String.valueOf(numOfPage) + " /3");
		});
		button4.setOnAction(e -> {
			numOfPage = 3;
			vbox.getChildren().clear();
			vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2, hb3);
			lNumPage.setText("Номер страницы - 3 / 3");
		});
		button5.setOnAction(e -> numOfRec.getText());
		
		addButton.setOnAction(e -> {System.out.println(numOfRecords);int size = listOfPages.get(numOfPage).data.size(); AddWindow.display(listOfPages, numOfPage, numOfRecords, lNumPage, numOfDel, lNumOfRec); 
		numOfRecords += (listOfPages.get(numOfPage).data.size() - size);
		System.out.println(numOfRecords);
		update();});
		addButton2.setOnAction(e -> search.display(true,listOfPages, numOfPage, lNumPage));
		addButton3.setOnAction(e -> {int size = listOfPages.get(numOfPage).data.size(); search.display(false,listOfPages, numOfPage, lNumPage); numOfRecords -= (size - listOfPages.get(numOfPage).data.size()); numOfDel += (size - listOfPages.get(numOfPage).data.size());update();});
		addButton4.setOnAction(e -> {int size = listOfPages.get(numOfPage).data.size(); read.main(null, read, addStudent.getText(), lNumOfRec, listOfPages, numOfPage, numOfRecords, numOfRec.getText()); numOfRecords += (listOfPages.get(numOfPage).data.size() - size);update();});
		addButton5.setOnAction(e -> save1.main(null, addStudent.getText(), listOfPages, numOfPage));

		
		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();
	}

	public void update() {
		vbox.getChildren().clear();
		vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2, hb3);
   		lNumOfRec.setText("Всего записей: " + String.valueOf(numOfRecords));
   		label.setText("Всего удалено: " + String.valueOf(numOfDel));
	}

}
