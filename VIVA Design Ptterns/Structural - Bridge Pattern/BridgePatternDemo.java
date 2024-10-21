// Implementor
interface DrawingAPI {
  void drawCircle(double x, double y, double radius);
}

// ConcreteImplementor 1
class DrawingAPI1 implements DrawingAPI {
  public void drawCircle(double x, double y, double radius) {
    System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
  }
}

// ConcreteImplementor 2
class DrawingAPI2 implements DrawingAPI {
  public void drawCircle(double x, double y, double radius) {
    System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
  }
}

// Abstraction
abstract class Shape {
  protected DrawingAPI drawingAPI;

  protected Shape(DrawingAPI drawingAPI) {
    this.drawingAPI = drawingAPI;
  }

  public abstract void draw();

  public abstract void resizeByPercentage(double pct);
}

// RefinedAbstraction
class CircleShape extends Shape {
  private double x, y, radius;

  public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
    super(drawingAPI);
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public void draw() {
    drawingAPI.drawCircle(x, y, radius);
  }

  public void resizeByPercentage(double pct) {
    radius *= pct;
  }
}

// Usage
public class BridgePatternDemo {
  public static void main(String[] args) {
    Shape[] shapes = new Shape[] {
        new CircleShape(1, 2, 3, new DrawingAPI1()),
        new CircleShape(5, 7, 11, new DrawingAPI2()),
    };

    for (Shape shape : shapes) {
      shape.draw();
      shape.resizeByPercentage(2.5);
      shape.draw();
    }
  }
}
