abstract class Shape {
    final int sides = 0; // default values are allowed
    abstract double area(); // MUST be implemented in non-abstract subclasses
    final String name = "Abstract Shape";
    public String toString()
    {
        return this.name;
    }
}

class Point extends Shape {
    final int sides = 1;
    int x;
    int y;
    final String name = "Point";
    double area() {
        return 0.0;
    }
}

class Line extends Shape {
    final int sides = 2;
    int[] start = new int[2];
    int[] end = new int[2];
    final String name = "Line";
    double area() {
        // actual formula is based on y1-y2 = m(x1-x2)
        return (start[0]-end[0]) * (start[1]-end[1]);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Triangle extends Shape {
    final int sides = 3;
    int[][] points = new int[2][3];
    String name = "Triangle";
    double area() {
        // actual formula is 1/2 * height * base
        return (1/2) * points[0][0] * points[2][3];
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.name;
    }
}

public class Shapes {
    public static void main(String args[]){
        Shape shape = new Point();
        System.out.println(shape);

        shape = new Line();
        System.out.println(shape);
        shape = new Triangle();
        System.out.println(shape);
}
}