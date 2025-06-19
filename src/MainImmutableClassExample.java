import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

final class PersonDetails{
    private final String name;
    private final int age;
    private final Date birthDate;
    private final List<String> hobbies;

    public PersonDetails(String name, int age, Date birthDate, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.birthDate = new Date(birthDate.getTime());
        this.hobbies = Collections.unmodifiableList(new ArrayList<>(hobbies));

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthDate() {
        return new Date(birthDate.getTime());
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}

public class MainImmutableClassExample {
    public static void main(String[] args) {
        Date birthDate = new Date();
        List<String> hobbies = new ArrayList<>(List.of("Reading","Gaming"));

        PersonDetails p1 = new PersonDetails("John", 19, birthDate, hobbies);

        birthDate.setTime(0);
        hobbies.add("Cooking");

        System.out.println(p1.getBirthDate());
        System.out.println(p1.getHobbies());
    }
}
