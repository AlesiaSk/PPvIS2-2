package Controller;

import java.util.List;

import Model.Db;
import Model.Student;
import javafx.stage.Stage;
import View.MainWindow;

public class Control {

	public Db dataBase = new Db();
	
	public Control(Db database) {
        this.dataBase = database;
        
}

	public List<Student> getStud() {
		return dataBase.getStud();
	}

	public Student getOne(int index) {
		return dataBase.getOne(index);
	}

	public void addStud(Student student) {
		dataBase.addStud(student);
	}

	public void deleteStud(Student student) {
		dataBase.deleteStud(student);
	}

	public void createWindows(Stage primaryStage) {
		MainWindow main = new MainWindow();
		main.start(primaryStage);
	}
}
