package Model;

public class Person {
	 public String firstName;
	 public String secondName;
	 public String surname;
	    
	    public Person(String fName, String sName, String surName) {
	        this.firstName = new String(fName);
	        this.secondName = new String(sName);
	        this.surname = new String(surName);
	        
}
	    public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String first) {
			this.firstName = first;
		}
		public String getSecondName() {
			return secondName;
		}

		public void setSecondName(String second) {
			this.secondName = second;
		}
		public String getSurname() {
			return surname;
		}

		public void setSurname(String sur) {
			this.surname = sur;
		}
		
}

