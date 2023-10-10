import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maleOnly(Person.persons()));
        names(Person.persons()).forEach(System.out::println);


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
}
