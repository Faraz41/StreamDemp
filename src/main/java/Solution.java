import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maleOnly(Person.persons()));
        names(Person.persons()).forEach(System.out::println);
        sortedByIncomeDesc().forEach(System.out::println);
        System.out.println("Distinct Genders"+distinctGenders());
        System.out.println("First 3 people on the List");
        firstThreePeople().forEach(System.out::println);


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
}
