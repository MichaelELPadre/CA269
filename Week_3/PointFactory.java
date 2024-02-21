import java.util.HashMap;

class Point {
    private double x, y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
}

enum Quadrant {
    Q1, // x +ve, y +ve
    Q2, // x -ve, y +ve
    Q3, // x -ve, y -ve
    Q4; // x +ve, y -ve
}

interface GridQuadrant {
    Quadrant getQuadrant(); // return which quadrant the point is in
        // if point is at (0,0) return null
}

interface CompareQuadrant {
    boolean isInSameQuadrant(Point point); // true if given point is
                                            // in the same quadrant as this point
}

interface PointMaker {
    Point makePoint(double x, double y); // returns point with given x,y
    int countPointsCreated(); // returns count of points created via factory
}

class PointFactory implements PointMaker {
    private HashMap<Point, Integer> pointsCreated;
    
    public PointFactory() {
        pointsCreated = new HashMap<>();
    }
    
    @Override
    public Point makePoint(double x, double y) {
        Point point = new Point(x, y);
        pointsCreated.put(point, pointsCreated.getOrDefault(point, 0) + 1);
        return point;
    }
    
    @Override
    public int countPointsCreated() {
        return pointsCreated.size();
    }
}


// Modify Point to implement GridQuadrant and CompareQuadrant
class ModifiedPoint extends Point implements GridQuadrant, CompareQuadrant {
    public ModifiedPoint(double x, double y) {
        super(x, y);
    }
    
    @Override
    public Quadrant getQuadrant() {
        if (getX() == 0 || getY() == 0) return null;
        if (getX() > 0 && getY() > 0) return Quadrant.Q1;
        if (getX() < 0 && getY() > 0) return Quadrant.Q2;
        if (getX() < 0 && getY() < 0) return Quadrant.Q3;
        return Quadrant.Q4;
    }
    
    @Override
    public boolean isInSameQuadrant(Point point) {
        if (point == null) return false;
        if (this.getQuadrant() == null || ((ModifiedPoint) point).getQuadrant() == null) return false;
        return this.getQuadrant() == ((ModifiedPoint) point).getQuadrant();
    }
}