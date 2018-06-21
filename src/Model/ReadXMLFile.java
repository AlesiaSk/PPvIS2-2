package Model;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Controller.Control;
import View.AddWindow;
import View.MainWindow;
import View.Table;

import javafx.scene.control.Label;


public class ReadXMLFile {
	  List<String> studentsNames = new Vector<String>();
	  List<String> studentsSecNames = new Vector<String>();
	  List<String> studentsSurnames = new Vector<String>();
	  List<String> parentsNames = new Vector<String>();
	  List<String> parentsSecNames = new Vector<String>();
	  List<String> parentsSurnames = new Vector<String>();
	  List<String> countries = new Vector<String>();
	  List<String> cities = new Vector<String>();
	  List<String> streets = new Vector<String>();
	  List<String> houses = new Vector<String>();
	  List<String> jobs = new Vector<String>();
	  List<String> exps= new Vector<String>();
	  Db data = new Db();
	  Control controller = new Control(data);
	  String fileName;
	  Label lNumOfRec;
	  List<Table> listOfPages;
	  int numOfPage;
	  int numOfRecords;
	  String numOfRec;
	  
	  public ReadXMLFile(String fileName, Label lNumOfRec, List<Table> listOfPages, int numOfPage, int numOfRecords, String numOfRec) {
		  this.fileName = fileName;
		  this.lNumOfRec = lNumOfRec;
		  this.listOfPages = listOfPages;
		  this.numOfPage = numOfPage;
		  this.numOfRecords = numOfRecords;
		  this.numOfRec = numOfRec;
	  }
	 
	public void main(String[] args, ReadXMLFile read, String fileName, Label lNumOfRec, List<Table> listOfPages, int numOfPage, int numOfRecords, String numOfRec) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = null;
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultHandler handler = new DefaultHandler() {
			boolean bfirst = false;
			boolean bsecond = false;
			boolean bthird = false;
			boolean bfourth = false;
			boolean bfifth = false;
			boolean bsixth = false;
			boolean bseventh= false;
			boolean beighth = false;
			boolean bnineth = false;
			boolean btenth = false;
			boolean beleventh = false;
			boolean btwelvth= false;
			
			public void startElement(String uri, String localName, String a, Attributes attrib) throws SAXException{
				if(a.equals("studentName")) {
					bfirst = true;
				}
				if(a.equals("studentSecName")) {
					bsecond = true;
				}
				if(a.equals("studentSurname")) {
					bthird = true;
				}
				if(a.equals("parentName")) {
					bfourth = true;
				}
				if(a.equals("parentSecName")) {
					bfifth = true;
				}
				if(a.equals("parentSurname")) {
					bsixth = true;
				}
				if(a.equals("country")) {
					bseventh = true;
				}
				if(a.equals("city")) {
					beighth= true;
				}
				if(a.equals("street")) {
					bnineth = true;
				}
				if(a.equals("house")) {
					btenth = true;
				}
				if(a.equals("job")) {
					beleventh = true;
				}
				if(a.equals("exp")) {
					btwelvth = true;
				}
			}
			
			public void endElement (String uri, String localName, String a) throws SAXException{
			}
			
				public void characters(char ch[], int start, int length) throws SAXException{
					
					if(bfirst) {
						read.studentsNames.add(new String(ch, start, length));
						bfirst = false;
					}
					if(bsecond) {
						read.studentsSecNames.add(new String(ch, start, length));
						bsecond = false;
					}
					if(bthird) {
						read.studentsSurnames.add(new String(ch, start, length));
						bthird = false;
					}
					if(bfourth) {
						read.parentsNames.add(new String(ch, start, length));
						bfourth = false;
					}
					if(bfifth) {
						read.parentsSecNames.add(new String(ch, start, length));
						bfifth = false;
					}
					if(bsixth) {
						read.parentsSurnames.add(new String(ch, start, length));
						bsixth = false;
					}
					if(bseventh) {
						read.countries.add(new String(ch, start, length));
						bseventh = false;
					}
					if(beighth) {
						read.cities.add(new String(ch, start, length));
						beighth = false;
					}
					if(bnineth) {
						read.streets.add(new String(ch, start, length));
						bnineth = false;
					}
					if(btenth) {
						read.houses.add(new String(ch, start, length));
						btenth = false;
					}
					if(beleventh) {
						read.jobs.add(new String(ch, start, length));
						beleventh = false;
					}
					if(btwelvth) {
						read.exps.add(new String(ch, start, length));
						btwelvth = false;
					}
					
				}
		};
		try {
			saxParser.parse(read.fileName + ".xml", handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int m = Integer.parseInt(numOfRec);
		int size = listOfPages.get(numOfPage).data.size();
		if (size < m) {
			
			for (int i = 0; i < m - size; i++) {
				Person stud = new Person(read.studentsNames.get(i), read.studentsSecNames.get(i), read.studentsSurnames.get(i));
		   		Person parent = new Person(read.parentsNames.get(i), read.parentsSecNames.get(i), read.parentsSurnames.get(i));
		   		Address adr = new Address(read.countries.get(i), read.cities.get(i), read.streets.get(i), Integer.parseInt(read.houses.get(i)));
		   		Job job = new Job(read.jobs.get(i));
		   		Experience exp = new Experience(Integer.parseInt(read.exps.get(i)));
		   		Student student = new Student(stud, parent, adr, job, exp);
		   		read.controller.addStud(student);
				listOfPages.get(numOfPage).data.add(student);
			}
			numOfRecords += m - size;
		}
		else if (size > m) {
			for (int i = (size - 1); i >= m; i--) {
				listOfPages.get(numOfPage).data.remove(i);
				numOfRecords -= 1;
			}
			
		}
		
		lNumOfRec.setText("Всего записей: " + String.valueOf(numOfRecords));
		
	}

}
