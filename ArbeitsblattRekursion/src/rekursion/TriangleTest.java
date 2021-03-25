package rekursion;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    public static void main(String[] args){
        Triangle t = new Triangle(0);
        int area = t.getArea();
        System.out.println("Area: " + area);
        System.out.println("Expected: 55");
    }
}