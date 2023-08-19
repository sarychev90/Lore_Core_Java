package best.project.lore.model;

public class Person {
	
	private int yearOfBirth;
	private int yearOfDeath;

	public Person(int yearOfBirth, int yearOfDeath) {
		this.yearOfBirth = yearOfBirth;
		this.yearOfDeath = yearOfDeath;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getYearOfDeath() {
		return yearOfDeath;
	}

	public void setYearOfDeath(int yearOfDeath) {
		this.yearOfDeath = yearOfDeath;
	}

	@Override
	public String toString() {
		return "Person [yearOfBirth=" + yearOfBirth + ", yearOfDeath=" + yearOfDeath + "]";
	}

}
