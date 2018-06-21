package View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Model.Student;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.cell.PropertyValueFactory;

public class Table {

	public VBox vbox;
	public HBox hbox;
	public TableView<Student> table;
    public Label numOfPage;
    public Label numOfRec;
    public TextField inputNumOfRec;
    List<Student> list;
    public int rec = 10;
    public  ObservableList<Student> data;
    public int pageNumber = 1;
    
	public Table() {
	table = new TableView();
	table.setEditable(true);
	
	TableColumn studentFIO = new TableColumn("ФИО студента");
    studentFIO.setMinWidth(150);
    studentFIO.setCellValueFactory(
            new PropertyValueFactory<>("stud"));
   
    TableColumn parentFIO = new TableColumn("ФИО родителя");
    parentFIO.setMinWidth(150);
    parentFIO.setCellValueFactory(
            new PropertyValueFactory<>("parent"));
    
    TableColumn address = new TableColumn("Адрес работы родителя");
    address.setMinWidth(150);
    address.setCellValueFactory(
            new PropertyValueFactory<>("addr"));
    
    TableColumn parentWork = new TableColumn("Должность родителя");
    parentWork.setMinWidth(150);
    parentWork.setCellValueFactory(
            new PropertyValueFactory<>("job"));
    
    TableColumn workExperience = new TableColumn("Стаж работы родителя");
    workExperience.setMinWidth(150);
    workExperience.setCellValueFactory(
            new PropertyValueFactory<>("exp"));
    
    table.getColumns().addAll(studentFIO, parentFIO, address, parentWork, workExperience);
    
    data = FXCollections.observableArrayList();
     
    vbox = new VBox(5);
    vbox.getChildren().add(table);
    
    numOfPage = new Label();
    numOfRec = new Label();
    
    inputNumOfRec = new TextField();
    
    
    
    hbox = new HBox();
    hbox.getChildren().addAll(numOfRec);
    vbox.getChildren().add(hbox);
	}

	
	
	
	
	 
}
