package Controller;

import java.util.List;

import Model.Search;
import Model.Student;
import View.MainWindow;
import View.Table;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class Delete {
	public  ObservableList<Student> deleteFromTable(String type, TableView table, String t, List<Table> listOfPages, int numOfPage) {
		Search search = new Search();
		ObservableList<Student> sortedData = search.tableSearch(table, type, t, listOfPages, numOfPage);
		int size = listOfPages.get(numOfPage).data.size();
		int sortSize = sortedData.size();
		System.out.println(sortSize);
		System.out.println(size);
		for (int i = 0; i < sortSize; i++) {
			for (int k = 0; k < listOfPages.get(numOfPage).data.size(); k++) {
				if(listOfPages.get(numOfPage).data.get(k).equals(sortedData.get(i))) {
					listOfPages.get(numOfPage).data.remove(k);
					//MainWindow.numOfRecords -= 1;
					if (k == 0) {
						k = -1;
					}
					else{
					k--;
					}
				}
			}
		}
		 //MainWindow.numOfDel += sortSize;
		 //MainWindow.label.setText("Было удалено: " + MainWindow.numOfDel);
		// MainWindow.lNumOfRec.setText("Всего записей: " + String.valueOf(numOfRecords));
		
		 return listOfPages.get(numOfPage).data;
		}
}
