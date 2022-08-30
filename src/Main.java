import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Sanzhar", 28);
        Person person2 = new Person("Kanykei", 1);
        Person person3 = new Person("Aida", 23);
        Person[] people = {person1, person2, person3};

        System.out.println("NOT SORTED ARRAY:");
        print(people);

        Arrays.sort(people, new ComparatorByName());
        System.out.println("\nSORTED ARRAY WITH CLASS:");
        print(people);

        Comparator<Person> comparator1 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        System.out.println("\nSORTED ARRAY WITH ANONYMOUS CLASS:");
        Arrays.sort(people, comparator1);
        print(people);

        Comparator<Person> comparator2 = (o1, o2) -> o1.getName().compareTo(o2.getName());
        System.out.println("\nSORTED ARRAY WITH LAMBDA (1):");
        Arrays.sort(people, comparator2);
        print(people);

        Comparator<Person> comparator3 = Comparator.comparing(Person::getName);
        System.out.println("\nSORTED ARRAY WITH LAMBDA (2):");
        Arrays.sort(people, comparator3);
        print(people);

    }

    static void print(Person[] people) {
        for (Person p : people) {
            System.out.println(p);
        }
    }
}