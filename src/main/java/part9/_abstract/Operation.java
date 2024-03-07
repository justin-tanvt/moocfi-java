package part9._abstract;

import java.util.Scanner;

public abstract class Operation {

    private String name;

    public Operation(String name) {
        this.name = name;
    }

    // abstract classes can have normal methods (has concrete implementation)
    public String getName() {
        return this.name;
    }

    // and abstract methods (signature only without method body, implementation left to subclasses that inherit)
    public abstract void execute(Scanner scanner);
}
