package trials.module1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MainComparator {

	public static void main(String[] args) {
		List<Person> lstPerson = new ArrayList<Person>() {
			{
				add(new Person("p1", "p11", 29));
				add(new Person("p2", "p12", 32));
				add(new Person("p3", "p13", 15));
				add(new Person("p4", "p14", 37));
				add(new Person("p5", "p15", 45));
				add(new Person("p6", "p16", 18));
			}
		};

		
		Comparator<Person> compAge1 = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return Integer.compare(p1.getAge(), p2.getAge());
			}
		};

		Comparator<Person> compAge2 = (Person p1, Person p2) -> p1.getAge() - p2.getAge();

		Comparator<Person> compAge3 = (p1, p2) -> p1.getAge() - p2.getAge();


		Function<Person, Integer> f1 = new Function<Person, Integer>() {
			@Override
			public Integer apply(Person p) {
				return p.getAge();
			}
		};

		Function<Person, Integer> f2 = p -> p.getAge();
		

		Comparator<Person> compAge4 = Comparator.comparing(Person::getAge);
		
		Person[] arrPerson = new Person[lstPerson.size()];

		arrPerson = lstPerson.toArray(arrPerson);
		Arrays.sort(arrPerson, compAge4);
		System.out.println(Arrays.toString(arrPerson));
	}

}
