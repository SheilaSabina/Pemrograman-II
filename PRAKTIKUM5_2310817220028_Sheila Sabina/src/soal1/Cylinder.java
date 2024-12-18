package soal1;

public class Cylinder extends Shape{
    private final Double radius;
    private final Double height;

    public Cylinder(Double r, Double h){
        super("Cylinder");
        radius = r;
        height = h;
    }

    public Double area(){return Math.PI*(radius*radius)*height;}
    public String toString(){return super.toString() + " of radius " + radius + " and height " + height;}
}