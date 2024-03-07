package part11._exceptions;

public class CatchingExceptions {
    public static void main(String[] args) {
        Person legal = new Person("John", 5);
        try {
            Person illegal = new Person("Mary", -1);
        } catch (IllegalArgumentException x) {
            System.out.println("argument wrong!");
        }
    }
}
