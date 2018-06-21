import Controller.Control;
import Model.Db;
import View.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainClass extends Application{
	
	public static void main(String[] args) {
	       launch(args);
	   }
	
	public void start(Stage primaryStage){
	Db dataBase = new Db();
	Control controller = new Control(dataBase);
	controller.createWindows(primaryStage);
	}
}
