package soal1;
import java.lang.Math;

public class Sphere extends Shape {
	private final double radius;
	
	public Sphere(double r) {
		super("Sphere");
		radius = r;
	}
	
	public Double area() {
		return 4*Math.PI* (radius*radius);
	}
	
	
	public String toString() {
		return super.toString() + " of radius " + radius;
	}

}
