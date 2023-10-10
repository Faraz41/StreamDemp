import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maleOnly(Person.persons()));
        names(Person.persons()).forEach(System.out::println);
        sortedByIncomeDesc().forEach(System.out::println);
        System.out.println("Distinct Genders"+distinctGenders());
        System.out.println("First 3 people on the List");
        firstThreePeople().forEach(System.out::println);
        System.out.println("list of People. Skipping First two People");
        skippedPeople().forEach(System.out::println);
        System.out.println("Person's Income Greater than 8,000"+anyPersonWithHighIncome());

        System.out.println(personWithHighestIncome());
        if (personWithHighestIncome().isPresent()){
            Person p = personWithHighestIncome().get();
            System.out.println("Person with highest income is ");
        }

    }
    // Filter the list of person to includes only males.
    static List<String> maleOnly(List<Person> people){
        people = Person.persons();
        List<String>males = people.stream()
                .filter(Person::isMale)
                .map(Person::getName)
        .toList();
        return males;
    }
    //Map the llist of persons to their names.
    static  List<String> names (List<Person> people){
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();
        return names;
    }
    //Sort the list of persons by their income in descending order.
    static List<Person> sortedByIncomeDesc(){
        List<Person> sortedList = Person.persons()
                .stream()
                .sorted(Comparator.comparing(Person::getIncome).reversed())
                .toList();
        return sortedList;
    }
    //Find the distinct genders in the list of persons.
    static List<Person.Gender> distinctGenders(){
        List<Person.Gender> genders = Person.persons()
                .stream()
                .map(Person::getGender)
                .distinct()
                .toList();
        return genders;
    }

    //- Limit the list of persons to the first 3.
    static List<Person> firstThreePeople(){
        List<Person> top3 = Person.persons()
                .stream()
                .limit(3)
                .toList();
        return top3;
    }
    // - Skip the first 2 persons in the list.
    static List<Person> skippedPeople(){
        List<Person> skipped = Person.persons()
                .stream()
                .skip(2)
                .toList();
        return skipped;
    }
    //- Use peek to print the names of all persons in the list.
    static void displayName(){
        Person.persons()
                .stream()
                .peek(person -> System.out.println("Person Name"+person.getName()))
                .forEach(System.out::println);


    }
    // to check if any person's income is greater than 8,000.0

    static boolean anyPersonWithHighIncome (){
    return        Person.persons()
                .stream()
                .anyMatch(p -> p.getIncome()>8000 );
    }
    //
    static boolean isAllPeopleAreMale (){
    return  Person.persons()
                .stream()
                .allMatch(p -> p.getGender() == Person.Gender.MALE);
        /* .allMatch(Person::isMale); */
    }
    static boolean noneHaveZeroIncome (){
    return     Person.persons()
                .stream()
                .noneMatch(p->p.getIncome()==0);
    }
    // To count the number of persons
    static long countFemale(){
    return     Person.persons()
                .stream()
                .filter(Person::isFemale)
                .count();
    }

    static Optional<Person> personWithHighestIncome(){
    return     Person.persons()
                .stream()
                .max(Comparator.comparingDouble(Person::getIncome));
    }

}
