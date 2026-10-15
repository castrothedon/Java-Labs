import org.w3c.dom.css.Rect;


class Rectangle {
    double width;
    double height;

    double area() {
        return width * height;
    }

    double perimeter() {
        return 2 * (width + height);
    }
}

public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[5];

        rectangles[0] = new Rectangle();
        rectangles[0].width = 2;
        rectangles[0].height = 3;

        rectangles[1] = new Rectangle();
        rectangles[1].width = 5;
        rectangles[1].height = 4;

        rectangles[2] = new Rectangle();
        rectangles[2].width = 3;
        rectangles[2].height = 6;

        rectangles[3] = new Rectangle();
        rectangles[3].width = 7;
        rectangles[3].height = 2;

        rectangles[4] = new Rectangle();
        rectangles[4].width = 8;
        rectangles[4].height = 5;

        Rectangle largest = rectangles[0];

        for (int i = 1; i < rectangles.length; i++) {
            if (rectangles[i].area() > largest.area()) {
                largest = rectangles[i];
            }
        }

        System.out.println("Largest width: " + largest.width);
        System.out.println("Largest height: " + largest.height);
        System.out.println("Largest area: " + largest.area());
        System.out.println("Perimeter: " + largest.perimeter());
    }
}


