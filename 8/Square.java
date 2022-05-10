
import java.lang.Math.*;
/**
 * 
 * @author yuhanchiang
 * @version 2022/4/20
 *
 */
public class Square extends Shape{

	public Square(double length) {
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
		double Area = this.length*this.length;
		Area = Math.round(Area*Math.pow(10,2))/Math.pow(10,2);
		// TODO Auto-generated method stub
		return Area;
	}

	@Override
	public double getPerimeter() {
		double Perimeter = this.length*4;
		Perimeter = Math.round(Perimeter*Math.pow(10,2))/Math.pow(10,2);
		// TODO Auto-generated method stub
		return Perimeter;
	}
	
}
