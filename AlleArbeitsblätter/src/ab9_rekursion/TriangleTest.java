package ab9_rekursion;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    public static void main(String[] args){
        ab9_rekursion.Triangle t = new ab9_rekursion.Triangle(0);
        int area = t.getArea();
        System.out.println("Area: " + area);
        System.out.println("Expected: 55");
    }
}