package Lab.Lab6;

interface First {
    default void hello() {
        System.out.println("Hello from First");
    }
}

interface Second {
    default void hello() {
        System.out.println("Hello from Second");
    }
}

class Greeter implements First, Second {
    @Override
    public void hello() {
        First.super.hello();
        Second.super.hello();
        System.out.println("Hello from Greeter");
    }
}

public class DefaultMethodDemo {
    public static void main(String[] args) {
        Greeter g = new Greeter();
        g.hello();
    }
}
    
