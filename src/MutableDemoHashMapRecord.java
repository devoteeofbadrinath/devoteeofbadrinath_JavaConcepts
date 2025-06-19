import java.util.HashMap;

public class MutableDemoHashMapRecord {
    public static void main(String[] args) {
        HashMap<Person, String> map  = new HashMap<>();

        Person key = new Person("Alice", 25);
        map.put(key, "Engineer");

        System.out.println(map.get(key));

        key.setAge(26);

        System.out.println(map.get(key));

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age; // hashcode depends on 'age'
    }
}
