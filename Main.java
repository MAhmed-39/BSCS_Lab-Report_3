public class Main {

    // Point Class
    public static class Point {
        private double x;
        private double y;

        // 1. Default (Null-parameterized) Constructor
        public Point() {
            this.x = 0.0;
            this.y = 0.0;
        }

        // 2. Parameterized Constructor
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // 3. Copy Constructor
        public Point(Point other) {
            this.x = other.x;
            this.y = other.y;
        }

        // Getters
        public double getX() { return x; }
        public double getY() { return y; }

        // Setters
        public void setX(double x) { this.x = x; }
        public void setY(double y) { this.y = y; }

        // Distance calculation helper
        public double distanceTo(Point p) {
            return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
        }

        // toString method
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        // Display method
        public void show() {
            System.out.println(this.toString());
        }
    }

    // Triangle Class
    public static class Triangle {
        private Point p1;
        private Point p2;
        private Point p3;

        // 1. Default (Null-parameterized) Constructor
        public Triangle() {
            this.p1 = new Point(0, 0);
            this.p2 = new Point(1, 0);
            this.p3 = new Point(0, 1);
        }

        // 2. Parameterized Constructor
        public Triangle(Point p1, Point p2, Point p3) {
            // Defensive copy to preserve encapsulation
            this.p1 = new Point(p1);
            this.p2 = new Point(p2);
            this.p3 = new Point(p3);
        }

        // 3. Copy Constructor
        public Triangle(Triangle other) {
            this.p1 = new Point(other.p1);
            this.p2 = new Point(other.p2);
            this.p3 = new Point(other.p3);
        }

        // Getters
        public Point getP1() { return new Point(p1); }
        public Point getP2() { return new Point(p2); }
        public Point getP3() { return new Point(p3); }

        // Setters
        public void setP1(Point p) { this.p1 = new Point(p); }
        public void setP2(Point p) { this.p2 = new Point(p); }
        public void setP3(Point p) { this.p3 = new Point(p); }

        // Side length helpers
        public double getSideA() { return p1.distanceTo(p2); }
        public double getSideB() { return p2.distanceTo(p3); }
        public double getSideC() { return p3.distanceTo(p1); }

        // Validity method
        public boolean isValid() {
            double a = getSideA();
            double b = getSideB();
            double c = getSideC();
            return (a + b > c) && (a + c > b) && (b + c > a);
        }

        // Calculation methods
        public double getPerimeter() {
            return getSideA() + getSideB() + getSideC();
        }

        public double getArea() {
            if (!isValid()) return 0.0;
            double s = getPerimeter() / 2.0;
            double a = getSideA();
            double b = getSideB();
            double c = getSideC();
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        // toString method
        @Override
        public String toString() {
            return "Triangle[p1=" + p1.toString() + 
                   ", p2=" + p2.toString() + 
                   ", p3=" + p3.toString() + "]";
        }

        // Display method
        public void show() {
            System.out.println(this.toString());
            System.out.println("Valid: " + (isValid() ? "Yes" : "No"));
            System.out.println("Perimeter: " + getPerimeter());
            System.out.println("Area: " + getArea());
        }
    }

    public static void main(String[] args) {
        // Creating points
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 3);

        // Creating a triangle
        Triangle t1 = new Triangle(a, b, c);

        System.out.println("--- Triangle 1 Details ---");
        t1.show();

        // Copy Constructor demonstration
        Triangle t2 = new Triangle(t1);
        System.out.println("\n--- Triangle 2 (Copy of Triangle 1) ---");
        t2.show();
    }
}