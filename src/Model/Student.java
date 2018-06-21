package Model;

public class Student {
	public Person stud;
	public Person parent;
	public Address addr;
	public Job job;
	public Experience exp;
	
	public Student(Person stud2, Person parent2, Address adr, Job job2, Experience exp2) {
		this.stud = stud2;
		this.parent = parent2;
		this.addr = adr;
		this.job = job2;
		this.exp = exp2;
	}

	public String getStud() {
		return (stud.getFirstName()+" "+ stud.getSecondName()+ " " + stud.getSurname());
	}

	public void setStud(Person stud) {
		this.stud = stud;
	}
	
	public String getParent() {
		return (parent.getFirstName()+" "+ parent.getSecondName()+ " " + parent.getSurname());
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}
	
	public String getAddr() {
		return (addr.getCountry() + "," + addr.getCity() + ","+ addr.getSreet() + ","+ addr.getNumOfHouse());
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	public String getJob() {
		return (job.getJob());
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	public String getExp() {
		return (Integer.toString(exp.getYear()));
	}

	public void setExp(Experience exp) {
		this.exp = exp;
	}

}
