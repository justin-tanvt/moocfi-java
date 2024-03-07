package part9._inheritance;

interface X {
    default void methodX() {
        System.out.println("X:::methodX");
    }
}

interface Y {
    default void methodX() {
        System.out.println("Y:::methodX");
    }
}

public class DiamondProblem implements X, Y {

    public static void main(String args[]) {
        DiamondProblem z = new DiamondProblem();
        z.methodX();
    }

    @Override
    public void methodX() {
        // solution 1 - create new logic for subclass' methodX()

        // solution 2 - choose one of the interface's methodX()
        // either
        X.super.methodX();
        // or
        Y.super.methodX();
    }
}
