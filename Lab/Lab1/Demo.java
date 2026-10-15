public class Demo {
    static class Rectangle {
    double width;
    double height;
}

public static class ReferenceDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 10;
        r1.height = 5;

        Rectangle r2 = r1;

        r2.width = 20;

        System.out.println("r1 width: " + r1.width);
        System.out.println("r2 width: " + r2.width);
    }
}
    
}
