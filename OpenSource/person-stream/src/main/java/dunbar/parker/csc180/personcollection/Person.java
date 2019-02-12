package dunbar.parker.csc180.personcollection;

public class Person {

	private String firstname, lastname;
	
	private int age, ssn;
	
	public Person() {}
	
	public Person(String firstname, String lastname, int age, int ssn) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setAge(age);
		this.setSsn(ssn);
	}
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		if(firstname == null) {
			throw new IllegalArgumentException("firstname cannot be null");
		}
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		if(lastname == null) {
			throw new IllegalArgumentException("lastname cannot be null");
		}
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 0 || age > 150) {
			throw new IllegalArgumentException("age cannot be less than 0 or greater than 150");
		}
		this.age = age;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	@Override
	public String toString() {
		return "\n" + this.getFirstname() + "," + this.getLastname() + "," + this.getAge() + "," + this.getSsn();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person)obj;
		return this.getFirstname().equals(other.getFirstname()) && this.getLastname().equals(other.getLastname()) && this.getSsn() == other.getSsn();
	}

}
