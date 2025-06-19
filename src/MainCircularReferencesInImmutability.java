
public class MainCircularReferencesInImmutability {
    public static void main(String[] args) {
        Human alice = new Human("Alice", null);
        Human bob = new Human("Bob", alice);
    }
}

final class Human {
    private final String name;
    private final Human bestFriend;

    public Human(String name, Human bestFriend) {
        this.name = name;
        this.bestFriend = bestFriend;
    }
}