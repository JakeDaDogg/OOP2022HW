

public class ShapeFactory {
	public enum Type{
		Circle, Square, Triangle;
	}
	public Shape createShape(ShapeFactory.Type shapeType, double length ) {
		Shape model;
		switch(shapeType) {
		case Square:
			model =  new Square(length);
			break;
		case Circle:
			model =  new Circle(length);
			break;
		case Triangle:
			model = new Triangle(length);
			break;
		default:
			model = null;
		
		}
		return model;
	}
}
