package Model;

import java.util.List;

import View.MainWindow;
import View.SearchWindow;
import View.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;


public class Search {
	
	public  ObservableList<Student> tableSearch(TableView table, String type, String t, List<Table> listOfPages, int numOfPage) {
		
		   ObservableList<Student>  sortedData = FXCollections.observableArrayList();
		   System.out.println(sortedData.size());
	   int size = listOfPages.get(numOfPage).data.size();
	   
     for (int ind = 0; ind < size; ind++) {
      if (type.equals("second")) {
      	String parent = listOfPages.get(numOfPage).data.get(ind).getParent();
      	String addr = listOfPages.get(numOfPage).data.get(ind).getAddr();
      if (parent.contains(t)) {
          sortedData.add(listOfPages.get(numOfPage).data.get(ind)); 
      } else if (addr.contains(t)) {
      	sortedData.add(listOfPages.get(numOfPage).data.get(ind));
      }
      }
     }
     
     for (int ind = 0; ind < size; ind++) {
         if (type.equals("third")) {
      	   String addr = listOfPages.get(numOfPage).data.get(ind).getAddr();
      	   String exp = listOfPages.get(numOfPage).data.get(ind).getExp();
         if (exp.contains(t)) {
             sortedData.add(listOfPages.get(numOfPage).data.get(ind)); 
         } else if (addr.contains(t)) {
         	sortedData.add(listOfPages.get(numOfPage).data.get(ind));
         }
         }
        }
      
     for (int ind = 0; ind < size; ind++) {
         if (type.equals("fourth")) {
      	   String addr = listOfPages.get(numOfPage).data.get(ind).getAddr();
      	   String first = listOfPages.get(numOfPage).data.get(ind).getStud();
             
         if (addr.contains(t)) {
             sortedData.add(listOfPages.get(numOfPage).data.get(ind)); 
         } else if (first.contains(t)) {
         	sortedData.add(listOfPages.get(numOfPage).data.get(ind));
         }
         }
        }
      
     for (int ind = 0; ind < size; ind++) {
         if (type.equals("first")) {
      	   String first = listOfPages.get(numOfPage).data.get(ind).getStud();
         if (first.contains(t)) {
             sortedData.add(listOfPages.get(numOfPage).data.get(ind)); 
         } 
         }
        }


System.out.println(sortedData.size());
return (sortedData);
}
	
	
}
