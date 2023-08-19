package best.project.lore.algorithms.task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import best.project.lore.model.Person;

class PeopleLifeYearsTest {

	@Test
	void peopleLifeYearsTest() {
		
		List<Person> persons = Stream.generate(()-> createPerson(1800, 100)).limit(100).collect(Collectors.toList());

		System.out.println("Persons before sort: " + persons);
		Collections.sort(persons, Comparator.comparing(Person::getYearOfBirth));
		System.out.println("Persons after sort:  " + persons);
		
		int[] years = new int[2000];
		persons.forEach(p -> {
			years[p.getYearOfBirth()]++;
			years[p.getYearOfDeath()]--;
		});
		System.out.print("Years abs difference:  ");
		for(int i = 1800; i < 2000;i++) {
			System.out.print(i + (years[i] < 0 ? "= ": " = ") + years[i]+", ");
		}
		int cumulativeDifference = 0;
		int maxDiff = 0;
		int indexMaxDiff = 0;
		
		System.out.print("\nCumulative difference: ");
		for(int i = 0; i < 2000;i++) {
			cumulativeDifference += years[i];
			if(i >= 1800) {
				System.out.print(i + (cumulativeDifference > 9 ? "= ": " = ")+ cumulativeDifference + ", ");
			}
			if(cumulativeDifference >= maxDiff) {
				maxDiff = cumulativeDifference;
				indexMaxDiff = i;
			}
		}
		System.out.println("\nMax persons live in: " + indexMaxDiff);
		System.out.println("Max cumulative difference: " + maxDiff);
	}
	
	private Person createPerson(int minYearOfBirth, int maxYearsOfLife) {
		int yearOfBirth = minYearOfBirth + new Random().nextInt(maxYearsOfLife);
		int yearOfDeath = yearOfBirth + new Random().nextInt(maxYearsOfLife);
		return new Person(yearOfBirth, yearOfDeath);
	}

}
