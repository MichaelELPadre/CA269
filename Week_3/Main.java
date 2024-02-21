public class Main {
    public static void main(String[] args) {
        PointFactory factory = new PointFactory();
        
        Point p1 = factory.makePoint(1, 1);
        Point p2 = factory.makePoint(-1, 1);
        Point p3 = factory.makePoint(-1, -1);
        Point p4 = factory.makePoint(1, -1);
        
        ModifiedPoint modifiedPoint1 = new ModifiedPoint(1, 1);
        ModifiedPoint modifiedPoint2 = new ModifiedPoint(2, 2);
        ModifiedPoint modifiedPoint3 = new ModifiedPoint(-1, -1);
        
        System.out.println(modifiedPoint1.getQuadrant()); // Q1
        System.out.println(modifiedPoint2.getQuadrant()); // Q1
        System.out.println(modifiedPoint3.getQuadrant()); // Q3
        
        System.out.println(modifiedPoint1.isInSameQuadrant(modifiedPoint2)); // true
        System.out.println(modifiedPoint1.isInSameQuadrant(modifiedPoint3)); // false
        
        System.out.println(p1.getX() == factory.makePoint(1, 1).getX()); // true
        System.out.println(factory.countPointsCreated()); // 4
    }
}
