package part11._exceptions;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if (name.isEmpty() || age < 0) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.age = age;
    }
}
