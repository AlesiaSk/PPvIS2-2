package View;

import java.util.List;

import Controller.Control;
import Model.Address;
import Model.Db;
import Model.Experience;
import Model.Job;
import Model.Person;
import Model.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddWindow {
	
	public  TextField addStudentsName;
	public  TextField addStudentsSecName;
	public  TextField addStudentsSurname;
	public  TextField addParentsName;
	public  TextField addParentsSecName;
	public  TextField addParentsSurname;
	public  TextField addCountry;
	public  TextField addCity;
	public  TextField addStreet;
	public  TextField addHouse;
	public  TextField addJob;
	public  TextField addExp;
	public List<Table> listOfPages;
	public  Label lNumOfRec;
	public  int numOfDel;
	Label lNumPage;
	int numOfPage;
	int numOfRecords;
	int numOfadds;
	
	public AddWindow(List<Table> listOfPages, int numOfPage, int numOfRecords, Label lNumPage, int numOfDel, Label lNumOfRec) {
		this.listOfPages = listOfPages;
		this.numOfPage = numOfPage;
		this.numOfRecords = numOfRecords;
		this.numOfDel = numOfDel;
		this.lNumPage = lNumPage;
		this.lNumOfRec = lNumOfRec;
		numOfadds = 0;
	}
	
	
	public static void display(List<Table> listOfPages, int numOfPage, int numOfRecords, Label lNumPage, int numOfDel, Label lNumOfRec) {
		Db data = new Db();
		AddWindow addWindow = new AddWindow(listOfPages, numOfPage, numOfRecords, lNumPage, numOfDel, lNumOfRec);
		Control controller = new Control(data);
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Button button = new Button("ƒобавить");
		int numOfadds = 0;
		button.setOnAction(e -> { Person stud = new Person(addWindow.addStudentsName.getText(), addWindow.addStudentsSecName.getText(), addWindow.addStudentsSurname.getText());
   		Person parent = new Person(addWindow.addParentsName.getText(), addWindow.addParentsSecName.getText(), addWindow.addParentsSurname.getText());
   		Address adr = new Address(addWindow.addCountry.getText(), addWindow.addCity.getText(), addWindow.addStreet.getText(), Integer.parseInt(addWindow.addHouse.getText()));
   		Job job = new Job(addWindow.addJob.getText());
   		Experience exp = new Experience(Integer.parseInt(addWindow.addExp.getText()));
   		Student student = new Student(stud, parent, adr, job, exp);
   		controller.addStud(student);
   		addWindow.addStudentsName.clear();
   		addWindow.addStudentsSecName.clear();
   		addWindow.addStudentsSurname.clear();
   		addWindow.addParentsName.clear();
   		addWindow.addParentsSecName.clear();
   		addWindow.addParentsSurname.clear();
   		addWindow.addCountry.clear();
   		addWindow.addCity.clear();
   		addWindow.addStreet.clear();
   		addWindow.addJob.clear();
   		addWindow.addExp.clear();
   		addWindow.addToList(listOfPages, numOfPage, student);
   		addWindow.numOfadds +=1;
		});
		
		addWindow.addStudentsName = new TextField();
		addWindow.addStudentsName.setPromptText("¬ведите им€ студента");
		addWindow.addStudentsSecName = new TextField();
		addWindow.addStudentsSecName.setPromptText("¬ведите отчество студента");
		addWindow.addStudentsSurname = new TextField();
		addWindow.addStudentsSurname.setPromptText("¬ведите фамилию студента");
		
		addWindow.addParentsName = new TextField();
		addWindow.addParentsName.setPromptText("¬ведите им€ родител€");
		addWindow.addParentsSecName = new TextField();
		addWindow.addParentsSecName.setPromptText("¬ведите отчество родител€");
		addWindow.addParentsSurname = new TextField();
		addWindow.addParentsSurname.setPromptText("¬ведите фамилию родител€");
		
		addWindow.addCountry = new TextField();
		addWindow.addCountry.setPromptText("¬ведите страну работы родител€");
		addWindow.addCity = new TextField();
		addWindow.addCity.setPromptText("¬ведите город работы родител€");
		addWindow.addStreet = new TextField();
		addWindow.addStreet.setPromptText("¬ведите улицу работы родител€");
		addWindow.addHouse = new TextField();
		addWindow.addHouse.setPromptText("¬ведите номер дома работы родител€");
		
		addWindow.addJob = new TextField();
		addWindow.addJob.setPromptText("¬ведите должность родител€");
		
		addWindow.addExp = new TextField();
		addWindow.addExp.setPromptText("¬ведите стаж работы родител€");
		
		StackPane layout = new StackPane();
		layout.getChildren().addAll(button, addWindow.addStudentsName, addWindow.addStudentsSecName, addWindow.addStudentsSurname, addWindow.addParentsName, addWindow.addParentsSecName, addWindow.addParentsSurname, addWindow.addCountry, addWindow.addCity, addWindow.addStreet, addWindow.addHouse, addWindow.addJob, addWindow.addExp);
		StackPane.setMargin(addWindow.addStudentsName, new Insets(10,10,50,10));
		StackPane.setAlignment(addWindow.addStudentsName, Pos.TOP_LEFT);
		StackPane.setMargin(addWindow.addStudentsSecName, new Insets(50,10,50,10));
		StackPane.setAlignment(addWindow.addStudentsSecName, Pos.TOP_LEFT);
		StackPane.setMargin(addWindow.addStudentsSurname, new Insets(90,10,50,10));
		StackPane.setAlignment(addWindow.addStudentsSurname, Pos.TOP_LEFT);
		
		StackPane.setMargin(addWindow.addParentsName, new Insets(130,10,50,10));
		StackPane.setAlignment(addWindow.addParentsName, Pos.TOP_LEFT);
		StackPane.setMargin(addWindow.addParentsSecName, new Insets(170,10,50,10));
		StackPane.setAlignment(addWindow.addParentsSecName, Pos.TOP_LEFT);
		StackPane.setMargin(addWindow.addParentsSurname, new Insets(210,10,50,10));
		StackPane.setAlignment(addWindow.addParentsSurname, Pos.TOP_LEFT);
		
		StackPane.setMargin(addWindow.addCountry, new Insets(250,10,50,10));
		StackPane.setAlignment(addWindow.addCountry, Pos.TOP_LEFT);
		StackPane.setMargin(addWindow.addCity, new Insets(290,10,50,10));
		StackPane.setAlignment(addWindow.addCity, Pos.TOP_LEFT);
		StackPane.setMargin(addWindow.addStreet, new Insets(330,10,50,10));
		StackPane.setAlignment(addWindow.addStreet, Pos.TOP_LEFT);
		StackPane.setMargin(addWindow.addHouse, new Insets(370,10,50,10));
		StackPane.setAlignment(addWindow.addHouse, Pos.TOP_LEFT);
		
		StackPane.setMargin(addWindow.addJob, new Insets(410,10,50,10));
		StackPane.setAlignment(addWindow.addJob, Pos.TOP_LEFT);
		
		StackPane.setMargin(addWindow.addExp, new Insets(450,10,50,10));
		StackPane.setAlignment(addWindow.addExp, Pos.TOP_LEFT);
		
		StackPane.setMargin(button, new Insets(490,10,50,10));
		StackPane.setAlignment(button, Pos.TOP_CENTER);
		
		
		Scene scene = new Scene(layout, 600, 600);
		window.setScene(scene);
		window.showAndWait();
}
	public List<Table> addToList(List<Table> listOfPages, int numOfPage, Student student){
		listOfPages.get(numOfPage).data.add(student);
		return (listOfPages);
	}
	
}
