package Model;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import View.Table;

import View.MainWindow;
public class Save {
	public void main(String argv[], String addStudent, List<Table> listOfPages, int numOfPage) {

		  try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("tableInfos");
			doc.appendChild(rootElement);
			for (int i = 0; i < listOfPages.get(numOfPage).data.size(); i ++) {
			
			Element staff = doc.createElement("student");
			rootElement.appendChild(staff);

			
			Element first = doc.createElement("studentName");
			String student = listOfPages.get(numOfPage).data.get(i).getStud();
			String[] stud = student.split(" ");
			first.appendChild(doc.createTextNode(stud[0]));
			staff.appendChild(first);
			
			Element second = doc.createElement("studentSecName");
			second.appendChild(doc.createTextNode(stud[1]));
			staff.appendChild(second);
			
			Element third = doc.createElement("studentSurname");
			String sur = stud[2];
			third.appendChild(doc.createTextNode(sur));
			staff.appendChild(third);
			
			String parent = listOfPages.get(numOfPage).data.get(i).getParent();
			String[] par = parent.split(" ");
			
			Element fourth = doc.createElement("parentName");
			fourth.appendChild(doc.createTextNode(par[0]));
			staff.appendChild(fourth);

			
			Element fifth = doc.createElement("parentSecName");
			fifth.appendChild(doc.createTextNode(par[1]));
			staff.appendChild(fifth);

			
			Element sixth = doc.createElement("parentSurname");
			sixth.appendChild(doc.createTextNode(par[2]));
			staff.appendChild(sixth);

			String addr = listOfPages.get(numOfPage).data.get(i).getAddr();
			String[] addrs = addr.split(",");
			
			Element seventh = doc.createElement("country");
			seventh.appendChild(doc.createTextNode(addrs[0]));
			staff.appendChild(seventh);
			
			
			Element eighth = doc.createElement("city");
			eighth.appendChild(doc.createTextNode(addrs[1]));
			staff.appendChild(eighth);

			
			Element nineth = doc.createElement("street");
			nineth.appendChild(doc.createTextNode(addrs[2]));
			staff.appendChild(nineth);
			
			Element tenth = doc.createElement("house");
			tenth.appendChild(doc.createTextNode(addrs[3]));
			staff.appendChild(tenth);

			String job = listOfPages.get(numOfPage).data.get(i).getJob();
			
			Element eleventh = doc.createElement("job");
			eleventh.appendChild(doc.createTextNode(job));
			staff.appendChild(eleventh);

			
			Element twelvth = doc.createElement("exp");
			twelvth.appendChild(doc.createTextNode(listOfPages.get(numOfPage).data.get(i).getExp()));
			staff.appendChild(twelvth);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			String file = addStudent + ".xml";
			StreamResult result = new StreamResult(new File("C:\\Users\\Алеся\\eclipse-workspace\\SecondLabPpv\\" + file));

			

			transformer.transform(source, result);

			
			}
			System.out.println("File saved!");
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		  
		}
	
}
