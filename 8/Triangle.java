import java.lang.Math.*;
/**
 * 
 * @author yuhanchiang
 * @version 2022/4/21
 *
 */
public class Triangle extends Shape{
	public Triangle(double length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setLength(double length) {
		// TODO Auto-generated method stub
		this.length = length;
	}

	@Override
	public double getArea() {
		double Area = (this.length/2)*(this.length/2)*Math.sqrt(3);
		Area = Math.round(Area*Math.pow(10,2))/Math.pow(10,2);
		// TODO Auto-generated method stub
		return Area;
	}

	@Override
	public double getPerimeter() {
		double Perimeter = this.length*3;
		Perimeter = Math.round(Perimeter*Math.pow(10,2))/Math.pow(10,2);
		// TODO Auto-generated method stub
		return Perimeter;
	}

}
