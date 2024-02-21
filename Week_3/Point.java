interface Order {
     public boolean lessThan(Order other);
 }
 interface Comparable {
     public int compareTo(Object object);
 }

public class Point implements Comparable{
    private double x, y;

    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public boolean equals(Point other) {
        if (this.x == other.x && this.y == other.y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lessThan(Point other) {
        if (this.equals(other)) {
            return false;
        } else if (x > other.x) {
            return false;
        } else if (y > other.y) {
            return false;
        }
        return true;

    }
    public boolean lessThan(Order other) {
        if (other instanceof Point) {
            return lessThan((Point) other);
        } else {
            return true;
        }
    }

    public int compareTo(Object object) {
        if (!(object instanceof Point)) {
            return 0;
        }
        Point other = (Point) object;
        if (this.equals(other)) {
            return 0;
        } else if (this.lessThan(other)) {
            return -1;
        } else {
            return 1;
        }
    }


    // getters
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        
    }
}c