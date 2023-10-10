import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Person.persons());

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
}
