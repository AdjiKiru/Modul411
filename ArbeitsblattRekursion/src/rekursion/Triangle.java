package rekursion;

public class Triangle {
    int width;

    public Triangle(int aWidth) {
        width = aWidth;
    }
    
    public int getArea(){
        if(width == 1){ return 1; }
        if(width <= 0){ return 0; }
        Triangle smallerTriangle = new Triangle(width - 1);
        int smallerArea = smallerTriangle.getArea();
        return smallerArea + width;
    }
}
